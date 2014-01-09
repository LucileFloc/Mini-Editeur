package fr.istic.m1.aco.miniediteur.v3.memento;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Class MementoSelectionner implementant Memento
 */
public class MementoSelectionner implements Memento {

	private int debut;
	private int fin;

	/**
	 * Constructeur de MementoSelectionner
	 */
	public MementoSelectionner() {
		this.debut = 0;
		this.fin = 0;
	}
	
	/**
	 * @return : : l'attribut debut de type entier du Memento
	 */
	public int getDebut() {
		return debut;
	}
	
	/**
	 * @param debut : un entier qui modifiera l'attribut debut
	 */
	public void setDebut(int debut) {
		this.debut = debut;
	}
	
	/**
	 * @return : : l'attribut fin de type entier du Memento
	 */
	public int getFin() {
		return fin;
	}
	
	/**
	 * @param fin : un entier qui modifiera l'attribut fin
	 */
	public void setFin(int fin) {
		this.fin = fin;
	}

	
}
