package fr.istic.m1.aco.miniediteur.v3.client;

import java.util.Hashtable;
import java.util.Map;

import fr.istic.m1.aco.miniediteur.v3.caretaker.Enregistreur;
import fr.istic.m1.aco.miniediteur.v3.caretaker.EnregistreurImpl;
import fr.istic.m1.aco.miniediteur.v3.client.Client;
import fr.istic.m1.aco.miniediteur.v3.command.Coller;
import fr.istic.m1.aco.miniediteur.v3.command.Command;
import fr.istic.m1.aco.miniediteur.v3.command.Copier;
import fr.istic.m1.aco.miniediteur.v3.command.Couper;
import fr.istic.m1.aco.miniediteur.v3.command.Defaire;
import fr.istic.m1.aco.miniediteur.v3.command.EnregistreurDemarrer;
import fr.istic.m1.aco.miniediteur.v3.command.EnregistreurRejouer;
import fr.istic.m1.aco.miniediteur.v3.command.EnregistreurStopper;
import fr.istic.m1.aco.miniediteur.v3.command.Refaire;
import fr.istic.m1.aco.miniediteur.v3.command.SaisirTexte;
import fr.istic.m1.aco.miniediteur.v3.command.Selectionner;
import fr.istic.m1.aco.miniediteur.v3.command.SupprimerArriere;
import fr.istic.m1.aco.miniediteur.v3.command.SupprimerAvant;
import fr.istic.m1.aco.miniediteur.v3.invoker.IHM;
import fr.istic.m1.aco.miniediteur.v3.invoker.IHMImpl;
import fr.istic.m1.aco.miniediteur.v3.receiver.GestionDefaire;
import fr.istic.m1.aco.miniediteur.v3.receiver.ME;
import fr.istic.m1.aco.miniediteur.v3.receiver.MEImpl;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Class Editeur
 */
public class Client {

	private Map<String, Command> commands;

	private ME me;
	
	private IHM ihm;
	
	private Enregistreur enregistreur;
	
	private GestionDefaire gd;

	/**
	 * Constructeur d'Editeur
	 */
	public Client() {
		this.me = new MEImpl();
		this.ihm = new IHMImpl();
		this.enregistreur = new EnregistreurImpl();
		this.gd = new GestionDefaire(this.me);
				
		// On creer les commandes et on les transmet a l'IHM
		this.addAllCommands();
		try {
			this.ihm.setCommands(this.commands);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// On ajoute l'Observer a l'Observeable
		this.me.addObserver(this.ihm);
		


		// Creation de l'IHM
		this.ihm.creer();
		this.ihm.afficher();
	}
	
	/**
	 * Methode qui ajoute toutes les Commandes dans une Hashtable.
	 */
	public void addAllCommands() {
		this.commands = new Hashtable<String, Command>();
		this.commands.put("Copier", new Copier(this.me, this.enregistreur, this.gd));
		this.commands.put("Coller", new Coller(this.me, this.enregistreur, this.gd));
		this.commands.put("Couper",new Couper(this.me, this.enregistreur, this.gd));
		this.commands.put("Selectionner",new Selectionner(this.me, this.ihm, this.enregistreur));
		this.commands.put("SaisirTexte", new SaisirTexte(this.me, this.ihm, this.enregistreur, this.gd));
		this.commands.put("SupprimerAvant", new SupprimerAvant(this.me, this.enregistreur, this.gd));
		this.commands.put("SupprimerArriere", new SupprimerArriere(this.me, this.enregistreur, this.gd));
		// Enregistreur
		this.commands.put("EnregistreurDemarrer", new EnregistreurDemarrer(this.enregistreur));
		this.commands.put("EnregistreurStopper", new EnregistreurStopper(this.enregistreur));
		this.commands.put("EnregistreurRejouer", new EnregistreurRejouer(this.enregistreur));
		// Defaire / Refaire
		this.commands.put("Defaire", new Defaire(this.gd));
		this.commands.put("Refaire", new Refaire(this.gd));

	}
	
	public static void main(String[] args) {
		new Client();
	}

}
