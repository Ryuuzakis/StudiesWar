package fr.iutinfo.studiesWar.models;

public abstract class Evenement {
	private Partie partie;
	
	public Evenement(Partie p){
		this.partie=p;
	}
	
}
