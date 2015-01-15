package fr.iutinfo.studiesWar.models.effet;

import fr.iutinfo.studiesWar.models.Note;
import fr.iutinfo.studiesWar.models.Personnage;

public class EchangeCopie extends Effet{
	private Personnage personnage;

	public EchangeCopie(int dD, int dF,Personnage p) {
		super(dD, dF, 4);
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
