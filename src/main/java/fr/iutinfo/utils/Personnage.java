package fr.iutinfo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public abstract class Personnage {
	
	private String nom ;
	private int PA;
	private HashMap<String,Integer> stats = new HashMap<String,Integer>();
	private ArrayList<Effet> ef ;
	
	
	public Personnage(String s){
		this.nom = s;
		this.ef = new ArrayList<Effet>();
		Random r = new Random();
		this.stats.put("Maths", r.nextInt(19));
		this.stats.put("Physique", r.nextInt(19));
		this.stats.put("SVT", r.nextInt(19));
		this.stats.put("Algo", r.nextInt(19));
		this.stats.put("Triche", r.nextInt(19));
	}
	
	public Personnage(){
		Random r = new Random();
		
		this.nom = "RandomGuy" + r.nextInt(10000);
		this.stats.put("Maths",r.nextInt(19));
		this.stats.put("Physique", r.nextInt(19));
		this.stats.put("SVT", r.nextInt(19));
		this.stats.put("Algo", r.nextInt(19));
		this.stats.put("Triche", r.nextInt(19));
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
		for(int cpt=0;cpt<ef.size();cpt++){
			if(ef.get(cpt).priorite == i && ef.get(cpt).estActif(c)){
				res.add(ef.get(cpt));
			}
		}
		return res;
		
	}
	
	public void clearEffet(Effet e){
		ef.remove(e);
	}

	public int getPA() {
		return PA;
	}

	public void setPA(int pA) {
		PA = pA;
	}
	
	
	
	

}
