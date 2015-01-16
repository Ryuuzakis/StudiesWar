package fr.iutinfo.studiesWar.event;

import java.util.Collections;

import fr.iutinfo.studiesWar.models.Controle;
import fr.iutinfo.studiesWar.models.Partie;
import fr.iutinfo.studiesWar.models.Personnage;
import fr.iutinfo.studiesWar.models.effet.BoostNote;

public class ControleBoost extends Evenement{

	private Controle controle;
	private int modif;
	
	public ControleBoost(Partie p,String s,int modif,Controle c) {
		super(p,s);
	}

	@Override
	public boolean alieu() {
		if(!partie.getPersonnes().isEmpty()){
			Collections.shuffle(partie.getPersonnes());
			Personnage cible=partie.getPersonnes().get(0);
			for(int i = 0; i < partie.getPersonnes().size(); i++){
				cible.addEffect(new BoostNote(controle.getDate(), (controle.getDate()+1), modif, controle.getMatiere()));
			}
			return true;
		}
		return false;
	}
	
	
}
