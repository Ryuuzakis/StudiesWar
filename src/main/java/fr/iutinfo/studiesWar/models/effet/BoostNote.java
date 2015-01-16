package fr.iutinfo.studiesWar.models.effet;

import fr.iutinfo.studiesWar.models.Note;

public class BoostNote extends Effet {
	private int modificateur;
	private String matiere;

	public BoostNote(int dD, int dF, int modif,String matiere) {
		super(dD, dF, 2);
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


