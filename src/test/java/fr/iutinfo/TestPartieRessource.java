package fr.iutinfo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import fr.iutinfo.studiesWar.App;
import fr.iutinfo.studiesWar.models.Factory;
import fr.iutinfo.studiesWar.models.Personnage;
<<<<<<< HEAD
=======
import fr.iutinfo.studiesWar.models.action.Action;
import fr.iutinfo.studiesWar.resources.ObjetTransfert;
>>>>>>> b39aa939f3118cd02cba4cd51aca7fad50de56e6
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
		ObjetTransfert obj = pr.obtenirResultats(0);
		List<String> resultats = obj.getResultats();
		
		assertTrue(resultats.size() > 0 );
		
		//TODO : Tester
	}
	

}
