package fr.istic.m1.aco.miniediteur.v3.invoker;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import fr.istic.m1.aco.miniediteur.v3.command.Command;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Class IHMImpl implementant IHM, Observer et divers Listeners
 */
public class IHMImpl implements IHM, Observer, ActionListener,  KeyListener, CaretListener {

	private JFrame frame;
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu menuFichier;
	private JMenuItem quitter;
	private JMenu menuEdition;
	private JMenuItem refaire;
	private JMenuItem defaire;
	private JMenuItem copier;
	private JMenuItem couper;
	private JMenuItem coller;
	private JMenu menuEnregistrement;
	private JMenuItem demarrer;
	private JMenuItem stopper;
	private JMenuItem rejouer;
	private JMenu menuHelp;
	private JMenuItem about;
	private JTextArea texte;
	private JScrollPane scrollPane;
	private JPanel bas;
	private JLabel longueur;
	private JLabel enregistrement;


	private Map<String, Command> commands;

	private char lastChar;
	
	private boolean inUpdate;

	/**
	 * Constructeur de l'IHMImpl
	 */
	public IHMImpl() {
		this.frame = new JFrame("Editeur V3");
		this.frame.setIconImage(this.frame.getToolkit().getImage(getClass().getResource("/editeur.png")));
		this.inUpdate = false;
	}

	@Override
	public void creer() {
		this.creerMenu();
		this.creerPanel();
		this.creerTextArea();
		this.creerBas();
	}

	@Override
	public void afficher() {
		this.frame.pack();
		this.frame.setVisible(true);
		this.frame.setResizable(false);
		this.frame.setSize(600, 330);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Setters
	 */

	@Override
	public void setCommands(Map<String, Command> commands) throws Exception {
		// On verifie que toutes les commandes sont bien presentes
		String[] listeCommandes = {"Coller", "Copier","Couper", "SaisirTexte", "Selectionner", "SupprimerArriere", "SupprimerAvant"};
		for(final String value: listeCommandes) {
			if(!commands.containsKey(value))	 {
				throw new Exception("Commande manquante : '" + value + "'");
			}	     
		}
		// Si pas d'exception alors on enregistre les commandes
		this.commands = commands;
	}

	/**
	 * Fin des Setters
	 */

	/**
	 * Getters
	 */

	@Override
	public int getSelectionDebut() {
		return this.texte.getSelectionStart();

	}

	@Override
	public int getSelectionFin() {
		return this.texte.getSelectionEnd();

	}

	@Override
	public char getDernierCaractere() {
		return this.lastChar;

	}

	/**
	 * Fin des Getters
	 */

	/**
	 * Events
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.copier) {
			this.commands.get("Copier").execute();
		} else if(e.getSource() == this.couper) {
			this.commands.get("Couper").execute();
		} else if(e.getSource() == this.coller) {
			this.commands.get("Coller").execute();
		} else if(e.getSource() == this.demarrer) {
			this.enregistreurDemarrer();
		} else if(e.getSource() == this.stopper) {
			this.enregistreurStopper();
		} else if(e.getSource() == this.rejouer) {
			this.enregistreurRejouer();
		} else if(e.getSource() == this.quitter) {
			System.exit(0);
		} else if(e.getSource() == this.about) {
			this.chargerAbout();
		} else if(e.getSource() == this.defaire) {
			this.commands.get("Defaire").execute();
		} else if(e.getSource() == this.refaire) {
			this.commands.get("Refaire").execute();
		} else {
			System.out.println("Action inconnue : "+e.getSource());
		}

	}

	/**
	 * On charge une petite Frame contenant des informations sur ce moteur d'edition
	 */
	private void chargerAbout() {
		JFrame frameAbout = new JFrame("A propos");
		frameAbout.pack();
		frameAbout.setVisible(true);
		frameAbout.setResizable(false);
		frameAbout.setSize(200, 150);
		frameAbout.setLocationRelativeTo(this.frame);
		JTextArea texteAbout = new JTextArea();
		texteAbout.setText("Moteur d'Edition V3\nDéveloppé par :\nXavier Lecoq\nAymen Hafsi\n\nProjet d'ACO\nMIAGE - RENNES 1 - 2013");
		texteAbout.setLineWrap(true);
		texteAbout.setEditable(false);
		frameAbout.add(texteAbout);
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		if(!this.inUpdate)
			this.commands.get("Selectionner").execute();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			// Traitement spécial si touche "supprimer arrière"
			this.commands.get("SupprimerArriere").execute();
			e.consume();
		} else if(e.getKeyCode() == KeyEvent.VK_DELETE) {
			// Traitement spécial si touche "supprimer"
			this.commands.get("SupprimerAvant").execute();
			e.consume();
		} else if(e.getKeyChar() == KeyEvent.CHAR_UNDEFINED) {
			// On ne fait rien c'est un caractere non imprimable
		} else {
			this.lastChar = e.getKeyChar();
			this.commands.get("Selectionner").execute();
			this.commands.get("SaisirTexte").execute();
			e.consume();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		e.consume();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		e.consume();
	}

	/**
	 * Fin des Events
	 */

	/**
	 * Observer
	 */

	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof String) {
			// Si c'est une String c'est que le texte doit être mis à jour
			this.inUpdate = true;
			this.texte.setText((String) arg);
			this.inUpdate = false;
			this.longueur.setText("Longueur : "+this.texte.getText().length());

		}
		if(arg instanceof Integer) {
			// Si c'est un Integer c'est qu'il faut mettre à jour la position du curseur
			this.texte.setCaretPosition((int) arg);
			this.texte.moveCaretPosition((int) arg);
		}
	}

	/**
	 * Fin de l'Observer
	 */
	
	/**
	 * Creation des elements
	 */

	/**
	 * Methode qui cree une zone de texte editable dans l'IHM.
	 */
	public void creerTextArea() {
		this.texte = new JTextArea();
		this.texte.addKeyListener(this);
		this.texte.addCaretListener(this);
		this.texte.setLineWrap(true);
		this.scrollPane = new JScrollPane(this.texte, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.panel.add(this.scrollPane, BorderLayout.CENTER);
	}

	/**
	 * Methode qui cree tous les elements du Menu
	 */
	public void creerMenu() {
		this.menuBar = new JMenuBar();

		// Menu Fichier
		this.menuFichier = new JMenu("Fichier");

		this.quitter = new JMenuItem("Quitter");
		this.quitter.addActionListener(this);
		this.menuFichier.add(this.quitter);

		this.menuBar.add(this.menuFichier);


		// Menu Edition
		this.menuEdition = new JMenu("Edition");
		this.defaire = new JMenuItem("Annuler", new ImageIcon(getClass().getResource("/defaire.png")));
		this.defaire.addActionListener(this);
		this.menuEdition.add(this.defaire);
		
		this.refaire = new JMenuItem("Rétablir", new ImageIcon(getClass().getResource("/refaire.png")));
		this.refaire.addActionListener(this);
		this.menuEdition.add(this.refaire);
		
		this.menuEdition.addSeparator();
		
		this.copier = new JMenuItem("Copier", new ImageIcon(getClass().getResource("/copier.png")));
		this.copier.addActionListener(this);
		this.menuEdition.add(this.copier);

		this.couper = new JMenuItem("Couper", new ImageIcon(getClass().getResource("/couper.png")));
		this.couper.addActionListener(this);
		this.menuEdition.add(this.couper);

		this.coller = new JMenuItem("Coller", new ImageIcon(getClass().getResource("/coller.png")));
		this.coller.addActionListener(this);
		this.menuEdition.add(this.coller);

		this.menuBar.add(this.menuEdition);
		// Fin Menu Edition
		
		// Menu Enregistrement
		this.menuEnregistrement = new JMenu("Enregistrement");
		
		this.demarrer = new JMenuItem("Démarrer");
		this.demarrer.addActionListener(this);
		this.menuEnregistrement.add(this.demarrer);

		this.stopper = new JMenuItem("Stopper");
		this.stopper.addActionListener(this);
		this.stopper.setEnabled(false);
		this.menuEnregistrement.add(this.stopper);
		
		this.rejouer = new JMenuItem("Rejouer");
		this.rejouer.addActionListener(this);
		this.rejouer.setEnabled(false);
		this.menuEnregistrement.add(this.rejouer);

		this.menuBar.add(this.menuEnregistrement);

		// Fin Menu Enregistrement

		// Menu Help
		this.menuHelp = new JMenu("?");
		this.about = new JMenuItem("A propos");
		this.about.addActionListener(this);

		this.menuHelp.add(this.about);
		this.menuBar.add(this.menuHelp);
		// Fin Menu Help

		this.frame.setJMenuBar(this.menuBar);
	}
	
	/**
	 * Methode qui cree le panel
	 */
	private void creerPanel() {
		this.panel = new JPanel(new BorderLayout());
		this.frame.add(this.panel);		
	}
	
	/**
	 * Methode qui cree le bas du panel
	 */
	public void creerBas() {
		this.bas = new JPanel(new BorderLayout());
		this.enregistrement = new JLabel();
		this.longueur = new JLabel("Longueur : "+this.texte.getText().length());
		this.bas.add(this.enregistrement, BorderLayout.EAST);
		this.bas.add(this.longueur, BorderLayout.WEST);
		this.panel.add(this.bas, BorderLayout.SOUTH);

	}
	
	
	/**
	 * Fin de la creation des elements
	 */

	
	/**
	 * Actions de l'Enregistreur
	 */
	
	/**
	 * Action effectuee lors d'un clic sur le bouton Rejouer
	 */
	private void enregistreurRejouer() {
		this.commands.get("EnregistreurRejouer").execute();
	}

	
	/**
	 * Action effectuee lors d'un clic sur le bouton Stopper
	 */
	private void enregistreurStopper() {
		this.commands.get("EnregistreurStopper").execute();
		this.demarrer.setEnabled(true);
		this.stopper.setEnabled(false);
		this.rejouer.setEnabled(true);		
		this.enregistrement.setText("");
	}

	/**
	 * Action effectuee lors d'un clic sur le bouton Demarrer
	 */
	private void enregistreurDemarrer() {
		this.demarrer.setEnabled(false);
		this.stopper.setEnabled(true);
		this.rejouer.setEnabled(false);		
		this.commands.get("EnregistreurDemarrer").execute();
		this.enregistrement.setText("Enregistrement en cours...");
	}
	
	/**
	 * Fin des actions de l'Enregistreur
	 */
}
