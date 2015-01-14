package fr.iutinfo;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;

import fr.iutinfo.studiesWar.App;

public class TestPartieRessource extends JerseyTest {
	
	@Override
    protected Application configure() {
        return new App();
    }
	
	

}
