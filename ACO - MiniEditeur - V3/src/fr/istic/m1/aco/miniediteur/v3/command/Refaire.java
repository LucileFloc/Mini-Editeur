package fr.istic.m1.aco.miniediteur.v3.command;

import fr.istic.m1.aco.miniediteur.v3.memento.Memento;
import fr.istic.m1.aco.miniediteur.v3.receiver.GestionDefaire;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Commande qui execute l'action Refaire du Mini-Editeur
 */
public class Refaire implements Command {
	
	private GestionDefaire gd;

	public Refaire(GestionDefaire gd) {
		this.gd = gd;
	}

	@Override
	public void execute() {		
		this.gd.refaire();
	}

	@Override
	public Memento getMemento() {
		return null;
	}

	@Override
	public void setMemento(Memento memento) {		
	}

}
