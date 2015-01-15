package fr.iutinfo;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.junit.Test;

import fr.iutinfo.studiesWar.models.Controle;
import fr.iutinfo.studiesWar.models.Partie;
import fr.iutinfo.studiesWar.models.Personnage;
import fr.iutinfo.studiesWar.models.PersonnageJoueur;

public class PartieTest {

	@Test
	public void test() {
		int i = 0;
		while(i<25){
			Partie p = new Partie();
			Personnage p1 = new PersonnageJoueur();
			p.rejoindrePartie(p1);
			p.demarrerTour();
			HashMap<Integer,Controle> h = p.getSemaineActuelle();
			ArrayList<Controle> l = new ArrayList<Controle>();
			Iterator<Map.Entry<Integer, Controle>> iterator = h.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Integer, Controle> entry = iterator.next();
				l.add((Controle) entry.getValue());
			}
			ArrayList<String> a = new ArrayList<String>();
			for(int cpt = 0;cpt<h.size();cpt ++){
				if(a.contains(l.get(cpt).getMatiere())){
					fail();
				}
				else{
					a.add(l.get(cpt).getMatiere());
				}
			}
			i++;	
		}
	}

}
