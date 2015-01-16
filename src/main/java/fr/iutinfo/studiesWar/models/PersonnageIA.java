package fr.iutinfo.studiesWar.models;

import java.util.Random;

import fr.iutinfo.studiesWar.models.action.Action;

public class PersonnageIA extends Personnage {

	public PersonnageIA(String nom){
		super(nom);
	}

	public void genererActions(Partie partie){
		super.genererActions(partie);
		for(Controle c : partie.getSemaineActuelle().values()){
			actions.add(getActionduControle(c).get(new Random().nextInt(getActionduControle(c).size())));
		}
		setaJoue(true);
		
	}

}
