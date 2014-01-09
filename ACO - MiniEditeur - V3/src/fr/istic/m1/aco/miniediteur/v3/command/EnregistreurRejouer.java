package fr.istic.m1.aco.miniediteur.v3.command;

import fr.istic.m1.aco.miniediteur.v3.caretaker.Enregistreur;
import fr.istic.m1.aco.miniediteur.v3.memento.Memento;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Commande qui execute l'action Rejouer l'Enregistreur
 */
public class EnregistreurRejouer implements Command {

	private Enregistreur enregistreur;

	public EnregistreurRejouer(Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
	}

	@Override
	public void execute() {
		this.enregistreur.rejouer();
	}

	@Override
	public Memento getMemento() {
		return null;
	}

	@Override
	public void setMemento(Memento memento) {
	}

}
