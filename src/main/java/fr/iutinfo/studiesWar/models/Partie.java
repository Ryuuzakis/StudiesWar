package fr.iutinfo.studiesWar.models;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import fr.iutinfo.studiesWar.models.action.Action;

public class Partie {

	private ArrayList<Personnage> personnes;
	private HashMap<Byte, Controle> semaineActuel=new HashMap<Byte, Controle>();
	private ArrayList<String> matieres = new ArrayList<String>();

	private int dureeTour;
	private int id;

	public Partie(int dureeTour,int id){
		this.id=id;
		this.dureeTour=dureeTour;
		this.personnes=new ArrayList<Personnage>();
		initMatieres();
	}
	private void initMatieres() {
		matieres.add("Maths");
		matieres.add("Physique");
		matieres.add("SVT");
		matieres.add("Etudier");
		matieres.add("Triche");
	}
	/**
	 * methode appelee quand un joueur rejoin la partie
	 */
	public void rejoinPartie(Personnage p){
		p.setMatieres(matieres);
		personnes.add(p);
	}
	/**
	 * methode appelee a chaque debut de tour
	 */
	public void DebutDuTour(){
		for(Personnage p : this.personnes){
			p.setPA(p.getPA()/2+5);
		}
		byte date=(byte) (new Random().nextInt(6)+1);
		Controle controle;
		//TODO: Tester si la boucle permet bien de ne pas avoir de doublons dans la map
		do {
			controle=new Controle(matieres.get(new Random().nextInt(matieres.size()-2)), this, date);
		} while (semaineActuel.containsValue(controle));
		semaineActuel.put(date,controle);
	}
	/**
	 * methode appelee a chaque fin de tour
	 */
	public boolean finDuTour(){
		Map<Personnage,Double>moy = new HashMap<Personnage,Double>();
		for(Controle c : semaineActuel.values()){
			c.calculerTousLesNotes();
		}
		for(Personnage p : this.personnes){
			Double moyen = 0.0 ;
			int coef = semaineActuel.size();
			for(Controle c : semaineActuel.values()){
				if(c.getNote(p).getNote()!=-1){
				moyen = moyen + c.getNote(p).getNote();
				}
				else{
					coef--;
				}
			}
			moyen = moyen / coef;
			moy.put(p,moyen);
		}
		ArrayList<Map.Entry<Personnage,Double>> list=new ArrayList<Map.Entry<Personnage,Double>>();
		for(Map.Entry<Personnage,Double> entry : moy.entrySet()){
			list.add(entry);
		}
		
		Collections.sort(list,new Comparator<Map.Entry<Personnage,Double>>() {
			@Override
			public int compare(Map.Entry<Personnage, Double> e1,Map.Entry<Personnage, Double> e2) {
				if(e1.getValue()>e2.getValue()){
					return 1;
				}else if(e1.getValue()<e2.getValue()) {
					return -1;
				}	
				return 0;
			}
		});
		
		this.elimine(list.get(0).getKey());
		if (personnes.size() > 1) {
			return false;
		}
		return true;
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
		p.genererActions(this);
		return p.getAction();
	}
	public ArrayList<String> getResultats() {
		ArrayList<String> results = new ArrayList<String>();
		for (Controle c : semaineActuel.values()) {
			String ch = c.getMatiere() + " : \n";
			for (Map.Entry<Personnage, Note> res : c.getNotes().entrySet()) {
				ch += "\t" + res.getKey().getNom() + " : " + res.getValue().getNote() + "\n";
			}
			results.add(ch);
		}
		return results;
	}
	
	public void elimine(Personnage p){
		this.personnes.remove(p);
	}
	
	public boolean joueurElimine(Personnage p){
		for(Personnage p2 : this.personnes){
			if(p2.equals(p)){
				return false;
			}
		}
		return true;
	}
	
}
