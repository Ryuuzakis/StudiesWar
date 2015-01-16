package fr.iutinfo.studiesWar.models;

import java.util.Random;

import fr.iutinfo.studiesWar.event.ControleBoost;
import fr.iutinfo.studiesWar.event.Evenement;
import fr.iutinfo.studiesWar.event.NoteOfficeEvent;
import fr.iutinfo.studiesWar.event.TromperDeCopie;

public class Parametre {

	public static Evenement gestionEvent(Controle c,Partie p) {
		Evenement e=null;
		if(new Random().nextInt(100)<1){
			e=new ControleBoost(p, "Contrôle trop simple", 5, c);
		}else if(new Random().nextInt(100)<1){
			e=new ControleBoost(p, "Contrôle trop dur", -5, c);
		}else if(new Random().nextInt(100)<1){
			e=new NoteOfficeEvent(p, "Le professeur s'est fait écraser par un bus",c, -1);
		}else if(new Random().nextInt(100)<1){
			e=new NoteOfficeEvent(p, "Le professeur a la flemme de corriger. 20 à tous le monde",c, 20);
		}else if(new Random().nextInt(100)<1){
			e=new TromperDeCopie(p, "Le professeur a melangé les copies par erreur", c);
		}
		return e;
	}

	
	
}
