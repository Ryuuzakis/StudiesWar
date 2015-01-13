package fr.iutinfo.utils;

import java.util.HashMap;

public class BoostNote extends Effet {
	private byte modificateur;

	public BoostNote(byte dD, byte dF, byte modif) {
		super(dD, dF, (byte) 3);
		this.modificateur = modif;
	}

	@Override
	public void modifNote(Note n) {
		n.setNote(n.getNote() + this.modificateur);
	}

}


