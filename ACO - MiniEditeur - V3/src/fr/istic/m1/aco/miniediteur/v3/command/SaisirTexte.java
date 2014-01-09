package fr.istic.m1.aco.miniediteur.v3.command;

import fr.istic.m1.aco.miniediteur.v3.caretaker.Enregistreur;
import fr.istic.m1.aco.miniediteur.v3.invoker.IHM;
import fr.istic.m1.aco.miniediteur.v3.memento.Memento;
import fr.istic.m1.aco.miniediteur.v3.memento.MementoSaisirTexte;
import fr.istic.m1.aco.miniediteur.v3.receiver.GestionDefaire;
import fr.istic.m1.aco.miniediteur.v3.receiver.ME;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Commande qui execute l'action SaisirTexte du Mini-Editeur, l'IHM est necessaire pour recuperer le texte
 */
public class SaisirTexte implements Command {
	
	private ME me;
	private IHM ihm;
	private Enregistreur enregistreur;
	private String texte;
	private GestionDefaire gd;
	
	public SaisirTexte(ME me, IHM ihm, Enregistreur enregistreur, GestionDefaire gd) {
		this.me = me;
		this.ihm = ihm;
		this.enregistreur = enregistreur;
		this.texte = null;
		this.gd = gd;
	}

	public void execute() {
		this.gd.sauvegarder();
		// appeler saisirTexte sur l'editeur
		if(!this.enregistreur.isRejouer()) {
			this.texte = Character.toString(this.ihm.getDernierCaractere());
		}
		if(this.enregistreur.isEnMarche()) {
			this.enregistreur.sauvegarder(this);
		}
		this.me.saisirTexte(this.texte);
	}

	@Override
	public Memento getMemento() {
		MementoSaisirTexte m = new MementoSaisirTexte();
		m.setTexte(this.texte);
		return m;
	}

	@Override
	public void setMemento(Memento memento) {
		this.texte = ((MementoSaisirTexte) memento).getTexte();
	}

}
