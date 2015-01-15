package fr.iutinfo.studiesWar.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.eclipse.persistence.internal.jaxb.many.MapEntry;

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
	protected ArrayList<Action> actions;
	protected ArrayList<Action> actionPosibles;

	
	public Personnage(String s){
		this.nom = s;
		this.effets = new ArrayList<Effet>();
		Random r = new Random();
		actions = new ArrayList<Action>();
		actionPosibles = new ArrayList<Action>();
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
	
	
	public ArrayList<String> getStats(){
		ArrayList<String> res = new ArrayList<String>();
		for (Map.Entry<String, Integer> ch : stats.entrySet()) {
			res.add("\t" + ch.getKey() + " : " + ch.getValue() + "\n");
		}
		return res;
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
	
	public void genererActions(Partie partie){
		actionPosibles.clear();
		
		for(Controle c : partie.getSemaineActuel().values()){

			if (this.getPA() >= 1) {
			actionPosibles.add(new Etudier(this, c, 1,"etudier un peu"));
			if (this.getPA() >= 2) {
			actionPosibles.add(new Etudier(this, c, 2,"etudier passinnement"));
			if (this.getPA() >= 3) {
			actionPosibles.add(new Etudier(this, c, 3,"etudier a la folie"));
			}}}

			for(Personnage personnage :partie.getPersonnes()){
				if(!this.equals(personnage)){
					actionPosibles.add(new Tricher(this,personnage, c,"tricher sur "+personnage.getNom()));
				}
			}

			actionPosibles.add(new Absence(this, c,"simuler une gastro"));
		}

	}
	
	public void addAction(Action a) {
		actions.add(a);
	}
	
	public ArrayList<Action> getAction(Controle c){
		ArrayList<Action> actionControl=new ArrayList<Action>();
		for(Action a : actionPosibles){
			if(a.getControle().equals(c)){
				actionControl.add(a);
			}
		}
		return actionControl;
	}

	public ArrayList<Action> getActionPossibles() {
		return actionPosibles;
	}
	
	public void addEffect(Effet e){
		effets.add(e);
	}

	public void setMatieres(ArrayList<String> matieres) {
		int somme=0;
		int iPlus;
		int iMoins;
		do{
			somme=0;
			for (String m : matieres){
				setStat(m, new Random().nextInt(20));
			}
			iPlus = new Random().nextInt(matieres.size());
			iMoins=iPlus;
			while(iMoins==iPlus){
				iMoins = new Random().nextInt(matieres.size());
			}
			setStat(matieres.get(iPlus),new Random().nextInt(5)+16);
			setStat(matieres.get(iMoins),new Random().nextInt(5));
			for(String m : matieres){
				somme += this.getStat(m);
			}
		}while(somme <=8*matieres.size() || somme >= 12*matieres.size());

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Personnage other = (Personnage) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
		
	
	
}
