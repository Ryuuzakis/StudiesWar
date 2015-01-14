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
		
		Action a1 = new Absence(p1,(byte)1,(byte)7,"Test");
		a1.agit();

		Controle c1=new Controle("Maths",p,(byte)1);
		
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
	
/*	@Test
	public void test2() {
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
		
		Action a1 = new Etudier(p1,"Maths",3,"Test");
		Action a2 = new Tricher(p2,p1,c1,"Test");
		Action a3 = new Absence(p3,(byte)1,(byte)7,"Test2");
		Action a4 = new Tricher(p3,p1,c1,"Test");
		a1.agit();
		a2.agit();
		a3.agit();
		a4.agit();
		System.out.println(c1.getNote(p3).getNote());
		c1.calculerTousLesNotes();
		System.out.println(c1.getNote(p3).getNote());
		
		
		i++;
		assertTrue(c1.getNote(p3).getNote()== -1);

		
		}
		
	} */
	
	/**
	 * Verifie que le tricheur a au moins la meme note que la personne qu'il a copie
	 */ 
	@Test
	public void test3() {
		int i =0;
		while(i<25){
		
		Partie p=new Partie(0, 0);
		
		Personnage p1=new PersonnageJoueur();
		Personnage p2=new PersonnageJoueur();
		
		p.rejoinPartie(p1);
		p.rejoinPartie(p2);
		
		Controle c1=new Controle("Maths",p,(byte)1);
		
		Action a1 = new Tricher(p2,p1,c1,"Test");
		
		a1.agit();
		
		
		
		c1.calculerTousLesNotes();
		
		assertTrue(c1.getNote(p1).getNote()<= c1.getNote(p2).getNote());
		i++;
	}} 
	
	/**
	 * Verifie que les etudes depensent bien un point d'action
	 */
	@Test
	public void test4() {
		int i =0;
		while(i<25){
		
		Partie p=new Partie(0, 0);
		
		Personnage p1=new PersonnageJoueur();
		
		p.rejoinPartie(p1);
		
		Action a1 = new Etudier(p1,"Maths",3,"Test");
		
		a1.agit();
		
		assertTrue(p1.getPA()==2);
			
		i++;
		
	}} 
	/*
	
	@Test
	public void test5() {
		do{
		Partie p=new Partie(0, 0);
		
		Personnage p1=new PersonnageJoueur();
		
		p.rejoinPartie(p1);
		
		Action a1 = new Etudier(p1,"Maths",3);
		
		a1.agit();
		
		Controle c1=new Controle("Maths",p,(byte)1);
		
		c1.calculerTousLesNotes();
		
		assertTrue(p1.getPA()==2);
			
		}while(c1.getNote(p1).getNote());
		
	}}*/
	
	
	
/*	@Test
	public void test6() {
		int i =0;
		Partie p;
		Personnage p1;
		Personnage p2;
		Personnage p3;
		Controle c1;
		Action a2;
		Action a4;
		while(i<25){
		
		p=new Partie(0, 0);
		
		p1=new PersonnageJoueur();
		p2=new PersonnageJoueur();
		p3=new PersonnageJoueur();
	
		p.rejoinPartie(p1);
		p.rejoinPartie(p2);
		p.rejoinPartie(p3);
		
		c1=new Controle("Maths",p,(byte)1);
		
		//Action a1 = new Tricher(p3,"Maths",3,"Test");
		a2 = new Tricher(p1,p2,c1,"Test");
		a4 = new Tricher(p2,p3,c1,"Test2");
		a2.agit();
		a4.agit();
		
		c1.calculerTousLesNotes();
		//System.out.println(c1.getNote(p1).getNote()+ "," + c1.getNote(p2).getNote() + "," + c1.getNote(p3).getNote());
		assertTrue(c1.getNote(p1).getNote()>= c1.getNote(p2).getNote());
		
		
		i++;
		}
		
	} */
	
	
	

}