package fr.istic.m1.aco.miniediteur.v3.receiver;

import java.util.Stack;

import fr.istic.m1.aco.miniediteur.v3.memento.MementoME;


/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Class GestionDefaire qui s'occupe de gérer Annuler et Rétablir (ou Défaire et Refaire)
 */
public class GestionDefaire {

	private Stack<MementoME> faits;
	private Stack<MementoME> defaits;
	private MementoME courant;
	
	private ME me;
	
	public GestionDefaire(ME me) {
		this.me = me;
		this.faits = new Stack<MementoME>();
		this.defaits = new Stack<MementoME>();
		this.initialiser();
	}
	
	/**
	 * Annule l'evenement effectue si un evenement est enregistre dans la pile de MementoME faits
	 */
	public void defaire() {
		if(!this.faits.isEmpty()) {
			if(this.defaits.isEmpty()) {
				this.defaits.push((MementoME) this.me.getMemento());
			}
			this.me.setMemento(this.courant);
			this.defaits.push(this.courant);
			this.courant = this.faits.pop();
		}
	}
	
	/**
	 * Retablit l'evenement effectue si un evenement est enregistre dans la pile de MementoME faits
	 */
	public void refaire() {
		if(this.defaits.size() > 1) {
			this.faits.push(this.courant);
			this.courant = this.defaits.pop();
			this.me.setMemento(this.defaits.peek());
		}
	}
	
	/**
	 * Initialise l'etat courant
	 */
	public void initialiser() {
		this.courant = (MementoME) this.me.getMemento();
	}
	
	/**
	 * Sauvegarde un etat du ME (generalement avant qu'une commande ne soit effectuee)
	 */
	public void sauvegarder() {
		this.faits.push(this.courant);
		this.courant = (MementoME) this.me.getMemento();
		this.defaits = new Stack<MementoME>();
	}
	
	/**
	 * Getters et Setters pour les tests
	 */
	
	public MementoME getCourant() {
		return courant;
	}
	
	public void setCourant(MementoME courant) {
		this.courant = courant;
	}
	
	public Stack<MementoME> getDefaits() {
		return defaits;
	}
	
	public void setDefaits(Stack<MementoME> defaits) {
		this.defaits = defaits;
	}
	
	public Stack<MementoME> getFaits() {
		return faits;
	}
	
	public void setFaits(Stack<MementoME> faits) {
		this.faits = faits;
	}


}
