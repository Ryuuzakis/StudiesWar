package fr.iutinfo.studiesWar.models.action;

import fr.iutinfo.studiesWar.models.Controle;
import fr.iutinfo.studiesWar.models.Personnage;

public class NeRienFaire extends Action{

	public NeRienFaire(Personnage p, String description, Controle c) {
		super(p, description, c);
		
	}

	@Override
	public void agit() {
	
	}
	
	

}
