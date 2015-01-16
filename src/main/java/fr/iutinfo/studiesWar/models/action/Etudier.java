package fr.iutinfo.studiesWar.models.action;

import java.util.Random;

import fr.iutinfo.studiesWar.models.Controle;
import fr.iutinfo.studiesWar.models.Personnage;
import fr.iutinfo.studiesWar.models.effet.BoostNote;

public class Etudier extends Action {
	int eff ;
	private int puissance;
	
	public Etudier(Personnage p,Controle c,int puissance,String s){
		super(p,s,c);
		this.puissance=puissance;
		Random r = new Random();
		this.eff = (r.nextInt(p.getStat("Etudier")/3)+1)*(r.nextInt(puissance)+1);
	}

	@Override
	public void agit() {
		p.addEffect(new BoostNote((byte)1,(byte)7,eff,controle.getMatiere()));
		this.decrement(puissance);
	}
	

}
