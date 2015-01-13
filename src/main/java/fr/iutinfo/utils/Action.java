package fr.iutinfo.utils;

public abstract class Action {
	
	Personnage p ;
	
	public void decrement(int i){
		p.setPA(p.getPA()-i);
	}
	

}
