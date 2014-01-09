package fr.istic.m1.aco.miniediteur.v3.receiver;

import fr.istic.m1.aco.miniediteur.v3.invoker.IHM;
import fr.istic.m1.aco.miniediteur.v3.memento.Memento;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 *
 */
public interface ME {

	/**
     * Coupe une partie du texte du Buffer dans le Presse-Papier en fonction de la Selection
     * La partie du texte coupée est effacée du Buffer
     */
	void couper();

	/**
     * Copie une partie du texte du Buffer dans le Presse-Papier en fonction de la Selection
     */
	void copier();

	/**
	 * Colle le contenu du Presse-Papier dans le Buffer en fonction de la Selection
	 */
	void coller();

	/**
	 * Definit le debut et la fin de la Selection du Moteur d'Edition
	 * @param debut : un entier representant le debut de la selection
	 * @param fin : un entier representant la fin de la selection
	 */
	void selectionner(int debut, int fin);

	/**
     * Insere la chaine s dans le buffer a l'emplacement du curseur si la selection est nulle, sinon a la place du texte selectionne.
	 * @param s : la chaine a inserer dans le Buffer
	 */
	void saisirTexte(String s);
	
	/**
     * Supprime le texte selectionne dans le buffer si la selection est nulle, sinon supprime le caractere apres le curseur.
     */
	void supprimerAvant();
	
	
	/**
     * Supprime le texte selectionne dans le buffer si la selection est nulle, sinon supprime le caractere avant le curseur.
	 */
	void supprimerArriere();

	/**
	 * @param ihm : Une IHM implementant Observer
	 */
	void addObserver(IHM ihm);
	
	void setMemento(Memento m);
	
	Memento getMemento();
	
	Selection getSelection();
	
	PressePapier getPressePapier();
	
	Buffer getBuffer();
		
}
