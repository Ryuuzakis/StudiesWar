package fr.iutinfo.utils;

public class Absence extends Action{
	byte dD;
	byte dF;
	
	public Absence(byte dD, byte dF) {
		this.dD = dD;
		this.dF = dF;
		
	}

	@Override
	public void agit() {
		p.addEffect(new NoteOffice(dD,dF,-1));
	}

}
