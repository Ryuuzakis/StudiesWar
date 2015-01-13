package fr.iutinfo;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.iutinfo.utils.Absence;
import fr.iutinfo.utils.Action;
import fr.iutinfo.utils.Controle;
import fr.iutinfo.utils.Etudier;
import fr.iutinfo.utils.Partie;
import fr.iutinfo.utils.Personnage;
import fr.iutinfo.utils.PersonnageJoueur;
import fr.iutinfo.utils.Tricher;

public class ControleTest {

	@Test
	public void test1() {
		int i =0;
		while(i<25){
		
		Partie p=new Partie(0, 0);
		
		Personnage p1=new PersonnageJoueur();
		
		p.rejoinPartie(p1);
		
		Action a1 = new Absence(p1,(byte)1,(byte)7);
		a1.agit();

		Controle c1=new Controle("Maths",p,(byte)1);
		
		c1.calculerTousLesNotes();
		
		System.out.println(c1.getNote(p1).getNote());
		i++;
		}
		
	}
	
	@Test
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
		
		Action a1 = new Etudier(p1,"Maths",3);
		Action a2 = new Tricher(p2,p1);
		Action a3 = new Absence(p3,(byte)1,(byte)7);
		Action a4 = new Tricher(p3,p1);
		a1.agit();
		a2.agit();
		a3.agit();
		a4.agit();
		
		
		Controle c1=new Controle("Maths",p,(byte)1);
		
		c1.calculerTousLesNotes();
		
		System.out.println(c1.getNote(p1).getNote()+ "," + c1.getNote(p2).getNote() + "," + c1.getNote(p3).getNote());
		i++;
		}
		
	}

}
