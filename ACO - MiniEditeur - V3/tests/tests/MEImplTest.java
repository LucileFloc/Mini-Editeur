package tests;

import junit.framework.Assert;

import org.junit.Test;

import fr.istic.m1.aco.miniediteur.v3.receiver.MEImpl;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 *
 */
public class MEImplTest {

	@Test
	public void testSaisirTexte() {
		MEImpl me = new MEImpl();
		me.saisirTexte("Ceci n'est pas une chaîne.");
		Assert.assertEquals(me.getBuffer().getContenu(), "Ceci n'est pas une chaîne.");
	}

	@Test
	public void testSelectionner() {
		MEImpl me = new MEImpl();
		me.saisirTexte("Ceci n'est pas une chaîne.");
		me.selectionner(19, 25);
		Assert.assertEquals(me.getSelection().getDebut(), 19);
		Assert.assertEquals(me.getSelection().getFin(), 25);
	}

	@Test
	public void testColler() {
		MEImpl me = new MEImpl();
		me.saisirTexte("Ceci n'est pas une chaîne.");
		me.selectionner(15, 25);
		me.copier();
		me.selectionner(0, 4);
		me.coller();
		Assert.assertEquals(me.getBuffer().getContenu(), "une chaîne n'est pas une chaîne.");
	}

	@Test
	public void testCopier() {
		MEImpl me = new MEImpl();
		me.saisirTexte("Ceci n'est pas une chaîne.");
		me.selectionner(19, 25);
		me.copier();
		Assert.assertEquals(me.getPressePapier().getContenu(), "chaîne");
	}

	@Test
	public void testCouper() {
		MEImpl me = new MEImpl();
		me.saisirTexte("Ceci n'est pas une chaîne.");
		me.selectionner(19, 25);
		me.couper();
		Assert.assertEquals(me.getPressePapier().getContenu(), "chaîne");
		Assert.assertEquals(me.getBuffer().getContenu(), "Ceci n'est pas une .");

	}

}
