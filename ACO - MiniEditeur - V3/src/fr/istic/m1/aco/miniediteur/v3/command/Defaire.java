package fr.istic.m1.aco.miniediteur.v3.command;

import fr.istic.m1.aco.miniediteur.v3.memento.Memento;
import fr.istic.m1.aco.miniediteur.v3.receiver.GestionDefaire;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Commande qui execute l'action Defaire du Mini-Editeur
 */
public class Defaire implements Command {
	
	private GestionDefaire gd;

	public Defaire(GestionDefaire gd) {
		this.gd = gd;
	}

	@Override
	public void execute() {	
		this.gd.defaire();
	}

	@Override
	public Memento getMemento() {
		return null;
	}

	@Override
	public void setMemento(Memento memento) {		
	}

}
