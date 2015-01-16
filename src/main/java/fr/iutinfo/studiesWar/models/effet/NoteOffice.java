package fr.iutinfo.studiesWar.models.effet;

import fr.iutinfo.studiesWar.models.Note;

public class NoteOffice extends Effet {
	private int note ;
	
	public NoteOffice(int dD, int dF,int n) {
		super(dD, dF,1);
		this.note = n;
		
	}

	@Override
	public void modifNote(Note n) {
		n.setNote(this.note);
	}
}
