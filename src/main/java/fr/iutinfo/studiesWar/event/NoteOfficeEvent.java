package fr.iutinfo.studiesWar.event;

import java.util.Collections;
import java.util.Random;

import fr.iutinfo.studiesWar.models.Controle;
import fr.iutinfo.studiesWar.models.Partie;
import fr.iutinfo.studiesWar.models.Personnage;
import fr.iutinfo.studiesWar.models.effet.NoteOffice;

public class NoteOfficeEvent extends Evenement{
	private int note;
	private Controle c;

	public NoteOfficeEvent(Partie p,String s,Controle c,int note) {
		super(p,s);
		this.note=note;
		this.c = c;
	}

	@Override
	public boolean alieu() {
		if(!partie.getPersonnes().isEmpty()){
			Collections.shuffle(partie.getPersonnes());
			Personnage cible=partie.getPersonnes().get(0);
			byte date=(byte)(new Random().nextInt(5)+1);
			cible.addEffect(new NoteOffice(date, (byte)(date+1),note));
			return true;
		}
		return false;
	}
	
	
}
