package fr.iutinfo.studiesWar.models;

import java.util.Random;

import fr.iutinfo.studiesWar.event.ControleBoost;
import fr.iutinfo.studiesWar.event.Evenement;

public class Parametre {

	public static Evenement gestionEvent(Controle c,Partie p) {
		
		if(new Random().nextInt(100)<1){
			new ControleBoost(p, "", modif, c)
		}
		return null;
	}

	
	
}
