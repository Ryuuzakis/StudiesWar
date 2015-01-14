package fr.iutinfo.studiesWar.resources;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.iutinfo.studiesWar.models.Factory;
import fr.iutinfo.studiesWar.models.ObjetTransfert;
import fr.iutinfo.studiesWar.models.Partie;
import fr.iutinfo.studiesWar.models.PersonnageJoueur;
import fr.iutinfo.studiesWar.models.action.Action;

@Path("/partie")
public class PartieRessource {
	
	private HashMap<Integer, Partie> parties= new HashMap<Integer, Partie>();
	private HashMap<Integer, PersonnageJoueur> joueurs = new HashMap<Integer, PersonnageJoueur>();
	
	@POST
	@Path("{name}")
	public ObjetTransfert creerPartie(@PathParam("name") String name ) {
		int idPartie = parties.size();
		parties.put(idPartie, (Partie) Factory.getResource(Factory.PARTIE, idPartie));
		int idJoueur = joueurs.size();
		PersonnageJoueur pj = (PersonnageJoueur) Factory.getResource(Factory.JOUEUR, idJoueur);
		pj.setNom(name);
		joueurs.put(idJoueur, pj);
		parties.get(idPartie).rejoinPartie(pj);
		parties.get(idPartie).DebutDuTour();
		return new ObjetTransfert(idPartie, idJoueur);
	}
	
	@GET
	@Path("{idPartie}/joueur/{idJoueur}/getaction")
	public ArrayList<String> obtenirActions(@PathParam("idPartie") int idPartie,
			@PathParam("idJoueur") int idJoueur) {
		PersonnageJoueur pj = joueurs.get(idJoueur);
		Partie p = parties.get(idPartie);
		ArrayList<String> actionsString = new ArrayList<String>();
		ArrayList<Action> actions = p.getActions(pj);
		
		for (Action a : actions) {
			actionsString.add(a.toString());
		}
		return actionsString;
	}
	
	@POST
	@Path("/{idPartie}/joueur/{idJoueur}/sendaction/{action}")
	public void validerAction(@PathParam("action") String action, @PathParam("idPartie") int idPartie,
			@PathParam("idJoueur") int idJoueur) {
		PersonnageJoueur pj = joueurs.get(idJoueur);
		Partie p = parties.get(idPartie);
		ArrayList<Action> actions = p.getActions(pj);
		for (Action a : actions) {
			if (action.equals(a.toString())) {
				a.agit();
				break;
			}
		}
		if(parties.get(idPartie).finDuTour()){
			//TODO : Gerer la fin de la partie
		}
		else{
			
		}
	}
	
	@GET
	@Path("{idPartie}/resultats")
	public ArrayList<String> obtenirResultats(@PathParam("idPartie") int idPartie) {
		Partie p = parties.get(idPartie);
		return p.getResultats();
	}

}