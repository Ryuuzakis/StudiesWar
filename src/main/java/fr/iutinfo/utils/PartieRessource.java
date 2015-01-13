package fr.iutinfo.utils;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/partie")
public class PartieRessource {
	
	private Partie partie;
	
	@GET
	public void creerPartie(String nom) {
		partie = (Partie) Factory.getResource(Factory.PARTIE);
		Personnage p = new PersonnageJoueur();
		p.setNom(nom);
		partie.DebutDuTour();
	}
	

}
