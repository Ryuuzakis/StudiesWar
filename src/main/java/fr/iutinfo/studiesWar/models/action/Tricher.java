package fr.iutinfo.studiesWar.models.action;

import java.util.Random;

import fr.iutinfo.studiesWar.models.Controle;
import fr.iutinfo.studiesWar.models.Personnage;
import fr.iutinfo.studiesWar.models.effet.CopieNote;
import fr.iutinfo.studiesWar.models.effet.NoteOffice;

public class Tricher extends Action{
	
	private Personnage destPersonnage;
	
	public Tricher(Personnage p,Personnage destPersonnage,Controle c,String s){
		super(p,s,c);
		this.destPersonnage = destPersonnage;
	}

	@Override
	public void agit() {
		//int test = new Random().nextInt(20) * p.getStat("Triche");
		if(new Random().nextInt(100) + p.getStat("Triche") >= 24){
			p.addEffect(new CopieNote(controle.getDate(),(controle.getDate()+1),
					this.destPersonnage));
		}
		else{
			p.addEffect(new NoteOffice(controle.getDate(),(byte)(controle.getDate()+1),0));
		}
	}
	

}

