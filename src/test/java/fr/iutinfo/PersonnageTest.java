package fr.iutinfo;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import fr.iutinfo.studiesWar.models.Partie;
import fr.iutinfo.studiesWar.models.Personnage;
import fr.iutinfo.studiesWar.models.PersonnageJoueur;

public class PersonnageTest {

	@Test
	public void test() {
		Personnage personnage = new PersonnageJoueur();
		Partie partie = new Partie(0, 0);
		partie.rejoinPartie(personnage);
		assertTrue(personnage.getStat("Maths") <= 20);
	}

}
