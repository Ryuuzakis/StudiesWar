package fr.iutinfo.studiesWar.models;

import java.util.ArrayList;
import java.util.Random;

import fr.iutinfo.studiesWar.models.action.Action;

public class PersonnageIA extends Personnage {

	private static ArrayList<String> noms;
	
	static{
		noms.add("Jean-Eudes");
		noms.add("Eustache");
		noms.add("Clotaire");
		noms.add("Gontrand");
		noms.add("Barnabé");
	}
	
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

	public static String getNomRandom(int i) {
		return noms.get(i);
	}

}
