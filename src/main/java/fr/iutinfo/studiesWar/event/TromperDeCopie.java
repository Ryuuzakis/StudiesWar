package fr.iutinfo.studiesWar.event;

import java.util.Collections;
import java.util.Random;

import fr.iutinfo.studiesWar.models.Controle;
import fr.iutinfo.studiesWar.models.Partie;
import fr.iutinfo.studiesWar.models.Personnage;
import fr.iutinfo.studiesWar.models.effet.EchangeCopie;
import fr.iutinfo.studiesWar.models.effet.NoteOffice;

public class TromperDeCopie extends Evenement{

	private Controle controle;

	public TromperDeCopie(Partie p,String s, Controle c) {
		super(p,s);
		this.controle=c;
	}

	public boolean alieu(){
		if(partie.getPersonnes().size()>=2){
			Collections.shuffle(partie.getPersonnes());
			partie.getPersonnes().get(0).addEffect(new EchangeCopie(controle.getDate(),(byte)(controle.getDate()+1),partie.getPersonnes().get(1)));
			return true;
		}
		return false;
	}
}
