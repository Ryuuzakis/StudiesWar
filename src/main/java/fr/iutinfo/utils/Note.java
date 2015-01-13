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
			for(int i=0;i<personne.getEffets(3).size();i++){
				personne.getEffets(3).get(i).modifNote(this);
			}
		}
	}

	public int getNote() {
		return note;
	}
	
<<<<<<< HEAD
	public void setNote(int i) {
		this.note=note+i;
		
=======
	public void setNote(byte i) {
		this.note =(byte) (note+i);
>>>>>>> 31a4ae7f27bc0afb49d3f37a549887021a91b609
	}

	public Controle getControle() {
		return controle;
	}

	

	
	
	
}
