package fr.istic.m1.aco.miniediteur.v3.memento;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Class MementoSaisirTexte implementant Memento
 */
public class MementoSaisirTexte implements Memento {
	
	private String texte;
	
	/**
	 * Constructeur de MementoSaisirTexte
	 */
	public MementoSaisirTexte(){
		this.texte = "";
	}
	
	
	/**
	 * @return : l'attribut texte de type String du Memento
	 */
	public String getTexte() {
		return this.texte;
	}
	
	/**
	 * Modifie l'attribut texte
	 * @param texte : une chaine texte qui modifiera l'attribut texte
	 */
	public void setTexte(String texte) {
		this.texte = texte;
	}

}
