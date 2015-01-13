package fr.iutinfo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public abstract class Personnage {
	
	private String nom ;
	private int PA;
	private HashMap<String,Byte> stats = new HashMap<String,Byte>();
<<<<<<< HEAD
=======
	private ArrayList<Effet> ef ;
>>>>>>> b6429833234c101bfcbc57b717a90ec3edd3389f
	
	
	public Personnage(String s){
		this.nom = s;
		this.ef = new ArrayList<Effet>();
		Random r = new Random();
<<<<<<< HEAD
		this.stats.put("Maths",(byte) r.nextInt(20));
		this.stats.put("Physique",(byte) r.nextInt(20));
		this.stats.put("SVT",(byte) r.nextInt(20));
		this.stats.put("Algo",(byte) r.nextInt(20));
		this.stats.put("Triche",(byte) r.nextInt(20));
=======
		this.stats.put("Maths",(byte) r.nextInt(19));
		this.stats.put("Physique",(byte) r.nextInt(19));
		this.stats.put("SVT",(byte) r.nextInt(19));
		this.stats.put("Algo",(byte) r.nextInt(19));
		this.stats.put("Triche",(byte) r.nextInt(19));
>>>>>>> b6429833234c101bfcbc57b717a90ec3edd3389f
	}
	
	public Personnage(){
		Random r = new Random();
		this.nom = "RandomGuy" + r.nextInt(10000);
<<<<<<< HEAD
		this.stats.put("Maths",(byte) r.nextInt(20));
		this.stats.put("Physique",(byte) r.nextInt(20));
		this.stats.put("SVT",(byte) r.nextInt(20));
		this.stats.put("Algo",(byte) r.nextInt(20));
		this.stats.put("Triche",(byte) r.nextInt(20));
=======
		this.stats.put("Maths",(byte) r.nextInt(19));
		this.stats.put("Physique",(byte) r.nextInt(19));
		this.stats.put("SVT",(byte) r.nextInt(19));
		this.stats.put("Algo",(byte) r.nextInt(19));
		this.stats.put("Triche",(byte) r.nextInt(19));
>>>>>>> b6429833234c101bfcbc57b717a90ec3edd3389f
	}
	
	public byte getStat(String s){
		return this.stats.get(s);
	}
	
<<<<<<< HEAD
	public void setStat(String s,Byte i){
=======
	public void setStat(String s,byte i){
>>>>>>> b6429833234c101bfcbc57b717a90ec3edd3389f
		this.stats.put(s,i);
	}

	public ArrayList<Effet> getEffets(int i) {
		// TODO Auto-generated method stub
		return null;
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
