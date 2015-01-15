package fr.iutinfo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fr.iutinfo.studiesWar.models.Controle;
import fr.iutinfo.studiesWar.models.Partie;
import fr.iutinfo.studiesWar.models.Personnage;
import fr.iutinfo.studiesWar.models.PersonnageJoueur;
import fr.iutinfo.studiesWar.models.action.Absence;
import fr.iutinfo.studiesWar.models.action.Action;
import fr.iutinfo.studiesWar.models.action.Etudier;
import fr.iutinfo.studiesWar.models.action.Tricher;


public class ControleTest {

	/**
	 * Verifie qu'un absent obtient toujours une note invalide
	 */
	@Test
	public void test1() {
		int i =0;
		while(i<25){

			Partie p=new Partie(0, 0);

			Personnage p1=new PersonnageJoueur();

			p.rejoinPartie(p1);
			
			Controle c1=new Controle("Maths",p,(byte)1);

			Action a1 = new Absence(p1,c1,"Test");
			a1.agit();

			c1.calculerTousLesNotes();

			assertTrue(-1==c1.getNote(p1).getNote());
			i++;
		}

	}

	@Test
	public void testtri() {
		int i =0;
		while(i<25){

			Partie p=new Partie(0, 0);

			Personnage p1=new PersonnageJoueur();
			Personnage p2=new PersonnageJoueur();
			Personnage p3=new PersonnageJoueur();

			p.rejoinPartie(p1);
			p.rejoinPartie(p2);
			p.rejoinPartie(p3);

			Controle c1=new Controle("Maths",p,(byte)1);

			c1.calculerTousLesNotes();
			c1.triParNote();
			ArrayList<Personnage> per = p.getPersonnes();
			assertTrue(c1.getNote(per.get(0)).getNote() >= c1.getNote(per.get(1)).getNote());
			assertTrue(c1.getNote(per.get(1)).getNote() >= c1.getNote(per.get(2)).getNote());
			//System.out.println();
			i++;
		}

	}

	/**
	 * Verifie que les etudes depensent bien un point d'action
	 */
	@Test
	public void test4() {
//		int i =0;
//		while(i<100){
//
//			Partie p=new Partie(0, 0);
//
//			Personnage p1=new PersonnageJoueur();
//
//			p.rejoinPartie(p1);
//
//			Action a1 = new Etudier(p1,new Controle("", p, (byte)1),3,"Test");
//
//			a1.agit();
//			
//			System.out.println(p.getResultatsSemaine(0, p1));
//			
//			
//
//			//assertTrue(p1.getPA()==2);
//			
//			i++;
//
//		}
	}

}
