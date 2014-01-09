package fr.istic.m1.aco.miniediteur.v3.receiver;

import java.util.Observable;
import java.util.Observer;

import fr.istic.m1.aco.miniediteur.v3.invoker.IHM;
import fr.istic.m1.aco.miniediteur.v3.memento.Memento;
import fr.istic.m1.aco.miniediteur.v3.memento.MementoME;
import fr.istic.m1.aco.miniediteur.v3.receiver.Buffer;
import fr.istic.m1.aco.miniediteur.v3.receiver.ME;
import fr.istic.m1.aco.miniediteur.v3.receiver.PressePapier;
import fr.istic.m1.aco.miniediteur.v3.receiver.Selection;


/**
 * @author Xavier Lecoq / Aymen Hafsi
 *
 */
public class MEImpl extends Observable implements ME {

	/**
	 * Attribut buffer correspondant à un objet de type Buffer
	 */
	private Buffer buffer;

	/**
	 * Attribut selection correspondant à un objet de type Selection
	 */
	private Selection selection;

	/**
	 * Attribut pressePapier correspondant à un objet de type PressePapier
	 */
	private PressePapier pressePapier;

	/**
	 * Construction de MEImpl
	 */
	public MEImpl() {
		this.buffer = new Buffer();
		this.selection = new Selection();
		this.pressePapier = new PressePapier();
	}

	@Override
	public void saisirTexte(String s) { 
		if(this.selection.getLongueur() > 0) {
			this.buffer.effacer(this.selection.getDebut(), this.selection.getFin());
			this.selection.setFin(this.selection.getDebut());
		}
		this.buffer.inserer(s, this.selection.getDebut());
		this.selection.setDebut(this.selection.getDebut()+1);
		this.selection.setFin(this.selection.getDebut());
		this.setChanged();
		this.notifyObservers(this.buffer.getContenu());
		this.setChanged();
		this.notifyObservers(this.selection.getDebut());
	}

	@Override
	public void selectionner(int debut, int fin)	{
		if(debut > this.buffer.size()) {
			this.selection.setDebut(this.buffer.size());
		} else {
			this.selection.setDebut(debut);
		}
		if(fin > this.buffer.size()) {
			this.selection.setFin(this.buffer.size());
		} else {
			this.selection.setFin(fin);
		}	
	}

	@Override
	public void coller() {
		String contenu = this.pressePapier.getContenu();
		int taille = contenu.length();
		this.buffer.effacer(this.selection.getDebut(), this.selection.getFin());
		this.selection.setFin(this.selection.getDebut());
		this.buffer.inserer(contenu, this.selection.getDebut());
		this.selection.setDebut(this.selection.getDebut()+taille);
		this.selection.setFin(this.selection.getDebut());
		this.setChanged();
		this.notifyObservers(this.buffer.getContenu());
		this.setChanged();
		this.notifyObservers(this.selection.getDebut());
	}


	@Override
	public void copier() {
		if(this.selection.getLongueur() > 0) {
			String contenu = this.buffer.getContenu(this.selection.getDebut(), this.selection.getFin());
			this.pressePapier.setContenu(contenu);	
		}
		this.selection.setFin(this.selection.getDebut());
		this.setChanged();
		this.notifyObservers(this.selection.getDebut());
	}

	@Override
	public void couper() {
		if(this.selection.getLongueur() > 0) {
			String contenu = this.buffer.getContenu(this.selection.getDebut(), this.selection.getFin());
			this.pressePapier.setContenu(contenu);
			this.buffer.effacer(this.selection.getDebut(), this.selection.getFin());
			this.selection.setFin(this.selection.getDebut());
		}
		this.setChanged();
		this.notifyObservers(this.buffer.getContenu());
		this.setChanged();
		this.notifyObservers(this.selection.getDebut());
	}

	@Override
	public void supprimerAvant() {
		if(this.selection.getLongueur() > 0) {
			this.buffer.effacer(this.selection.getDebut(), this.selection.getFin());
			this.selection.setFin(this.selection.getDebut());
		} else if(this.buffer.size() >= this.selection.getDebut()) {
			this.buffer.effacer(this.selection.getDebut(),this.selection.getDebut()+1);
		}
		this.setChanged();
		this.notifyObservers(this.buffer.getContenu());
		this.setChanged();
		this.notifyObservers(this.selection.getDebut());
	}

	@Override
	public void supprimerArriere() {
		if(this.selection.getLongueur() > 0) {
			this.buffer.effacer(this.selection.getDebut(), this.selection.getFin());
			this.selection.setFin(this.selection.getDebut());
		} else if(this.selection.getDebut() > 0) {
			this.buffer.effacer(this.selection.getDebut()-1,this.selection.getDebut());
			this.selection.setDebut(this.selection.getDebut()-1);
			this.selection.setFin(this.selection.getDebut());
		}
		this.setChanged();
		this.notifyObservers(this.buffer.getContenu());
		this.setChanged();
		this.notifyObservers(this.selection.getDebut());
	}

	@Override
	public void addObserver(IHM ihm) {
		this.addObserver((Observer) ihm);
	}
	
	@Override
	public void setMemento(Memento m) {
		this.buffer = ((MementoME) m).getBuffer();
		this.selection = ((MementoME) m).getSelection();
		this.pressePapier = ((MementoME) m).getPressePapier();
		this.setChanged();
		this.notifyObservers(this.buffer.getContenu());
		this.setChanged();
		this.notifyObservers(this.selection.getDebut());
	}

	@Override
	public Memento getMemento() {
		MementoME m = new MementoME();
		Buffer copyBuffer = new Buffer();
		copyBuffer.setContenu(new String(this.buffer.getContenu()));
		PressePapier copyPressePapier = new PressePapier();
		copyPressePapier.setContenu(new String(this.pressePapier.getContenu()));
		Selection copySelection = new Selection();
		copySelection.setDebut(new Integer(this.selection.getDebut()));
		copySelection.setFin(new Integer(this.selection.getFin()));
		m.setBuffer(copyBuffer);
		m.setPressePapier(copyPressePapier);
		m.setSelection(copySelection);
		return m;
	}

	/**
	 * Getters et Setters pour les tests
	 */

	public Buffer getBuffer() {
		return buffer;
	}


	public PressePapier getPressePapier() {
		return pressePapier;
	}


	public Selection getSelection() {
		return selection;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}


	public void setPressePapier(PressePapier pressePapier) {
		this.pressePapier = pressePapier;
	}


	public void setSelection(Selection selection) {
		this.selection = selection;
	}
}
