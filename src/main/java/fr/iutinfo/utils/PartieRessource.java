package fr.iutinfo.utils;


import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/partie")
public class PartieRessource {
	
	private Partie partie;
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/{name}")
	public String creerPartie(@PathParam("name") String nom) {
		System.out.println("creation de la partie");
		partie = (Partie) Factory.getResource(Factory.PARTIE);
		Personnage p = new PersonnageJoueur();
		p.setNom(nom);
		partie.DebutDuTour();
		System.out.println(p.getNom());
		return "<html>Réussi !</html>";
	}
	

}
