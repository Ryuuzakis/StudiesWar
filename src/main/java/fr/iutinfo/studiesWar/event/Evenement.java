package fr.iutinfo.studiesWar.event;

import fr.iutinfo.studiesWar.models.Partie;

public abstract class Evenement {
	private Partie partie;
	
	public Evenement(Partie p){
		this.partie=p;
	}
	
}
