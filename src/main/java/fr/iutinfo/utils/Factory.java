package fr.iutinfo.utils;

public class Factory {
	
	public static final byte PARTIE = 0;
	private static Partie partie = null;
	
	public static Object getResource(byte resource) {
		if(resource == PARTIE) {
			if (partie == null)
				partie = new Partie(10,0);
			return partie;
		} else {
			return null;
		}
	}
}
