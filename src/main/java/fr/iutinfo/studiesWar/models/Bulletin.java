package fr.iutinfo.studiesWar.models;

import java.util.ArrayList;

public class Bulletin {
	
	private ArrayList<ArrayList<Controle>> bulletin = new ArrayList<ArrayList<Controle>>();
	
	public void addResult(Partie p){
		ArrayList<Controle> cont = new ArrayList<Controle>();
		for(Controle c : p.getSemaineActuelle().values()){
			cont.add(c);
		}
		bulletin.add(cont);
	}
	
	public ArrayList<Controle> getResult(int semaine){
		return bulletin.get(semaine);
	}
	
	public int getNumBulletin(){
		return bulletin.size();
	}

}
