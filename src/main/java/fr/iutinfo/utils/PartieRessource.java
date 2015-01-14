package fr.iutinfo.utils;


import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/partie")
public class PartieRessource {
	
	private Partie partie;
	PersonnageJoueur pj;
	
	@GET
	@Path("{name}")
	public void creerPartie(@PathParam("name") String name ) {
		System.out.println("creation de la partie pour "+name);
		
		partie = (Partie) Factory.getResource(Factory.PARTIE);
		pj = new PersonnageJoueur();
		pj.setNom(name);
		partie.rejoinPartie(pj);
	}
	
	public ArrayList<String> choisirActions() {
		return null;
	}
	
	

}
