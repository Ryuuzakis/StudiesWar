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
		pr.creerPartie("toto");
		ArrayList<String> actions = pr.obtenirActions(0, 0);
		assertTrue(actions != null);
		assertTrue(actions.size() > 0);
	}
	
	@Test
	public void testValiderAction() {
		pr.creerPartie("toto");
		ArrayList<String> actions = pr.obtenirActions(0, 0);
		pr.validerAction(actions.get(0), 0, 0);
		
		//TODO : faire un test interessant
		
	}
	
	@Test
	public void testObtenirResultats() {
		pr.creerPartie("toto");
		ArrayList<String> actions = pr.obtenirActions(0, 0);
		pr.validerAction(actions.get(0), 0, 0);
		ArrayList<String> resultats = pr.obtenirResultats(0);
		for (String ch : resultats) {
			System.out.println(ch);
		}
		//TODO : verifier l'affichage de obtenirResultats
	}
	

}
