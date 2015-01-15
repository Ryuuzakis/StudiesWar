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
	
	public static HashMap<Integer, Partie> parties= new HashMap<Integer, Partie>();
	public static HashMap<Integer, PersonnageJoueur> joueurs = new HashMap<Integer, PersonnageJoueur>();
	
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
		parties.get(idPartie).rejoindrePartie(pj);
		
		ObjetTransfert obj = new ObjetTransfert();
		obj.setIdPartie(idPartie);
		obj.setIdJoueur(idJoueur);
		return obj;
	}
	
	@GET
	@Path("{idPartie}/lancer")
	public ObjetTransfert lancerPartie(@PathParam("idPartie") int idPartie) {
		Partie p = parties.get(idPartie);
		p.lancerPartie();
		return new ObjetTransfert();
	}
	
	@GET
	@Path("{idPartie}/controles")
	@Produces(MediaType.APPLICATION_JSON)
	public ObjetTransfert obtenirControles(@PathParam("idPartie") int idPartie) {
		Partie p = parties.get(idPartie);
		ArrayList<String> controles = new ArrayList<String>();
		for(int i = 1 ; i <= 5; i++){
			Controle c = p.getSemaineActuelle().get(i);
			if (c != null)
				controles.add(c.getMatiere());
			else
				controles.add("pas de contrôle");
		}
		ObjetTransfert obj = new ObjetTransfert();
		obj.setControles(controles);
		return obj;
	}
	@GET
	@Path("/{idPartie}/joueur/{idJoueur}/jour/{idJour}")
	@Produces(MediaType.APPLICATION_JSON)
	public ObjetTransfert obtenirActions(
			@PathParam("idPartie") int idPartie,
			@PathParam("idJoueur") int idJoueur,
			@PathParam("idJour") int idJour) {
		
		PersonnageJoueur pj = joueurs.get(idJoueur);
		Partie p = parties.get(idPartie);
		ArrayList<String> actionsString = new ArrayList<String>();
		Controle controleDuJour = p.getSemaineActuelle().get(idJour);
		
		ArrayList<Action> actions = p.getActions(controleDuJour, pj);
		for (Action a : actions) {
			actionsString.add(a.toString());
		}
		ObjetTransfert output = new ObjetTransfert();
		output.setActions(actionsString);
		System.out.println(actionsString);
		return output;
	}
	
	@GET
	@Path("/{idJoueur}/caracteristiques")
	@Produces(MediaType.APPLICATION_JSON)
	public ObjetTransfert obtenirCaracs(@PathParam("idJoueur") int idJoueur) {
		PersonnageJoueur pj = joueurs.get(idJoueur);
		ObjetTransfert obj = new ObjetTransfert();
		obj.setCaracs(pj.getStats());
		
		return obj;
	}
	
	
	@POST
	@Path("/{idPartie}/joueur/{idJoueur}/sendaction/{action}")
	public void validerAction(@PathParam("action") String action, @PathParam("idPartie") int idPartie,
			@PathParam("idJoueur") int idJoueur) {
		PersonnageJoueur pj = joueurs.get(idJoueur);
		Partie p = parties.get(idPartie);
		ArrayList<Action> actions = p.getActionsPossibles(pj);
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
