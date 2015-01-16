package fr.iutinfo.studiesWar.models;

import java.util.Random;

public class PersonnageIA extends Personnage {

	public PersonnageIA(String nom){
		super(nom);
	}

	public void genererActions(Partie partie){
		super.genererActions(partie);
		for(Controle c : partie.getSemaineActuelle().values()){
			actions.add(getActionduControle(c).get(new Random().nextInt(getActionduControle(c).size())));
		}
		for(Action a : actions){
			a.agit();
		}
		setaJoue(true);
	}

}
