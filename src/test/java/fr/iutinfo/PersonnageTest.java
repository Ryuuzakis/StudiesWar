package fr.iutinfo;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import fr.iutinfo.studiesWar.models.Personnage;
import fr.iutinfo.studiesWar.models.PersonnageJoueur;

public class PersonnageTest {

	@Test
	public void test() {
		Personnage p = new PersonnageJoueur();
		assertTrue(p.getStat("Maths") <= 20);
	}

}
