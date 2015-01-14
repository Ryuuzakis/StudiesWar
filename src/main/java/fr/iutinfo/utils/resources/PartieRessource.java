package fr.iutinfo.utils.resources;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.iutinfo.utils.Factory;
import fr.iutinfo.utils.Partie;
import fr.iutinfo.utils.PersonnageJoueur;

@Path("/partie")
public class PartieRessource {
	
	private HashMap<Integer, Partie> parties= new HashMap<Integer, Partie>();
	private HashMap<Integer, PersonnageJoueur> joueurs = new HashMap<Integer, PersonnageJoueur>();
	
	@GET
	@Path("{name}")
	public void creerPartie(@PathParam("name") String name ) {
		System.out.println("creation de la partie pour "+name);
		int idPartie = parties.size();
		parties.put(idPartie, (Partie) Factory.getResource(Factory.PARTIE, idPartie));
		int idJoueur = joueurs.size();
		PersonnageJoueur pj = new PersonnageJoueur();
		pj.setNom(name);
		parties.get(idPartie).rejoinPartie(pj);
	}
	
	
	public ArrayList<String> obtenirActions() {
		
		return null;
	}
	
	

}
