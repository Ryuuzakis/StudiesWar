package fr.iutinfo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fr.iutinfo.studiesWar.models.Controle;
import fr.iutinfo.studiesWar.models.Partie;
import fr.iutinfo.studiesWar.models.Personnage;
import fr.iutinfo.studiesWar.models.PersonnageIA;
import fr.iutinfo.studiesWar.models.PersonnageJoueur;

public class PersonnageTest {

	/*
	@Test
	public void test() {
		Personnage personnage = new PersonnageJoueur();
		Partie partie = new Partie(0, 0);
		partie.rejoinPartie(personnage);
		assertTrue(personnage.getStat("Maths") <= 20);
	}
	/*
	
	/**
	 * Verifie qu'il y a bien une stat elevee et une stat faible pour chaque initialisation d'un personnage
	 */
	@Test
	public void test1() {
		int cpt =0;
		while(cpt<25){
		Personnage p = new PersonnageJoueur();
		ArrayList<String> matieres = new ArrayList<String>();
		matieres.add("Maths");
		matieres.add("Triche");
		matieres.add("Algo");
		p.setCaracteristiques(matieres);
		int max = 0;
		for(int i=0;i<3;i++){
			if(max<p.getStat(matieres.get(i))){
				max = p.getStat(matieres.get(i));
			}
		}
		assertTrue(max >= 14);
		cpt++;
		}
	}
	
	@Test
	public void test2(){
		Partie p = new Partie();
		Personnage p1 = new PersonnageJoueur();
		p.rejoindrePartie(p1);
	}
	/*
	@Test
	public void testIA(){
		Partie p = new Partie();
		Personnage p1 = new PersonnageIA("Michelin");
		Personnage p2 = new PersonnageIA("Pascalin");
		Personnage p3 = new PersonnageIA("Augustin");
		p.rejoindrePartie(p1);
		p.rejoindrePartie(p2);
		p.rejoindrePartie(p3);	
		p.demarrerTour();
		System.out.println(p1.g(p.getSemaineActuelle().get(1)));
		System.out.println(p1.getActionduControle(p.getSemaineActuelle().get(2)));
		
	}
	*/
	

}
