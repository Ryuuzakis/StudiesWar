package fr.iutinfo.utils;

public class Absence extends Action{
	byte dD;
	byte dF;
	
	public Absence(Personnage p,byte dD, byte dF) {
		super(p);
		this.dD = dD;
		this.dF = dF;
		
	}

	@Override
	public void agit() {
		p.addEffect(new NoteOffice(dD,dF,-1));
	}

}
