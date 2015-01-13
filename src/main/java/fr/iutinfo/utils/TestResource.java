package fr.iutinfo.utils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.TEXT_HTML)
public class TestResource {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHello() {
		return "<html> Hello World ! </html>";
	}
}
