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


public class ControleTest {

	/**
	 * Verifie qu'un absent obtient toujours une note invalide
	 */
	@Test
	public void test1() {
		int i =0;
		while(i<25){

			Partie p=new Partie();

			Personnage p1=new PersonnageJoueur();

			p.rejoindrePartie(p1);
			
			Controle c1=new Controle("Maths",p,(byte)1);

			Action a1 = new Absence(p1,c1,"Test");
			a1.agit();

			c1.calculerToutesLesNotes();

			assertTrue(-1==c1.getNote(p1).getNote());
			i++;
		}

	}

	@Test
	public void testtri() {
		int i =0;
		while(i<25){

			Partie p = new Partie();

			Personnage p1=new PersonnageJoueur();
			Personnage p2=new PersonnageJoueur();
			Personnage p3=new PersonnageJoueur();

			p.rejoindrePartie(p1);
			p.rejoindrePartie(p2);
			p.rejoindrePartie(p3);

			Controle c1=new Controle("Maths",p,(byte)1);

			c1.calculerToutesLesNotes();
			c1.triParNote();
			ArrayList<Personnage> per = p.getPersonnes();
			assertTrue(c1.getNote(per.get(0)).getNote() >= c1.getNote(per.get(1)).getNote());
			assertTrue(c1.getNote(per.get(1)).getNote() >= c1.getNote(per.get(2)).getNote());
			//System.out.println();
			i++;
		}

	}

//	@Test
//	public void test4() {
//		int i =0;
//
//		Partie p=new Partie();
//
//		Personnage p1=new PersonnageJoueur();
//		Personnage p2=new PersonnageJoueur();
//		Personnage p3=new PersonnageJoueur();
//		Personnage p4=new PersonnageJoueur();
//
//		p.rejoindrePartie(p1);
//		p.rejoindrePartie(p2);
//		p.rejoindrePartie(p3);
//		p.rejoindrePartie(p4);
//		
//		p.demarrerTour();
//		
//		p.finDuTour();
//		
//		p.demarrerTour();
//		
//		p.finDuTour();
//		
//		System.out.println(p.getResultatsSemaine(0, p1));
//		System.out.println(p.getResultatsSemaine(1, p1));
//
//	}

}
