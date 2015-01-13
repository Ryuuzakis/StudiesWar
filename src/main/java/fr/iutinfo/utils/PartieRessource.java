package fr.iutinfo.utils;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/partie")
public class PartieRessource {
	
	private Partie partie;
	
	@GET
	@Path("{name}")
	public void creerPartie(@PathParam("name") String name ) {
		System.out.println("creation de la partie pour "+name);
		
		partie = (Partie) Factory.getResource(Factory.PARTIE);
		PersonnageJoueur p = new PersonnageJoueur();
		p.setNom(name);
		partie.rejoinPartie(p);
		partie.DebutDuTour();
	}
	

}
