package edu.kit.ipd.swt1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Ahmad
 *
 */
public class EditMeTest {

	private EditMe editMe;

	@Before
	public void setUp() throws Exception {
		editMe = new EditMe();
	}

	@After
	public void tearDown() throws Exception {
		
	}
/**
 * Makes sure that the matriculation number is as assigned.
 */
	@Test
	public void testMatNum() {
		assertEquals(1796434, editMe.getMatNum());
	}
/**
 * Makes sure that the the String from getFoo(), is bar.
 */
	@Test
	public void testFoo() {
		assertEquals("bar", editMe.getFoo());
	}
}
