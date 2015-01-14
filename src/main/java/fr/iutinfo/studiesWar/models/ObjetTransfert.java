package fr.iutinfo.studiesWar.models;

public class ObjetTransfert {
	
	private int idPartie;
	private int idJoueur;
	
	public ObjetTransfert() { }
	
	public ObjetTransfert(int idPartie, int idJoueur) {
		this.idPartie = idPartie;
		this.idJoueur = idJoueur;
	}

	public int getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}

	public int getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	
	

}
