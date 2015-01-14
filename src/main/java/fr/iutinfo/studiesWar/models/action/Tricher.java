package fr.iutinfo.studiesWar.models.action;

import java.util.Random;

import fr.iutinfo.studiesWar.models.Controle;
import fr.iutinfo.studiesWar.models.Personnage;
import fr.iutinfo.studiesWar.models.effet.CopieNote;

public class Tricher extends Action{
	
	private Personnage destPersonnage;
	private Controle controle;
	
	public Tricher(Personnage p,Personnage destPersonnage,Controle controle,String s){
		super(p,s);
		this.destPersonnage = destPersonnage;
		this.controle=controle;
	}

	@Override
	public void agit() {
		p.addEffect(new CopieNote(controle.getDate(),(byte)(controle.getDate()+1),this.destPersonnage));
	}
	

}

