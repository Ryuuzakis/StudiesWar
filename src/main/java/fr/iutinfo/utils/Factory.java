package fr.iutinfo.utils;

import java.util.HashMap;

public class Factory {
	
	public static final byte PARTIE = 0;
	
	private static HashMap<Integer, Partie> parties = new HashMap<Integer, Partie>();
	
	public static Object getResource(byte resource, int id) {
		if(resource == PARTIE) {
			Partie p = parties.get(id);
			if (p == null) {
				p = new Partie(5, id);
				parties.put(id, p);
			}
			return p;
				
		} else {
			return null;
		}
	}
}
