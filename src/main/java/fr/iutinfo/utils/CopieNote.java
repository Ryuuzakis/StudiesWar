package fr.iutinfo.utils;

public class CopieNote extends Effet{
	Personnage personnage;

	public CopieNote(byte dD, byte dF,Personnage p) {
		super(dD, dF, (byte) 2);
		this.personnage = p;
	}

	@Override
	public void modifNote(Note n) {
		
	}

}
