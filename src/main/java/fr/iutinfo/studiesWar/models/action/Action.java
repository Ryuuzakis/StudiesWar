package fr.iutinfo.studiesWar.models.action;

import fr.iutinfo.studiesWar.models.Personnage;

public abstract class Action {
	protected Personnage p ;
	protected String description;
	
	public Action(Personnage p,String description){
		this.p = p;
		this.description=description;
	}
	
	public void decrement(int i){
		p.setPA(p.getPA()-i);
	}
	
	public String toString(){
		return description;
	}
	
	public abstract void agit();

}
