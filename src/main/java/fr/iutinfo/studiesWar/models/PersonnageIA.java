package fr.iutinfo.studiesWar.models;

import java.util.Random;

import fr.iutinfo.studiesWar.models.action.Action;

public class PersonnageIA extends Personnage {

	public PersonnageIA(String nom){
		super(nom);
	}

	public void genererActions(Partie partie){
		super.genererActions(partie);
		Action tmp = actionPossibles.get(new Random().nextInt(actionPossibles.size()));
		actions.add(tmp);
	}

}
