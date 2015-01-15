package fr.iutinfo.studiesWar.models.action;

import fr.iutinfo.studiesWar.models.Controle;
import fr.iutinfo.studiesWar.models.Personnage;
import fr.iutinfo.studiesWar.models.effet.NoteOffice;

public class Absence extends Action{
	
	public Absence(Personnage p,Controle c,String s) {
		super(p,s,c);
		
	}

	@Override
	public void agit() {
		p.addEffect(new NoteOffice(controle.getDate(),(byte)(controle.getDate()+1),-1));
	}

}
