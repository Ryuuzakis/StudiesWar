package fr.iutinfo.utils;

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
<<<<<<< HEAD
		for(Personnage p:partie.getPersonnes()){
			notes.put(p, new Note(this,p));
=======
		for(Personnage p:partie){
			notes.put(p, new Note(this.p));
>>>>>>> 31a4ae7f27bc0afb49d3f37a549887021a91b609
		}
	}

	public void calculerNoteDe(Personnage p){
		
		Note note=new Note(this,p);
		notes.put(p, note);
	}

	public String getMatiere() {
		return matiere;
	}

	public byte getDate() {
		return date;
	}
	
	
}
