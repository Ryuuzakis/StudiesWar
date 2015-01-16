package fr.iutinfo;

import static org.junit.Assert.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import fr.iutinfo.studiesWar.App;
import fr.iutinfo.studiesWar.models.Partie;
import fr.iutinfo.studiesWar.resources.ObjetTransfert;
import fr.iutinfo.studiesWar.resources.PartieRessource;
import fr.iutinfo.studiesWar.resources.TableauTransfert;


public class TestPartieRest extends JerseyTest {

	@Override
	protected Application configure() {
		return new App();
	}

	@Test 
	public void testCreerPartie() {
		String name = "Clavier";
		ObjetTransfert obj = target("/partie/"+name+"/creer").request().get(ObjetTransfert.class);

		assertTrue(obj != null);
		assertTrue(PartieRessource.parties.containsKey(obj.getIdPartie()));
		assertTrue(PartieRessource.joueurs.containsKey(obj.getIdJoueur()));
	}

	@Test
	public void testLancerPartie() {
		String name = "Clavier";
		for(int i = 0; i < 30; i++) {
			ObjetTransfert obj = target("/partie/"+name+"/creer").request().get(ObjetTransfert.class);
	
			target("partie/" + obj.getIdPartie() + "/lancer").request().get();
			Partie p = PartieRessource.parties.get(obj.getIdPartie());
			assertTrue(p.getNumTour() > 0);
			assertEquals(Partie.nbControles, p.getSemaineActuelle().size());
			assertEquals(Partie.NB_JOUEURS, p.getPersonnes().size());
		}
	}

	@Test
	public void testObtenirControles() {
		String name = "Clavier";
		for (int i = 0; i < 30; i++) {
			ObjetTransfert obj = target("/partie/"+name+"/creer").request().get(ObjetTransfert.class);
			//Lancer la partie
			target("partie/" + obj.getIdPartie() + "/lancer").request().get();

			ObjetTransfert obj2 = target("/partie/" + obj.getIdPartie() + "/controles").request().get(ObjetTransfert.class);

			assertTrue(obj2.getControles() != null);
			assertEquals(5, obj2.getControles().size());
			int idxEchec = 5 - Partie.nbControles;
			for (int j = 0; j < obj2.getControles().size(); j++) {
				String ch = obj2.getControles().get(j);
				if (ch.equals("pas de contrôle")) {
					idxEchec--;
				}
				assertTrue(idxEchec >= 0);
			}
		}
	}
	@Test 
	public void testObtenirActions() {
		for (int j = 0; j < 30; j++) {

			String name = "Clavier";
			//Creation de la partie
			ObjetTransfert obj = target("/partie/"+name+"/creer").request().get(ObjetTransfert.class);

			//Lancer la partie
			target("partie/" + obj.getIdPartie() + "/lancer").request().get();
			//Génération des contrôles
			target("/partie/" + obj.getIdPartie() + "/controles").request().get(ObjetTransfert.class);

			int idxDoNothing = 5 - Partie.nbControles;
			for (int i = 1; i <= 5; i++) {
				//Obtention des actions pour un jour donné
				ObjetTransfert obj3 = target("/partie/"+obj.getIdPartie()+"/joueur/"+obj.getIdJoueur()
						+"/jour/" + i).request().get(ObjetTransfert.class);

				assertTrue(obj3 != null);
				assertTrue(obj3.getActions().size() > 0);
				if (obj3.getActions().get(0).equals("ne rien faire"))
					idxDoNothing--;
				assertNotEquals(-1, idxDoNothing);
			}
		}
	}

	@Test
	public void testObtenirCaracs() {
		String name = "Clavier";
		ObjetTransfert obj = target("/partie/"+name+"/creer").request().get(ObjetTransfert.class);

		ObjetTransfert obj2 = target("/partie/" + obj.getIdJoueur() + "/caracteristiques").request().get(ObjetTransfert.class);

		assertTrue(obj2 != null);
		assertTrue(obj2.getCaracs().size() > 0);
	}

	@Test
	public void testValiderAction() {
		String name = "Clavier";
		//Creation de la partie
		for (int i = 0; i < 30; i++) {
			ObjetTransfert obj = target("/partie/"+name+"/creer").request().get(ObjetTransfert.class);

			//Lancer la partie
			target("partie/" + obj.getIdPartie() + "/lancer").request().get();
			//Génération des contrôles
			target("/partie/" + obj.getIdPartie() + "/controles").request().get(ObjetTransfert.class);

			target("/partie/"+obj.getIdPartie()+"/joueur/"+obj.getIdJoueur()
					+"/jour/" + 1).request().get(ObjetTransfert.class);


			TableauTransfert tab = new TableauTransfert();
			tab.setActions(new int[] {0, 0, 0, 0, 0});
			Entity<TableauTransfert> entity = Entity.entity(tab, MediaType.APPLICATION_JSON);
			target("/partie/" + obj.getIdPartie() + "/joueur/" + obj.getIdJoueur() + "/sendaction").request().post(entity);
			
			//TODO : Faire un test sympa
		}
	}
	@Test
	public void testObtenirResultats() {
		String name = "Clavier";
		ObjetTransfert obj = target("/partie/"+name+"/creer").request().get(ObjetTransfert.class);

		//Lancer la partie
		target("partie/" + obj.getIdPartie() + "/lancer").request().get();
		//Génération des contrôles
		target("/partie/" + obj.getIdPartie() + "/controles").request().get(ObjetTransfert.class);

		//Obtenir les actions
		target("/partie/"+obj.getIdPartie()+"/joueur/"+obj.getIdJoueur()
				+"/jour/" + 1).request().get(ObjetTransfert.class);
		//Valider les actions
		TableauTransfert tab = new TableauTransfert();
		tab.setActions(new int[] {0, 0, 0, 0, 0});
		Entity<TableauTransfert> entity = Entity.entity(tab, MediaType.APPLICATION_JSON);
		target("/partie/" + obj.getIdPartie() + "/joueur/" + obj.getIdJoueur() + "/sendaction").request().post(entity);
		
		//Obtenir les resultats
		ObjetTransfert obj2 = target("/partie/" + obj.getIdPartie() + "/resultats").request().get(ObjetTransfert.class);
		System.out.println(obj2.getResultats());
		
	}


}
