package fr.iutinfo.studiesWar.models;

import java.util.HashMap;

public class BoostNote extends Effet {
	private int modificateur;
	private String matiere;

	public BoostNote(byte dD, byte dF, int modif,String matiere) {
		super(dD, dF, (byte) 3);
		this.modificateur = modif;
		this.matiere = matiere;
	}

	@Override
	public void modifNote(Note n) {
		if(n.getControle().getMatiere().equals(matiere)){
			n.setNote(n.getNote() + this.modificateur);
		}
	}

}


