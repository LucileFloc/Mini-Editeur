package tests;

import junit.framework.Assert;

import org.junit.Test;

import fr.istic.m1.aco.miniediteur.v3.receiver.PressePapier;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 *
 */
public class PressePapierTest {

	@Test
	public void testGetContenu() {
		PressePapier pp = new PressePapier();
		pp.setContenu("testGetContenu");
		Assert.assertEquals(pp.getContenu(), "testGetContenu");	
	}

	@Test
	public void testSetContenu() {
		PressePapier pp = new PressePapier();
		pp.setContenu("testSetContenu");
		Assert.assertEquals(pp.getContenu(), "testSetContenu");		
	}

}
