package fr.iutinfo.studiesWar.models.effet;

import fr.iutinfo.studiesWar.models.Note;
import fr.iutinfo.studiesWar.models.Personnage;

public class CopieNote extends Effet{
	private Personnage personnage;

	public CopieNote(byte dD, byte dF,Personnage p) {
		super(dD, dF, (byte) 3);
		this.personnage = p;
	}

	@Override
	public void modifNote(Note n) {
		if(n.getNote()<n.getControle().getNote(personnage).getNote()){
			n.setNote(n.getControle().getNote(personnage).getNote());
			n.getPersonne().clearEffet(this);
		}
	}

}
