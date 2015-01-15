package fr.iutinfo;

import static org.junit.Assert.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import fr.iutinfo.studiesWar.App;
import fr.iutinfo.studiesWar.resources.ObjetTransfert;


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
	}
	
	@Test
	public void testObtenirControles() {
		String name = "Clavier";
		ObjetTransfert obj = target("/partie/"+name+"/creer").request().get(ObjetTransfert.class);
		
		ObjetTransfert obj2 = target("/partie/" + obj.getIdPartie() + "/controles").request().get(ObjetTransfert.class);
		
		assertTrue(obj2.getControles() != null);
		assertTrue(obj2.getControles().size() > 0);
		
	}
	@Test 
	public void testObtenirActions() {
		String name = "Clavier";
		ObjetTransfert obj = target("/partie/"+name+"/creer").request().get(ObjetTransfert.class);
		ObjetTransfert obj2 = target("/partie/" + obj.getIdPartie() + "/controles").request().get(ObjetTransfert.class);

		ObjetTransfert obj3 = target("/partie/"+obj.getIdPartie()+"/joueur/"+obj.getIdJoueur()
				+"/jour/" + 1).request().get(ObjetTransfert.class);
		
		assertTrue(obj3 != null);
		assertTrue(obj3.getActions().size() > 0);
		System.out.println(obj3.getActions());
		
	}
	
	@Test
	public void testObtenirCaracs() {
		String name = "Clavier";
		ObjetTransfert obj = target("/partie/"+name+"/creer").request().get(ObjetTransfert.class);
		
		ObjetTransfert obj2 = target("/partie/" + obj.getIdJoueur() + "/caracteristiques").request().get(ObjetTransfert.class);
		
		assertTrue(obj2 != null);
		assertTrue(obj2.getCaracs().size() > 0);
	}
	

}
