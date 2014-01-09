package fr.istic.m1.aco.miniediteur.v3.caretaker;

import fr.istic.m1.aco.miniediteur.v3.command.Command;


/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Interface Enregistreur (caretaker du Patron de Conception Memento)
 */
public interface Enregistreur {
	
	/**
	 * Demarrer l'Enregistreur
	 */
	void demarrer();
	
	/**
	 * Stopper l'Enregistreur 
	 */
	void stopper();

	/**
	 * Rejouer les actions enregistrees
	 */
	void rejouer();
	
	/**
	 * Sauvegarde dans un Enregistrement la Command et son Memento
	 * @param command : la Command a sauvegarder, le Memento est recupere par cette Command
	 */
	void sauvegarder(Command command);
	
	/**
	 * Ajoute un Enregistrement a la liste d'enregistrements
	 * @param enregistrement : Un Enregistrement a ajouter
	 */
	void add(Enregistrement enregistrement);
	
	/**
	 * Retourne l'Enregistrement de l'index demande
	 * @param index : un entier correspondant a l'index du Enregistrement demande
	 * @return : un Enregistrement correspondant au Enregistrement demande
	 */
	Enregistrement get(int index);
	
	/**
	 * Vide les enregistrements de l'Enregistreur
	 */
	void vider();
	
	/**
	 * @return : true si l'Enregistreur est en marche, false sinon
	 */
	boolean isEnMarche();

	/**
	 * @return : true sir l'Enregistreur est entrain de rejouer, false sinon
	 */
	boolean isRejouer();
	
}
