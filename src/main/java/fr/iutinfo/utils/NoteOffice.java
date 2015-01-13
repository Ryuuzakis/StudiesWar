package fr.iutinfo.utils;

public class NoteOffice extends Effet {
	private byte note ;
	
	public NoteOffice(byte dD, byte dF,byte n) {
		super(dD, dF,(byte)1);
		this.note = n;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void modifNote(Note n) {
		n.setNote(this.note);
	}

}
