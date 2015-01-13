package fr.iutinfo.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Controle {

	private String matiere;
	private Map<Personnage, Note> notes=new HashMap<Personnage, Note>();
	private Partie partie;
	private byte date;
	
	Controle(String s,Partie p,byte date){
		this.matiere=matiere;
		this.partie=p;
		this.date=date;
		init();
	}
	
	private void init() {
		for(Personnage p:partie.getPersonnes()){
			notes.put(p, new Note(this,p));
		}
	}

	public void calculerNoteDe(){
		
		Collections.sort(partie.getPersonnes(),new Comparator<Personnage>() {

			@Override
			public int compare(Personnage p1, Personnage p2) {
				if(getNote(p1)>getNote(p2)){
					return 1;
				}else if(getNote(p1)>getNote(p2)){
					return -1;
				}
				return 0;
			}
		});
		
		for(Personnage p : partie.getPersonnes()){
			
		}
	}

	public String getMatiere() {
		return matiere;
	}

	public byte getDate() {
		return date;
	}
	
	public int getNote(Personnage p){
		return notes.get(p).getNote();
	}
	
}
