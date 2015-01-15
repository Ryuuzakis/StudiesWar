package fr.iutinfo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import fr.iutinfo.studiesWar.App;
import fr.iutinfo.studiesWar.models.Factory;
import fr.iutinfo.studiesWar.models.ObjetTransfert;
import fr.iutinfo.studiesWar.models.Personnage;
import fr.iutinfo.studiesWar.models.action.Action;
import fr.iutinfo.studiesWar.resources.PartieRessource;

public class TestPartieRessource extends JerseyTest {
	
	private PartieRessource pr = new PartieRessource();
	
	@Override
    protected Application configure() {
        return new App();
    }
	
	@Test
	public void testCreationPartie() {
		ObjetTransfert obj = pr.creerPartie("toto");
		assertEquals(0, obj.getIdJoueur());
		assertEquals(0, obj.getIdJoueur());
		Factory.getResource(Factory.PARTIE, 0);
		assertEquals("toto", ((Personnage) Factory.getResource(Factory.JOUEUR, 0)).getNom());
	}
	
	@Test
	public void testObtenirActions() {
		for (int i = 0; i < 100; i++) {
			ObjetTransfert obj = pr.creerPartie("toto" + i);
			ArrayList<String> actions = (ArrayList<String>) pr.obtenirActions(obj.getIdPartie(),
					obj.getIdJoueur()).getActions();
			assertTrue(actions != null);
			assertTrue(actions.size() > 0);
		}
	}
	
	@Test
	public void testValiderAction() {
		ObjetTransfert obj = pr.creerPartie("totoro");
		ArrayList<String> actions = (ArrayList<String>) pr.obtenirActions(obj.getIdPartie(),
				obj.getIdJoueur()).getActions();
		pr.validerAction(actions.get(0), obj.getIdPartie(), obj.getIdJoueur());
		
		//TODO : faire un test interessant
		
	}
	
	@Test
	public void testObtenirResultats() {
		pr.creerPartie("toto");
		ArrayList<String> actions = (ArrayList<String>) pr.obtenirActions(0, 0).getActions();
		pr.validerAction(actions.get(0), 0, 0);
		ArrayList<String> resultats = pr.obtenirResultats(0);
		
		//TODO : Tester
	}
	

}
