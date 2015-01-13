package fr.iutinfo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public abstract class Personnage {
	
	private String nom ;
	private int PA;
	private HashMap<String,Byte> stats = new HashMap<String,Byte>();
	private ArrayList<Effet> ef ;
	
	
	public Personnage(String s){
		this.nom = s;
		this.ef = new ArrayList<Effet>();
		Random r = new Random();
		this.stats.put("Maths",(byte) r.nextInt(19));
		this.stats.put("Physique",(byte) r.nextInt(19));
		this.stats.put("SVT",(byte) r.nextInt(19));
		this.stats.put("Algo",(byte) r.nextInt(19));
		this.stats.put("Triche",(byte) r.nextInt(19));
	}
	
	public Personnage(){
		Random r = new Random();
		this.nom = "RandomGuy" + r.nextInt(10000);
		this.stats.put("Maths",(byte) r.nextInt(19));
		this.stats.put("Physique",(byte) r.nextInt(19));
		this.stats.put("SVT",(byte) r.nextInt(19));
		this.stats.put("Algo",(byte) r.nextInt(19));
		this.stats.put("Triche",(byte) r.nextInt(19));
	}
	
	public byte getStat(String s){
		return this.stats.get(s);
	}
	
	public void setStat(String s,byte i){
		this.stats.put(s,i);
	}
	
	/**
	 * 
	 * @param i
	 * @return return les effets de priorité i
	 */
	
	public ArrayList<Effet> getEffets(int i){
		return ef;
		
	}
	
	
	

}
