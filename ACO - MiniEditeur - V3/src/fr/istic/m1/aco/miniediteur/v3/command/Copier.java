package fr.istic.m1.aco.miniediteur.v3.command;

import fr.istic.m1.aco.miniediteur.v3.caretaker.Enregistreur;
import fr.istic.m1.aco.miniediteur.v3.memento.Memento;
import fr.istic.m1.aco.miniediteur.v3.receiver.GestionDefaire;
import fr.istic.m1.aco.miniediteur.v3.receiver.ME;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Commande qui execute l'action Copier du Mini-Editeur
 */
public class Copier implements Command {
	
	private ME me;
	private Enregistreur enregistreur;
	private GestionDefaire gd;
	
	public Copier(ME me, Enregistreur enregistreur, GestionDefaire gd) {
		this.me = me;
		this.enregistreur = enregistreur;
		this.gd = gd;
	}

	public void execute() {
		this.gd.sauvegarder();
		// appeler copier sur l'editeur
		if(this.enregistreur.isEnMarche()) {
			this.enregistreur.sauvegarder(this);
		}
		this.me.copier();
	}

	@Override
	public Memento getMemento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMemento(Memento memento) {
	}

}
