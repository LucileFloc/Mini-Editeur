package fr.istic.m1.aco.miniediteur.v3.command;

import fr.istic.m1.aco.miniediteur.v3.caretaker.Enregistreur;
import fr.istic.m1.aco.miniediteur.v3.memento.Memento;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Commande qui execute l'action Demarrer l'Enregistreur
 */
public class EnregistreurDemarrer implements Command {
	
	private Enregistreur enregistreur;

	public EnregistreurDemarrer(Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
	}

	@Override
	public void execute() {
		this.enregistreur.demarrer();
	}

	@Override
	public Memento getMemento() {
		return null;
	}

	@Override
	public void setMemento(Memento memento) {
	}

}
