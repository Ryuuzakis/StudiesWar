package fr.iutinfo;

import static org.junit.Assert.*;

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
		
		Controle c1=new Controle("Maths",p,(byte)1);
		
		Action a1 = new Etudier(p1,"Maths",3);
		Action a2 = new Tricher(p2,p1,c1);
		Action a3 = new Absence(p3,(byte)1,(byte)7);
		Action a4 = new Tricher(p3,p1,c1);
		a1.agit();
		a2.agit();
		a3.agit();
		a4.agit();
		
		
		
		c1.calculerTousLesNotes();
		
		}
	}
}
