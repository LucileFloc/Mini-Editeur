package tests;

import junit.framework.Assert;

import org.junit.Test;

import fr.istic.m1.aco.miniediteur.v3.receiver.Selection;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 *
 */
public class SelectionTest {

	@Test
	public void testGetFin() {
		Selection s = new Selection();
		s.setFin(5);
		Assert.assertEquals(s.getFin(), 5);	
	}

	@Test
	public void testSetFin() {
		Selection s = new Selection();
		s.setFin(5);
		Assert.assertEquals(s.getFin(), 5);	
	}

	@Test
	public void testGetDebut() {
		Selection s = new Selection();
		s.setDebut(2);
		Assert.assertEquals(s.getDebut(), 2);	
	}

	@Test
	public void testSetDebut() {
		Selection s = new Selection();
		s.setDebut(2);
		Assert.assertEquals(s.getDebut(), 2);	
	}

}
