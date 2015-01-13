package fr.iutinfo.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Partie {

	private ArrayList<Personnage> personnes;
	private HashMap<Byte, Controle> semaineActuel=new HashMap<Byte, Controle>();
	private int dureeTour;
	private int id;

	Partie(int dureeTour,int id){
		this.id=id;
		this.dureeTour=dureeTour;
		this.personnes=new ArrayList<Personnage>();
	}
	/**
	 * methode appelé quand un joueur rejoin la partie
	 */
	public void rejoinPartie(Personnage p){
		personnes.add(p);
	}
	/**
	 * methode appelé a chaque debut de tour
	 */
	public void DebutDuTour(){
		
	}
	/**
	 * methode appelé a chaque fin de tour
	 */
	public void finDuTour(){
		
	}
	/**
	 * @return nb de joueur restant dans la partie
	 */
	public int getNombreDeleveRestant(){
		return personnes.size();
	}
	
	public ArrayList<Personnage> getPersonnes() {
		return personnes;
	}
	
	public HashMap<Byte, Controle> getSemaineActuel() {
		return semaineActuel;
	}
	
	public ArrayList<Action> getActions(Personnage p){
		p.genererAction();
		return p.getAction();
	}
	
	
}
