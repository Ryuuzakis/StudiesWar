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
	
	private void init() {
		for(Personnage p:partie.getPersonnes()){
			notes.put(p, new Note(this,p));
		}
	}

	public void calculerTousLesNotes(){
		
		for(Evenement e : events){
			e.alieu();
		}
		
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
			this.getNote(p).calculNoteRelationEchange();
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
		Evenement e=Parametre.gestionEvent(this,partie);
		if(e!=null)
			events.add(e);
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + date;
		result = prime * result + ((matiere == null) ? 0 : matiere.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Controle other = (Controle) obj;
		if (obj == null)
			if (this == null)
				return true;
		if (matiere == null) {
			if (other.matiere != null)
				return false;
		} else if (!matiere.equals(other.matiere))
			return false;
		if (date != other.date)
			return false;
		return true;
	}
	
	
}
