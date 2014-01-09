package fr.istic.m1.aco.miniediteur.v3.command;

import fr.istic.m1.aco.miniediteur.v3.caretaker.Enregistreur;
import fr.istic.m1.aco.miniediteur.v3.memento.Memento;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Commande qui execute l'action Stopper l'Enregistreur
 */
public class EnregistreurStopper implements Command {

	private Enregistreur enregistreur;
	
	public EnregistreurStopper(Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
	}
	
	@Override
	public void execute() {
		this.enregistreur.stopper();
	}

	@Override
	public Memento getMemento() {
		return null;
	}

	@Override
	public void setMemento(Memento memento) {
	}

}
