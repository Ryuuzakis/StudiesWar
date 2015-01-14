package fr.iutinfo.utils;

import java.util.Random;

public class Tricher extends Action{
	
	private Personnage destPersonnage;
	private Controle controle;
	
	public Tricher(Personnage p,Personnage destPersonnage,Controle controle){
		super(p);
		this.destPersonnage = destPersonnage;
		this.controle=controle;
	}

	@Override
	public void agit() {
		p.addEffect(new CopieNote(controle.getDate(),(byte)(controle.getDate()+1),this.destPersonnage));
	}
	

}

