package fr.istic.m1.aco.miniediteur.v3.invoker;

import java.util.Map;

import fr.istic.m1.aco.miniediteur.v3.command.Command;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Interface IHM
 */
public interface IHM {
	
	/**
     * Creer une zone de texte editable dans l'IHM et tous les elements du Menu.
     */	
	void creer(); 
	
	/**
     * Parametre les options d'affichage de la fenetre, puis l'affiche.
     */
	void afficher();

	/**
	 * @return : l'index du début de la selection
	 */
	int getSelectionDebut();
	
	/**
	 * @return : l'index de la fin de la selection
	 */
	int getSelectionFin();
		

	/**
	 * @return : le dernier caractere imprimable saisis au clavier
	 */
	char getDernierCaractere();
	
	/**
	 * @param commands - une Map contenant les commandes
	 * @throws Exception - Une exception est creee si une des commandes n'est pas presente 
	 * (parmis Coller, Copier, Couper, SaisirTexte, Selectionner, SupprimerArriere, SupprimerAvant)
	 */
	void setCommands(Map<String, Command> commands) throws Exception;

	
}
