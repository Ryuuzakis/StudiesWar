package fr.iutinfo.studiesWar.models;

import java.util.Random;

public class Etudier extends Action {
	int eff ;
	String matiere;
	private int puissance;
	
	public Etudier(Personnage p,String matiere,int puissance){
		super(p);
		this.puissance=puissance;
		Random r = new Random();
		this.eff = (r.nextInt(2)+1)*(r.nextInt(puissance)+1);
		this.matiere = matiere;
	}

	@Override
	public void agit() {
		p.addEffect(new BoostNote((byte)1,(byte)7,eff,this.matiere));
		this.decrement(puissance);
	}
	

}
