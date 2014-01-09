package tests;

import static org.junit.Assert.*;

import java.util.Stack;

import junit.framework.Assert;

import org.junit.Test;

import fr.istic.m1.aco.miniediteur.v3.memento.MementoME;
import fr.istic.m1.aco.miniediteur.v3.receiver.Buffer;
import fr.istic.m1.aco.miniediteur.v3.receiver.GestionDefaire;
import fr.istic.m1.aco.miniediteur.v3.receiver.ME;
import fr.istic.m1.aco.miniediteur.v3.receiver.MEImpl;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 *
 */
@SuppressWarnings("deprecation")
public class GestionDefaireTest {

	@Test
	public void testDefaire() {
		ME me = new MEImpl();
		GestionDefaire gd = new GestionDefaire(me);
		Stack<MementoME> faits = new Stack<MementoME>();
		MementoME m1 = new MementoME();
		MementoME m2 = new MementoME();
		MementoME m3 = new MementoME();
		MementoME m4 = new MementoME();
		MementoME m5 = new MementoME();
		MementoME m6 = new MementoME();
		faits.add(m1);
		faits.add(m2);
		faits.add(m3);
		faits.add(m4);
		faits.add(m5);
		faits.add(m6);
		gd.setFaits(faits);
		gd.defaire();
		Assert.assertEquals(m6,gd.getCourant());
	}
	
	@Test
	public void testRefaire() {
		ME me = new MEImpl();
		GestionDefaire gd = new GestionDefaire(me);
		Stack<MementoME> faits = new Stack<MementoME>();
		Stack<MementoME> defaits = new Stack<MementoME>();
		MementoME m1 = new MementoME();
		MementoME m2 = new MementoME();
		MementoME m3 = new MementoME();
		MementoME m4 = new MementoME();
		MementoME m5 = new MementoME();
		MementoME m6 = new MementoME();
		faits.add(m1);
		faits.add(m2);
		faits.add(m3);
		defaits.add(m6);
		defaits.add(m5);
		gd.setCourant(m4);
		gd.setFaits(faits);
		gd.setDefaits(defaits);
		gd.refaire();
		Assert.assertEquals(m5,gd.getCourant());
	}
	
	@Test
	public void testSauvegarder() {
		ME me = new MEImpl();
		GestionDefaire gd = new GestionDefaire(me);
		gd.sauvegarder();
		gd.sauvegarder();
		gd.sauvegarder();
		gd.sauvegarder();
		gd.sauvegarder();
		Assert.assertEquals(5,gd.getFaits().size());
	}


}
