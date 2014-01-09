package fr.istic.m1.aco.miniediteur.v3.receiver;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Class Selection
 */
public class Selection {
	private int debut;
	
	private int fin;

	/**
	 * Constructeur de la Selection
	 */
	public Selection() {
		this.debut = 0;
		this.fin = 0;
	}
	
	/**
     * @return : l'attribut fin de la Selection de type entier
     */
	public int getFin() {
		return fin;
	}

	/**
	 * Modifie l'attribut fin de la Selection
     * @param fin : un entier correspondant au nouveau debut de la Selection     
     */
	public void setFin(int fin) {
		this.fin = fin;
	}

	 /**
     * @return : l'attribut debut de la Selection de type entier
     */
	public int getDebut() {
		return debut;
	}

	/**
	 * Modifie l'attribut debut de la Selection
     * @param debut : un entier correspondant au nouveau debut de la Selection
     */
	public void setDebut(int debut) {
		this.debut = debut;
	}
	
	/**
     * @return : un entier correspondant a la longueur de la Selection
     */
	public int getLongueur() {
		return this.fin-this.debut;
	}
}
