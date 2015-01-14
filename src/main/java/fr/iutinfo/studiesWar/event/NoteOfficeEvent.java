package fr.iutinfo.studiesWar.event;

import java.util.Collections;
import java.util.Random;

import fr.iutinfo.studiesWar.models.Controle;
import fr.iutinfo.studiesWar.models.Partie;
import fr.iutinfo.studiesWar.models.Personnage;
import fr.iutinfo.studiesWar.models.effet.NoteOffice;

public class NoteOfficeEvent extends Evenement{

	public NoteOfficeEvent(Partie p,String s,int note) {
		super(p,s);
		if(!p.getPersonnes().isEmpty()){
			Collections.shuffle(p.getPersonnes());
			Personnage cible=p.getPersonnes().get(0);
			byte date=(byte)(new Random().nextInt(5)+1);
			cible.addEffect(new NoteOffice(date, (byte)(date+1), note));
		}
	}
	
	
}
