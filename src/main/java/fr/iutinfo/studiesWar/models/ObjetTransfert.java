package fr.iutinfo.studiesWar.models;

import java.util.List;

/**
 * Objet permettant de transferer les informations entre le client et le serveur
 *
 */
public class ObjetTransfert {
	
	/**
	 * ID de la partie du joueur
	 */
	private int idPartie;
	
	/**
	 * ID du joueur
	 */
	private int idJoueur;
	private List<String> actions;
	
	public List<String> getActions() {
		return actions;
	}

	public void setActions(List<String> actions) {
		this.actions = actions;
	}

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
