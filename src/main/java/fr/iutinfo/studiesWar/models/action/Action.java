package fr.iutinfo.studiesWar.models.action;

import fr.iutinfo.studiesWar.models.Controle;
import fr.iutinfo.studiesWar.models.Personnage;

public abstract class Action {
	protected Personnage p ;
	protected Controle controle;
	protected String description;
	
	public Action(Personnage p,String description,Controle c){
		this.p = p;
		this.controle=c;
		this.description=description;
	}
	
	public void decrement(int i){
		p.setPA(p.getPA()-i);
	}
	
	public Controle getControle() {
		return controle;
	}

	public String toString(){
		return description;
	}
	
	public abstract void agit();

}
