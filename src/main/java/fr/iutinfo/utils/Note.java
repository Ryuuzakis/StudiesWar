package fr.iutinfo.utils;

import java.util.Random;

public class Note {
	
	private Controle controle;
	private int note=0;
	boolean notefinal=true;
	private Personnage personne;
	
	public Note(Controle controle,Personnage p) {
		this.controle = controle;
		this.personne=p;
	}
	
	public void calculerNote(){
		for(Effet e:personne.getEffets(1,controle)){
			e.modifNote(this);
		}
		if(personne.getEffets(1,controle).isEmpty()){
			note=personne.getStat(controle.getMatiere());
			note+=new Random().nextInt(5)-2;
			
			for(Effet e:personne.getEffets(2,controle)){
				e.modifNote(this);
			}
			
		}
		
	}
	
	public void calculNoteRelation(){
		if(personne.getEffets(3,controle).isEmpty()){
			for(int i=0;i<personne.getEffets(3,controle).size();i++){
				personne.getEffets(3,controle).get(i).modifNote(this);
			}
		}
	}

	public int getNote() {
		return note;
	}
	

	public void setNote(int i) {
		this.note=note+i;
	}

	public Controle getControle() {
		return controle;
	}

	

	
	
	
}
