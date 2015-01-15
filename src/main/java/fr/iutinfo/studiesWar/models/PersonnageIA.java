package fr.iutinfo.studiesWar.models;

import java.util.Random;

import fr.iutinfo.studiesWar.models.action.Action;

public class PersonnageIA extends Personnage {

	public PersonnageIA(){
		super();
	}

	public void genererActions(Partie partie){
		super.genererActions(partie);
		Action tmp = actionPosibles.get(new Random().nextInt(actionPosibles.size()));
		actions.add(tmp);
	}

}
