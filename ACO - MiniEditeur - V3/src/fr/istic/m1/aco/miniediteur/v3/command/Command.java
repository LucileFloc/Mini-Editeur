package fr.istic.m1.aco.miniediteur.v3.command;

import fr.istic.m1.aco.miniediteur.v3.memento.Memento;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Interface Command
 */
public interface Command {
	
	/**
	 * Execute la commande
	 */
	public void execute();

	/**
	 * @return : Un Memento contenant les variables a sauvegarder, null si aucune variable a sauvegarder
	 */
	public Memento getMemento();
	
	
	/**
	 * Charge le memento dans la commande
	 * @param memento : le Memento a charger dans la commande
	 */
	public void setMemento(Memento memento);
}
