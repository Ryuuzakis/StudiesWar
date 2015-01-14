package fr.iutinfo.studiesWar.resources;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.iutinfo.studiesWar.models.Factory;
import fr.iutinfo.studiesWar.models.ObjetTransfert;
import fr.iutinfo.studiesWar.models.Partie;
import fr.iutinfo.studiesWar.models.PersonnageJoueur;

@Path("/partie")
public class PartieRessource {
	
	private HashMap<Integer, Partie> parties= new HashMap<Integer, Partie>();
	private HashMap<Integer, PersonnageJoueur> joueurs = new HashMap<Integer, PersonnageJoueur>();
	
	@GET
	@Path("{name}")
	public ObjetTransfert creerPartie(@PathParam("name") String name ) {
		System.out.println("creation de la partie pour "+name);
		int idPartie = parties.size();
		parties.put(idPartie, (Partie) Factory.getResource(Factory.PARTIE, idPartie));
		int idJoueur = joueurs.size();
		PersonnageJoueur pj = new PersonnageJoueur();
		pj.setNom(name);
		parties.get(idPartie).rejoinPartie(pj);
		return new ObjetTransfert(idPartie, idJoueur);
	}
	
	
	public ArrayList<String> obtenirActions() {
		
		return null;
	}
	
	

}
