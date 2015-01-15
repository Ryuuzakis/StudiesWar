package fr.iutinfo.studiesWar.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import fr.iutinfo.studiesWar.models.action.Absence;
import fr.iutinfo.studiesWar.models.action.Action;
import fr.iutinfo.studiesWar.models.action.Etudier;
import fr.iutinfo.studiesWar.models.action.Tricher;
import fr.iutinfo.studiesWar.models.effet.Effet;


public abstract class Personnage {
	
	private String nom;
	private int PA = 5;
	private HashMap<String,Integer> stats = new HashMap<String,Integer>();
	private ArrayList<Effet> effets ;
	//Ensemble des actions disponibles
	private ArrayList<Action> actionDispo;
	//Actions choisies 
	private ArrayList<Action> actions;
	
	public Personnage(String s){
		this.nom = s;
		this.effets = new ArrayList<Effet>();
		Random r = new Random();
		actionDispo = new ArrayList<Action>();
	}
	
	public Personnage(){
		this("");
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
			if(effets.get(cpt).getPriorite() == i && effets.get(cpt).estActif(c)){
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
	
	public void genererActions(Partie partie) {
		actionDispo.clear();
		for (Controle c : partie.getSemaineActuel().values()) {
			actionDispo.add(new Etudier(this, c.getMatiere(), 1,
					"etudier un peu pour le controle de " + c.getMatiere()));
			actionDispo.add(new Etudier(this, c.getMatiere(), 2,
					"etudier passinnement pour le controle de "
							+ c.getMatiere()));
			actionDispo
					.add(new Etudier(this, c.getMatiere(), 3,
							"etudier a la folie pour le controle de "
									+ c.getMatiere()));

			for (Personnage personnage : partie.getPersonnes()) {
				if (this != personnage) {
					actionDispo
							.add(new Tricher(this, personnage, c,
									"tricher sur " + personnage.getNom()
											+ " pour le controle de "
											+ c.getMatiere()));
				}
			}
			actionDispo
					.add(new Absence(this, c.getDate(),
							(byte) (c.getDate() + 1),
							"simuler une gastro pour le controle de "
									+ c.getMatiere()));
		}
		if (this instanceof PersonnageIA) {
			Action tmp = actionDispo.get(new Random().nextInt(actionDispo
					.size()));
			this.actions.add(tmp);
		}

	}
	
	public void addAction(Action a) {
		actions.add(a);
	}

	public ArrayList<Action> getAction() {
		return actions;
	}
	
	public void addEffect(Effet e){
		effets.add(e);
	}

	public void setMatieres(ArrayList<String> matieres) {
		for (String m : matieres){
			setStat(m, new Random().nextInt(20));
		}
		int iPlus = new Random().nextInt(matieres.size());
		int iMoins=iPlus;
		while(iMoins==iPlus){
			iMoins = new Random().nextInt(matieres.size());
		}
		setStat(matieres.get(iPlus),new Random().nextInt(7)+14);
		setStat(matieres.get(iMoins),new Random().nextInt(7));
	}
	
}
