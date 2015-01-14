package fr.iutinfo.studiesWar.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public abstract class Personnage {
	
	private String nom;
	private int PA;
	private HashMap<String,Integer> stats = new HashMap<String,Integer>();
	private ArrayList<Effet> effets ;
	private ArrayList<Action> actionPosibles ;
	
	public Personnage(String s){
		this.nom = s;
		this.effets = new ArrayList<Effet>();
		Random r = new Random();
	}
	
	public Personnage(){
		this.effets = new ArrayList<Effet>();
		Random r = new Random();
	}
	
	public Integer getStat(String s){
		return this.stats.get(s);
	}
	
	public void setStat(String s,int i){
		this.stats.put(s,i);
	}
	/**
	 * 
	 * @param i
	 * @return return les effets de priorité i
	 */
	
	public ArrayList<Effet> getEffets(int i,Controle c){
		ArrayList<Effet> res = new ArrayList<Effet>();
		for(int cpt=0;cpt<effets.size();cpt++){
			if(effets.get(cpt).priorite == i && effets.get(cpt).estActif(c)){
				res.add(effets.get(cpt));
			}
		}
		return res;
		
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void clearEffet(Effet e){
		effets.remove(e);
	}

	public int getPA() {
		return PA;
	}

	public void setPA(int pA) {
		
		PA = pA;
	}
	
	public void genererActions(Partie partie){
		actionPosibles.clear();
		for(Controle c : partie.getSemaineActuel().values()){
			actionPosibles.add(new Etudier(this, c.getMatiere(), 1));
			actionPosibles.add(new Etudier(this, c.getMatiere(), 2));
			actionPosibles.add(new Etudier(this, c.getMatiere(), 3));
			
			for(Personnage personnage :partie.getPersonnes()){
				if(this!=personnage){
					actionPosibles.add(new Tricher(this,personnage, c));
				}
			}
			actionPosibles.add(new Absence(this, c.getDate(), (byte)(c.getDate()+1)));
		}
		
	}

	public ArrayList<Action> getAction() {
		return actionPosibles;
	}
	
	public void addEffect(Effet e){
		effets.add(e);
	}

	public void setMatieres(ArrayList<String> matieres) {
		for (String m : matieres)
			setStat(m, (int) Math.random() * 20);
	}
	
}
