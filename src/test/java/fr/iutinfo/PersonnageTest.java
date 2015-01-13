package fr.iutinfo;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import fr.iutinfo.utils.Personnage;
import fr.iutinfo.utils.PersonnageJoueur;

public class PersonnageTest {

	@Test
	public void test() {
		Personnage p = new PersonnageJoueur();
		assertTrue(p.getStat("Maths") <= 20);
		p.setStat("Triche", 15);
		assertEquals(p.getStat("Triche"),15);
		
	}

}
