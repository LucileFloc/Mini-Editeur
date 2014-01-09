package fr.istic.m1.aco.miniediteur.v3.caretaker;

import fr.istic.m1.aco.miniediteur.v3.command.Command;
import fr.istic.m1.aco.miniediteur.v3.memento.Memento;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Class Enregistrement permettant de sauvegarder une Command et un Memento
 */

public class Enregistrement {
	
	private Command command;
	private Memento memento;
	
	public Enregistrement(Command command, Memento memento) {
		this.command = command;
		this.memento = memento;
	}
	
	/**
	 * @return la Command de l'enregistrement
	 */
	public Command getCommand() {
		return command;
	}
	
	/**
	 * @return le Memento de l'enregistrement, null s'il n'y a pas de Memento
	 */
	public Memento getMemento() {
		return memento;
	}
}
