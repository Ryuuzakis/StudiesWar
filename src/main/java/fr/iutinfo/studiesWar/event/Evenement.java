package fr.iutinfo.studiesWar.event;

import fr.iutinfo.studiesWar.models.Partie;

public abstract class Evenement {
	protected Partie partie;
	private String description;
	
	public Evenement(Partie p,String s){
		this.partie=p;
	}
	
	public abstract boolean alieu();
	
	public String toString(){
		return description;
	}
}
