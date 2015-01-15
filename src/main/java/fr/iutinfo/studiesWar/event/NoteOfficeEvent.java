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
		
	}

	@Override
	public boolean alieu() {
		for(Personnage cible : partie.getPersonnes())
			cible.addEffect(new NoteOffice(c.getDate(), (byte)(c.getDate()+1), note));
		return true;
		
	}
	
	
}
