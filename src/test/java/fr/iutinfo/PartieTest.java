package fr.iutinfo;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import fr.iutinfo.studiesWar.App;
import fr.iutinfo.studiesWar.resources.PartieRessource;

public class PartieTest extends JerseyTest {
	@Override
	protected Application configure() {
		return new App();
	}

	@Test
	public void testRest() {
		String json = target("/partie/foo").request().get(String.class);
		assertEquals("", json);
	}
	
}
