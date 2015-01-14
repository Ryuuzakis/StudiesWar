package fr.iutinfo.studiesWar.models.action;

import fr.iutinfo.studiesWar.models.Personnage;
import fr.iutinfo.studiesWar.models.effet.NoteOffice;

public class Absence extends Action{
	byte dD;
	byte dF;
	
	public Absence(Personnage p,byte dD, byte dF,String s) {
		super(p,s);
		this.dD = dD;
		this.dF = dF;
		
	}

	@Override
	public void agit() {
		p.addEffect(new NoteOffice(dD,dF,-1));
	}

}
