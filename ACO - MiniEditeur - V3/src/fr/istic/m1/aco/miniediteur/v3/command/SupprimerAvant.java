package fr.istic.m1.aco.miniediteur.v3.command;

import fr.istic.m1.aco.miniediteur.v3.caretaker.Enregistreur;
import fr.istic.m1.aco.miniediteur.v3.memento.Memento;
import fr.istic.m1.aco.miniediteur.v3.receiver.GestionDefaire;
import fr.istic.m1.aco.miniediteur.v3.receiver.ME;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Commande qui execute l'action SupprimerAvant du Mini-Editeur
 */
public class SupprimerAvant implements Command {

	private ME me;
	private Enregistreur enregistreur;
	private GestionDefaire gd;
	
	public SupprimerAvant(ME me, Enregistreur enregistreur, GestionDefaire gd) {
		this.me = me;
		this.enregistreur = enregistreur;
		this.gd = gd;
	}

	public void execute() {
		this.gd.sauvegarder();
		// appeler supprimerAvant sur l'editeur
		if(this.enregistreur.isEnMarche()) {
			this.enregistreur.sauvegarder(this);
		}
		this.me.supprimerAvant();
	}

	@Override
	public Memento getMemento() {
		return null;
	}

	@Override
	public void setMemento(Memento memento) {
	}

}
