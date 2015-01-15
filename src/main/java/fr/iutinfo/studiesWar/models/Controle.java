package fr.iutinfo.studiesWar.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import fr.iutinfo.studiesWar.event.Evenement;

public class Controle {

	private String matiere;
	private Map<Personnage, Note> notes=new HashMap<Personnage, Note>();
	private ArrayList<Evenement> events=new ArrayList<Evenement>();
	private Partie partie;
	private byte date;
	
	public Controle(String s,Partie p,byte date){
		this.matiere=s;
		this.partie=p;
		this.date=date;
		init();
	}
	
	@Override
	public boolean equals(Object o) {
		Controle c = (Controle) o;
		return c.matiere.equals(matiere);
	}
	
	private void init() {
		for(Personnage p:partie.getPersonnes()){
			notes.put(p, new Note(this,p));
		}
	}

	public void calculerTousLesNotes(){

		for(Personnage p : partie.getPersonnes()){
			this.getNote(p).calculerNote();
		}
		int n;
		boolean changement=true;
		while(changement){
			changement=false;
			triParNote();
			for(Personnage p : partie.getPersonnes()){
				n=this.getNote(p).getNote();
				this.getNote(p).calculNoteRelation();
				if(n!=this.getNote(p).getNote()){
					changement=true;
				}
			}
		}
		for(Personnage p : partie.getPersonnes()){
			if(!p.getEffets(1, this).isEmpty()){
			}else if(this.getNote(p).getNote()>20){
				this.getNote(p).setNote(20);
			}else if(this.getNote(p).getNote()<0){
				this.getNote(p).setNote(0);
			}
		}
		
	}
	
	public void triParNote(){
		Collections.sort(partie.getPersonnes(),new Comparator<Personnage>() {

			@Override
			public int compare(Personnage p1, Personnage p2) {
				if(getNote(p1).getNote()<getNote(p2).getNote()){
					return 1;
				}else if(getNote(p1).getNote()>getNote(p2).getNote()){
					return -1;
				}
				return 0;
			}
		});
	}
	
	public void GenereEvent(){
		//TODO : Corriger l'erreur
		//events.add(Parametre.gestionEvent());
	}

	public String getMatiere() {
		return matiere;
	}

	public byte getDate() {
		return date;
	}
	
	public Note getNote(Personnage p){
		return notes.get(p);
	}
	
	public Map<Personnage, Note> getNotes(){
		return notes;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Controle other = (Controle) obj;
		if (date != other.date)
			return false;
		if (matiere == null) {
			if (other.matiere != null)
				return false;
		} else if (!matiere.equals(other.matiere))
			return false;
		return true;
	}
	
	
}
