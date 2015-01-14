package fr.iutinfo.studiesWar.models;

public abstract class Action {
	protected Personnage p ;
	
	public Action(Personnage p){
		this.p = p;
	}
	
	public void decrement(int i){
		p.setPA(p.getPA()-i);
	}
	
	public abstract void agit();

}
