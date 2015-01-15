package fr.iutinfo.studiesWar.models;

import java.util.HashMap;

public class Factory {
	
	public static final byte PARTIE = 0;
	public static final byte JOUEUR = 1;
	
	private static HashMap<Integer, Partie> parties = new HashMap<Integer, Partie>();
	private static HashMap<Integer, Personnage> joueurs = new HashMap<Integer, Personnage>();

	
	public static Object getResource(byte resource, int id) {
		if(resource == PARTIE) {
			Partie p = parties.get(id);
			if (p == null) {
				p = new Partie(id);
				parties.put(id, p);
			}
			return p;
		} else if (resource == JOUEUR) {
			Personnage p = joueurs.get(id);
			if (p == null) {
				p = new PersonnageJoueur();
				joueurs.put(id, p);
			}
			return p;
		}
		return null;
	}
}
