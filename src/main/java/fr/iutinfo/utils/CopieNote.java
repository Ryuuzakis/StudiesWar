package fr.iutinfo.utils;

public class CopieNote extends Effet{
	private Personnage personnage;

	public CopieNote(byte dD, byte dF,Personnage p) {
		super(dD, dF, (byte) 2);
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
