package fr.iutinfo.utils;


import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/partie")
public class PartieRessource {
	
	private Partie partie;
	
	@POST
	public void creerPartie(String nom) {
		partie = (Partie) Factory.getResource(Factory.PARTIE);
		Personnage p = new PersonnageJoueur();
		p.setNom(nom);
		partie.DebutDuTour();
		System.out.println(p.getNom());
	}
	

}
