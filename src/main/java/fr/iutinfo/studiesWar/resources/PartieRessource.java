package fr.iutinfo.studiesWar.resources;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.iutinfo.studiesWar.models.Controle;
import fr.iutinfo.studiesWar.models.Factory;
import fr.iutinfo.studiesWar.models.Partie;
import fr.iutinfo.studiesWar.models.PersonnageJoueur;
import fr.iutinfo.studiesWar.models.action.Action;

@Path("/partie")
public class PartieRessource {
	
	private static HashMap<Integer, Partie> parties= new HashMap<Integer, Partie>();
	private static HashMap<Integer, PersonnageJoueur> joueurs = new HashMap<Integer, PersonnageJoueur>();
	
	@GET
	@Path("{name}/creer")
	@Produces(MediaType.APPLICATION_JSON)
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
	@Path("/{idPartie}/joueur/{idJoueur}")
	@Produces(MediaType.APPLICATION_JSON)
	public ObjetTransfert obtenirActions(
			@PathParam("idPartie") int idPartie,
			@PathParam("idJoueur") int idJoueur) {
		System.out.println("obtenir actions");
		PersonnageJoueur pj = joueurs.get(idJoueur);
		Partie p = parties.get(idPartie);
		ArrayList<String> actionsString = new ArrayList<String>();
		ArrayList<Action> actions = p.getActions(pj);
		for (Action a : actions) {
			actionsString.add(a.toString());
		}
		ObjetTransfert output = new ObjetTransfert();
		output.setActions(actionsString);
		return output;
	}
	
	@GET
	@Path("{idPartie}/controles")
	@Produces(MediaType.APPLICATION_JSON)
	public ObjetTransfert obtenirControles(@PathParam("idPartie") int idPartie) {
		Partie p = parties.get(idPartie);
		ArrayList<String> controles = new ArrayList<String>();
		for(Controle c : p.getSemaineActuel().values()) {
			controles.add(c.getMatiere().toString());
		}
		ObjetTransfert obj = new ObjetTransfert();
		obj.setControles(controles);
		return obj;
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
	public ObjetTransfert obtenirResultats(@PathParam("idPartie") int idPartie) {
		Partie p = parties.get(idPartie);
		ObjetTransfert obj = new ObjetTransfert();
		obj.setResultats(p.getResultats());
		return obj;
	}

}
