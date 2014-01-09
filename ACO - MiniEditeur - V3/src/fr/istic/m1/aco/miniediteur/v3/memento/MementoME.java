package fr.istic.m1.aco.miniediteur.v3.memento;

import fr.istic.m1.aco.miniediteur.v3.receiver.Buffer;
import fr.istic.m1.aco.miniediteur.v3.receiver.PressePapier;
import fr.istic.m1.aco.miniediteur.v3.receiver.Selection;

public class MementoME implements Memento {
	
	private Selection selection;
	private Buffer buffer;
	private PressePapier pressePapier;
	
	public MementoME() {
		this.selection = new Selection();
		this.buffer = new Buffer();
		this.pressePapier = new PressePapier();
	}

	public Selection getSelection() {
		return selection;
	}

	public void setSelection(Selection selection) {
		this.selection = selection;
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

	public PressePapier getPressePapier() {
		return pressePapier;
	}

	public void setPressePapier(PressePapier pressePapier) {
		this.pressePapier = pressePapier;
	}

}
