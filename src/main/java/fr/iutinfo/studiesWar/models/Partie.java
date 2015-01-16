package fr.iutinfo.studiesWar.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import fr.iutinfo.studiesWar.models.action.Action;

public class Partie {

	private ArrayList<Personnage> personnes;
	private HashMap<Integer, Controle> semaineActuelle=new HashMap<Integer, Controle>();
	private ArrayList<String> matieres = new ArrayList<String>();
	private int numTour;
	private Bulletin bulletin = new Bulletin();
	private boolean estLancee=false;
	
	public static final int NB_JOUEURS = 5;
	public static int nbControles = 4;
	public Partie(){
		this.numTour=0;
		this.personnes=new ArrayList<Personnage>();
		initMatieres();
	}
	public int getNumTour() {
		return numTour;
	}
	public void setNumTour(int numTour) {
		this.numTour = numTour;
	}
	private void initMatieres() {
		matieres.add("Maths");
		matieres.add("Physique");
		matieres.add("SVT");
		matieres.add("Sport");
		matieres.add("Français");
		matieres.add("Histoire");
		matieres.add("Chimie");
		matieres.add("Etudier");
		matieres.add("Triche");
	}
	/**
	 * methode appelee quand un joueur rejoint la partie
	 */
	public void rejoindrePartie(Personnage p){
		p.setCaracteristiques(matieres);
		personnes.add(p);
	}
	
	public void lancerPartie() {
		semaineActuelle=new HashMap<Integer, Controle>();
		estLancee=true;
		ajouterJoueursIA();
		demarrerTour();
	}
	private void ajouterJoueursIA() {
		for (int i = personnes.size(); i < NB_JOUEURS ; i++){
			PersonnageIA ia = new PersonnageIA(PersonnageIA.getNomRandom(i));
			ia.setCaracteristiques(matieres);
			personnes.add(ia);
		}
	}
	/**
	 * methode appelee a chaque debut de tour
	 */
	public void demarrerTour(){
		semaineActuelle.clear();
		nbControles = (int) (Math.random() * 3 + 3);
		this.setNumTour(this.getNumTour()+1);
		for(Personnage p : this.personnes){
			p.setPA(p.getPA()/2+5);
		}
		ArrayList<String> tmpMatieres = new ArrayList<String>();
		for (int i = 0; i < matieres.size() - 2; i++)
			tmpMatieres.add(matieres.get(i));
		
		ArrayList<Integer> dates = new ArrayList<Integer>();
		dates.add(1);
		dates.add(2);
		dates.add(3);
		dates.add(4);
		dates.add(5);
		
		for (int i = 0; i < nbControles; i++) {
			int idxMatiere = (int) (Math.random() * tmpMatieres.size());
			int idxJour = (int) (Math.random() * dates.size());
			Controle controle = new Controle(tmpMatieres.remove(idxMatiere),
					this, dates.get(idxJour));
			semaineActuelle.put(dates.remove(idxJour), controle);
		}
		for (Personnage p : personnes)
			p.genererActions(this);
	}
	/**
	 * methode appelee a chaque fin de tour
	 */
	public void finDuTour(){
		Map<Personnage,Double>moy = new HashMap<Personnage,Double>();
		for(Controle c : semaineActuelle.values()){
			c.calculerToutesLesNotes();
		}
		for(Personnage p : this.personnes){
			Double moyen = 0.0 ;
			int coef = semaineActuelle.size();
			for(Controle c : semaineActuelle.values()){
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
		
		bulletin.addResult(this);
		elimine(list.get(0).getKey());
	}
	
	
	
	/**
	 * @return nb de joueur restant dans la partie
	 */
	public int getNbJoueursRestant(){
		return personnes.size();
	}
	
	public ArrayList<Personnage> getPersonnes() {
		return personnes;
	}
	
	public HashMap<Integer, Controle> getSemaineActuelle() {
		return semaineActuelle;
	}
	
	public ArrayList<Action> getActionsPossibles(Personnage p){
		return p.getActionPossibles();
	}
	
	public ArrayList<String> getResultats() {
		ArrayList<String> results = new ArrayList<String>();
		for (Controle c : semaineActuelle.values()) {
			String ch = c.getMatiere() + " : \n";
			for (Map.Entry<Personnage, Note> res : c.getNotes().entrySet()) {
				
				ch += "\t" + res.getKey().getNom() + " : ";
				if(res.getValue().getNote()==-1){
					ch+= "abs \n";
				}else{
					ch+= res.getValue().getNote() + "\n";
				}
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
	public ArrayList<Action> getActions(Controle controleDuJour,PersonnageJoueur pj) {
		return pj.getActionduControle(controleDuJour);
	}
	
	public ArrayList<String> getResultatsSemaine(int semaine,Personnage p){
		ArrayList<String>res = new ArrayList<String>();
		for(int i=0;i<bulletin.getResult(semaine).size();i++){
			res.add(bulletin.getResult(semaine).get(i).toString(p));
		}
		return res;
	}
	public boolean tourEstTermine() {
		for(Personnage p : personnes){
			if(!p.aJoue())
				return false;
		}
		return true;
	}
	
	public int getNumBulletin(){
		return bulletin.getNumBulletin();
	}
	public boolean estLancee() {
		return estLancee;
	}
	
	
}
