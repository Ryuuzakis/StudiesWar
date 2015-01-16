package fr.iutinfo.studiesWar.resources;

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
	private List<String> resultats;
	private List<String> controles;
	private List<String> caracs;
	private boolean elimine;
	
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

	public List<String> getResultats() {
		return resultats;
	}

	public void setResultats(List<String> resultats) {
		this.resultats = resultats;
	}

	public List<String> getControles() {
		return controles;
	}

	public void setControles(List<String> controles) {
		this.controles = controles;
	}

	public List<String> getCaracs() {
		return caracs;
	}

	public void setCaracs(List<String> caracs) {
		this.caracs = caracs;
	}

	public boolean isElimine() {
		return elimine;
	}

	public void setElimine(boolean elimine) {
		this.elimine = elimine;
	}
	
}
