package fr.iutinfo.studiesWar.models;

import java.util.EventObject;
import java.util.Random;

import fr.iutinfo.studiesWar.event.ControleBoost;
import fr.iutinfo.studiesWar.event.Evenement;
import fr.iutinfo.studiesWar.event.NoteOfficeEvent;
import fr.iutinfo.studiesWar.event.TromperDeCopie;

public class Parametre {

	public static Evenement gestionEvent(Controle c,Partie p) {
		Evenement e=null;
		if(new Random().nextInt(100)<1){
			e=new ControleBoost(p, "control trop simple", 5, c);
		}else if(new Random().nextInt(100)<1){
			e=new ControleBoost(p, "control trop dur", -5, c);
		}else if(new Random().nextInt(100)<1){
			e=new NoteOfficeEvent(p, "le prof s'est fait ecraser par un bus",c, -1);
		}else if(new Random().nextInt(100)<1){
			e=new NoteOfficeEvent(p, "le prof a la flemme de coriger 20 a tous le monde",c, 20);
		}else if(new Random().nextInt(100)<1){
			e=new TromperDeCopie(p, "le prof a melange les copies par erreur", c);
		}
		return e;
	}

	
	
}
