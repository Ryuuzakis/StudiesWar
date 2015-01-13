package fr.iutinfo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public abstract class Personnage {
	
	private String nom ;
	private int PA;
<<<<<<< HEAD
	private HashMap<String,Integer> stats = new HashMap<String,Integer>();
	private ArrayList<Effet> ef ;
=======
	private HashMap<String,Byte> stats = new HashMap<String,Byte>();
	private ArrayList<Effet> ef ;

>>>>>>> 31a4ae7f27bc0afb49d3f37a549887021a91b609
	
	
	public Personnage(String s){
		this.nom = s;
		this.ef = new ArrayList<Effet>();
		Random r = new Random();
<<<<<<< HEAD
		this.stats.put("Maths", r.nextInt(19));
		this.stats.put("Physique", r.nextInt(19));
		this.stats.put("SVT", r.nextInt(19));
		this.stats.put("Algo", r.nextInt(19));
		this.stats.put("Triche", r.nextInt(19));
=======
		this.stats.put("Maths",(byte) r.nextInt(19));
		this.stats.put("Physique",(byte) r.nextInt(19));
		this.stats.put("SVT",(byte) r.nextInt(19));
		this.stats.put("Algo",(byte) r.nextInt(19));
		this.stats.put("Triche",(byte) r.nextInt(19));
>>>>>>> 31a4ae7f27bc0afb49d3f37a549887021a91b609
	}
	
	public Personnage(){
		Random r = new Random();
		this.nom = "RandomGuy" + r.nextInt(10000);
<<<<<<< HEAD
		
		this.stats.put("Maths",r.nextInt(19));
		this.stats.put("Physique", r.nextInt(19));
		this.stats.put("SVT", r.nextInt(19));
		this.stats.put("Algo", r.nextInt(19));
		this.stats.put("Triche", r.nextInt(19));
=======
		this.stats.put("Maths",(byte) r.nextInt(19));
		this.stats.put("Physique",(byte) r.nextInt(19));
		this.stats.put("SVT",(byte) r.nextInt(19));
		this.stats.put("Algo",(byte) r.nextInt(19));
		this.stats.put("Triche",(byte) r.nextInt(19));

>>>>>>> 31a4ae7f27bc0afb49d3f37a549887021a91b609
	}
	
	public Integer getStat(String s){
		return this.stats.get(s);
	}
	
<<<<<<< HEAD
	public void setStat(String s,int i){
		this.stats.put(s,i);
	}

=======
	public void setStat(String s,byte i){
		this.stats.put(s,i);
	}
	
>>>>>>> 31a4ae7f27bc0afb49d3f37a549887021a91b609
	/**
	 * 
	 * @param i
	 * @return return les effets de priorité i
	 */
	
	public ArrayList<Effet> getEffets(int i){
		ArrayList<Effet> res = new ArrayList<Effet>();
		for(int cpt=0;cpt<ef.size();cpt++){
			if(ef.get(cpt).priorite == i){
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
