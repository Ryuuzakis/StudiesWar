package fr.iutinfo.studiesWar.models;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
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
	 * methode appelé quand un joueur rejoin la partie
	 */
	public void rejoinPartie(Personnage p){
		p.setMatieres(matieres);
		personnes.add(p);
	}
	/**
	 * methode appelé a chaque debut de tour
	 */
	public void DebutDuTour(){
		byte date=(byte) (new Random().nextInt(6)+1);
		Controle controle;
		do {
			controle=new Controle(matieres.get(new Random().nextInt(matieres.size()-2)), this, date);
		} while (semaineActuel.containsValue(controle));
		semaineActuel.put(date,controle);
	}
	/**
	 * methode appelé a chaque fin de tour
	 */
	public void finDuTour(){
		for(Controle c : semaineActuel.values()){
			c.calculerTousLesNotes();
		}
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
	
}
