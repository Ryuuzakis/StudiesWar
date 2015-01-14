package fr.iutinfo.studiesWar.models.effet;

import fr.iutinfo.studiesWar.models.Note;
import fr.iutinfo.studiesWar.models.Personnage;

public class EchangeCopie extends Effet{
	private Personnage personnage;

	public EchangeCopie(byte dD, byte dF,Personnage p) {
		super(dD, dF, (byte) 4);
		this.personnage = p;
	}

	@Override
	public void modifNote(Note n) {
		if(personnage.getEffets(1, n.getControle()).isEmpty()){
			int tmp= n.getControle().getNote(personnage).getNote();
			n.getControle().getNote(personnage).setNote(n.getNote());
			n.setNote(tmp);
			//n.getPersonne().clearEffet(this);
		}
	}

}
