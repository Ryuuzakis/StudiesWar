package fr.iutinfo.studiesWar.models;

import java.util.Random;

import fr.iutinfo.studiesWar.models.action.Action;

public class PersonnageIA extends Personnage {

	public PersonnageIA(){
		super();
	}
<<<<<<< HEAD
	
	
	
=======

	public void genererActions(Partie partie){
		super.genererActions(partie);
		Action tmp = actionPosibles.get(new Random().nextInt(actionPosibles.size()));
		actionPosibles.clear();
		actionPosibles.add(tmp);
	}

>>>>>>> d49f478af65fc1335cd38ff53b33efb4f4baecdc
}
