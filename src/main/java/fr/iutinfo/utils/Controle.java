package fr.iutinfo.utils;

import java.util.HashMap;
import java.util.Map;

public class Controle {

	private String matiere;
	private Map<Personnage, Note> notes=new HashMap<Personnage, Note>();
	private Partie partie;
	
	Controle(String s,Partie p){
		this.matiere=matiere;
		this.partie=p;
		init();
	}
	
	private void init() {
		for(Personnage p:partie){
			notes.put(p, new Note(this.p));
		}
	}

	public void calculerNoteDe(Personnage p){
		
		Note note=new Note(this,p);
		notes.put(p, note);
	}

	public String getMatiere() {
		return matiere;
	}
	
	
}
