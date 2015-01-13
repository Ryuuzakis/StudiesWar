package fr.iutinfo;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.iutinfo.utils.Controle;
import fr.iutinfo.utils.Partie;
import fr.iutinfo.utils.Personnage;
import fr.iutinfo.utils.PersonnageJoueur;

public class ControleTest {

	@Test
	public void test() {
		
		Partie p=new Partie(0, 0);
		
		Personnage p1=new PersonnageJoueur();
		Personnage p2=new PersonnageJoueur();
		Personnage p3=new PersonnageJoueur();
		
		p.rejoinPartie(p1);
		p.rejoinPartie(p2);
		p.rejoinPartie(p3);
		
		Controle c1=new Controle("Maths",p,(byte)1);
		
		c1.calculerTousLesNotes();
		
		System.out.println(c1.getNote(p1).getNote());
		System.out.println(c1.getNote(p2).getNote());
		System.out.println(c1.getNote(p3).getNote());
		
	}

}
