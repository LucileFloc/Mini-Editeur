package tests;

import junit.framework.Assert;

import org.junit.Test;

import fr.istic.m1.aco.miniediteur.v3.receiver.Buffer;

/**
 * @author Xavier Lecoq / Aymen Hafsi
 *
 */
@SuppressWarnings("deprecation")
public class BufferTest {

	@Test
	public void testEffacer() {
		Buffer b = new Buffer();
		b.setContenu("testEffacer");
		b.effacer();
		b.setContenu("testEffacer");
		b.effacer(0,4);
		Assert.assertEquals(b.getContenu(), "Effacer");
	}

	@Test
	public void testInserer() {
		Buffer b = new Buffer();
		b.setContenu("test");
		b.inserer("Inserer", 4);
		Assert.assertEquals(b.getContenu(), "testInserer");
	}

	@Test
	public void testGetContenu() {
		Buffer b = new Buffer();
		b.setContenu("testGetContenu");
		Assert.assertEquals(b.getContenu(), "testGetContenu");
	}

	@Test
	public void testSetContenu() {
		Buffer b = new Buffer();
		b.setContenu("testSetContenu");
		Assert.assertEquals(b.getContenu(), "testSetContenu");	}

}
