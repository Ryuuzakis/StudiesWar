package fr.iutinfo.studiesWar.models;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import fr.iutinfo.studiesWar.resources.PartieRessource;
import fr.iutinfo.studiesWar.resources.TestResource;
import fr.iutinfo.studiesWar.resources.UserResource;

@ApplicationPath("/v1/")
public class App extends Application{
    @Override
    public Set<Class<?>> getClasses() {
    	
    	System.setProperty("jersey.config.server.tracing", "ALL");
    	
    	Set<Class<?>> s = new HashSet<Class<?>>();
    	s.add(UserResource.class);
    	s.add(TestResource.class);
    	s.add(PartieRessource.class);
    	return s;
    }
}
