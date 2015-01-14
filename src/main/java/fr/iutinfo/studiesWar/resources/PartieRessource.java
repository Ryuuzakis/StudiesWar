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
	
	@GET
	@Path("{name}")
	public ObjetTransfert creerPartie(@PathParam("name") String name ) {
		int idPartie = parties.size();
		parties.put(idPartie, (Partie) Factory.getResource(Factory.PARTIE, idPartie));
		int idJoueur = joueurs.size();
		PersonnageJoueur pj = new PersonnageJoueur();
		pj.setNom(name);
		parties.get(idPartie).rejoinPartie(pj);
		parties.get(idPartie).DebutDuTour();
		return new ObjetTransfert(idPartie, idJoueur);
	}
	
	@GET
	@Path("{obj}")
	public ArrayList<String> obtenirActions(@PathParam("obj") ObjetTransfert obj) {
		PersonnageJoueur pj = joueurs.get(obj.getIdJoueur());
		Partie p = parties.get(obj.getIdPartie());
		ArrayList<String> actionsString = new ArrayList<String>();
		ArrayList<Action> actions = p.getActions(pj);
		
		for (Action a : actions) {
			actionsString.add(a.toString());
		}
		return actionsString;
	}
	
	@POST
	@Path("{obj}/{action}")
	public void validerAction(@PathParam("action") String action, @PathParam("obj") ObjetTransfert obj) {
		PersonnageJoueur pj = joueurs.get(obj.getIdJoueur());
		Partie p = parties.get(obj.getIdPartie());
		
		ArrayList<Action> actions = p.getActions(pj);
		for (Action a : actions) {
			if (action.equals(a.toString())) {
				a.agit();
				break;
			}
		}
		
		parties.get(obj.getIdPartie()).finDuTour();
	}
	
	@GET
	@Path("{obj}")
	public ArrayList<String> obtenirResultats(@PathParam("obj") ObjetTransfert obj) {
		PersonnageJoueur pj = joueurs.get(obj.getIdJoueur());
		Partie p = parties.get(obj.getIdPartie());
		
		return p.getResultats();
	}

}
