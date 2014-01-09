package fr.istic.m1.aco.miniediteur.v3.caretaker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.istic.m1.aco.miniediteur.v3.command.Command;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 * Class EnregistreurImpl implementant Enregistreur
 */
public class EnregistreurImpl implements Enregistreur {

	private List<Enregistrement> enregistrements;

	private boolean enMarche;
	
	private boolean rejouer;

	/**
	 * Constructeur d'EnregistreurImpl
	 */
	public EnregistreurImpl() {
		this.enregistrements = new ArrayList<Enregistrement>();
		this.enMarche = false;
		this.rejouer = false;
	}

	@Override
	public void demarrer() {
		this.vider();
		System.out.println("L'enregistreur est mis en marche.");
		this.enMarche = true;
	}

	@Override
	public void stopper() {
		System.out.println("L'enregistreur est stoppé.");
		this.enMarche = false;
	}

	@Override
	public void rejouer() {
		System.out.println("L'enregistreur rejoue.");
		this.rejouer = true;
		Iterator<Enregistrement> it = this.enregistrements.iterator();
		while(it.hasNext()) {
			Enregistrement e = it.next();
			e.getCommand().setMemento(e.getMemento());
			e.getCommand().execute();
		}
		this.rejouer = false;
	}

	@Override
	public void vider() {
		this.enregistrements = new ArrayList<Enregistrement>();
	}

	@Override
	public void add(Enregistrement enregistrement) {
		this.enregistrements.add(enregistrement);
	}

	@Override
	public Enregistrement get(int index) {
		return this.enregistrements.get(index);
	}

	@Override
	public boolean isEnMarche() {
		return enMarche;
	}

	@Override
	public void sauvegarder(Command command) {
		Enregistrement enregistrement = new Enregistrement(command, command.getMemento());
		this.add(enregistrement);
	}

	@Override
	public boolean isRejouer() {
		return this.rejouer;
	}

	/**
	 * Getters et Setters pour les tests
	 */
	
	public List<Enregistrement> getEnregistrements() {
		return enregistrements;
	}

}
