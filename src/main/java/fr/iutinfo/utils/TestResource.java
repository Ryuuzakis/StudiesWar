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
		return "<html> " +
				"<head><h1> Studies War</h1></head> " +
				"<body>" +
				"<form action=\"/ma-page-de-traitement\" method=\"post\">" +
				"<div>" +
				"<label for=\"nom\">Nom :</label>" +
				"<input type=\"text\" id=\"nom\" />" +
				"</div>" +
				"<div>" +
				"<label for=\"courriel\">Courriel :</label>" +
				"<input type=\"email\" id=\"courriel\" />" +
				"</div>" +
				"<div>" +
				"<label for=\"message\">Message :</label>" +
				"<textarea id=\"message\"></textarea>" +
				"</div>" +
				"<div class=\"button\">" +
				"<button type=\"submit\">Envoyer votre message</button>" +
				"</div>" +
				"</form>" +
				"</body></html>";
	}
}
