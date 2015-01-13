package fr.iutinfo.utils;

import java.util.HashMap;
import java.util.Random;


public class Personnage {
	
	private String nom ;
	private int PA;
	private HashMap<String,Integer> stats = new HashMap<String,Integer>();
	
	
	public Personnage(String s){
		this.nom = s;
		Random r = new Random();
		this.stats.put("Maths",r.nextInt(20));
		this.stats.put("Physique",r.nextInt(20));
		this.stats.put("SVT",r.nextInt(20));
		this.stats.put("Algo",r.nextInt(20));
		this.stats.put("Triche",r.nextInt(20));
	}
	
	public Personnage(){
		Random r = new Random();
		this.nom = "RandomGuy"+r.nextInt(100000);
		
		this.stats.put("Maths",r.nextInt(20));
		this.stats.put("Physique",r.nextInt(20));
		this.stats.put("SVT",r.nextInt(20));
		this.stats.put("Algo",r.nextInt(20));
		this.stats.put("Triche",r.nextInt(20));
	}
	
	
	

}
