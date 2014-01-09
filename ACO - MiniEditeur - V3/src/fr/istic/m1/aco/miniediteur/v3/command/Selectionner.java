package fr.istic.m1.aco.miniediteur.v3.command;

import fr.istic.m1.aco.miniediteur.v3.caretaker.Enregistreur;
import fr.istic.m1.aco.miniediteur.v3.invoker.IHM;
import fr.istic.m1.aco.miniediteur.v3.memento.Memento;
import fr.istic.m1.aco.miniediteur.v3.memento.MementoSelectionner;
import fr.istic.m1.aco.miniediteur.v3.receiver.ME;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Commande qui execute l'action Selectionner du Mini-Editeur
 */
public class Selectionner implements Command {

	private ME me;
	private IHM ihm;
	private Enregistreur enregistreur;
	private int debut;
	private int fin;
	
	public Selectionner(ME me, IHM ihm, Enregistreur enregistreur) {
		this.me = me;
		this.ihm = ihm;
		this.enregistreur = enregistreur;
	}

	public void execute() {
		// appeler selectionner sur l'editeur
		if(!this.enregistreur.isRejouer()) {
			this.debut = this.ihm.getSelectionDebut();
			this.fin = this.ihm.getSelectionFin();
		}
		if(this.enregistreur.isEnMarche()) {
			this.enregistreur.sauvegarder(this);
		}
		this.me.selectionner(this.debut,this.fin);
	}

	@Override
	public Memento getMemento() {
		MementoSelectionner m = new MementoSelectionner();
		m.setDebut(this.debut);
		m.setFin(this.fin);
		return m;
	}

	@Override
	public void setMemento(Memento memento) {
		this.debut = ((MementoSelectionner) memento).getDebut();
		this.fin = ((MementoSelectionner) memento).getFin();	
	}

}
