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
	    Entity<String> userEntity = Entity.entity(name, MediaType.TEXT_HTML);
		ObjetTransfert obj = target("/partie/"+name+"/creer").request().get(ObjetTransfert.class);
		
		assertTrue(obj != null);
	}
	
	@Test 
	public void testObtenirActions() {
		String name = "Clavier";
	    Entity<String> userEntity = Entity.entity(name, MediaType.TEXT_HTML);
		ObjetTransfert obj = target("/partie/"+name+"/creer").request().get(ObjetTransfert.class);
		System.out.println(obj.getIdPartie());
		System.out.println(obj.getIdJoueur());

		ObjetTransfert actions = target("/partie/"+obj.getIdPartie()+"/joueur/"+obj.getIdJoueur()).request().get(ObjetTransfert.class);
		//String json = target("/partie/"+obj.getIdPartie()+"/joueur/"+obj.getIdJoueur()).request().get(String.class);;
		//assertEquals("",json);
		
		assertTrue(actions != null);
		assertTrue(actions.getActions().size() > 0);
		
	}
	

}
