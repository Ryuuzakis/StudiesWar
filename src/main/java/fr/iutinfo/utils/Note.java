package fr.iutinfo.utils;

import java.util.Random;

public class Note {
	
	private Controle controle;
	private byte note=0;
	boolean notefinal=true;
	private Personnage personne;
	
	public Note(Controle controle,Personnage p) {
		this.controle = controle;
		this.personne=p;
	}
	
	public void calculerNote(){
		for(Effet e:personne.getEffets(1)){
			e.modifNote(this);
		}
		if(personne.getEffets(1).isEmpty()){
			note=personne.getStat(controle.getMatiere());
			note+=new Random().nextInt(5)-2;
			
			for(Effet e:personne.getEffets(2)){
				e.modifNote(this);
			}
			
		}
		
	}
	
	public void calculNoteRelation(){
		if(personne.getEffets(3).isEmpty()){
			for(Effet e:personne.getEffets(3)){
				e.modifNote(this);
			}
		}
	}

	public byte getNote() {
		return note;
	}
	
	public void setNote(byte i) {
		this.note =(byte) (note+i);
	}

	public Controle getControle() {
		return controle;
	}

	
	
	
}
