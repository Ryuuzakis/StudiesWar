package fr.iutinfo.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Controle {

	private String matiere;
	private Map<Personnage, Note> notes=new HashMap<Personnage, Note>();
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
			if(this.getNote(p).getNote()>20){
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
				if(getNote(p1).getNote()>getNote(p2).getNote()){
					return 1;
				}else if(getNote(p1).getNote()>getNote(p2).getNote()){
					return -1;
				}
				return 0;
			}
		});
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
	
}
