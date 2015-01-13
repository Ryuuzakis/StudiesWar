package fr.iutinfo.utils;

public abstract class Effet {
	
	private byte dDebut ;
	private byte dFin ;
	
	public Effet(byte dD,byte dF){
		this.dDebut = dD;
		this.dFin = dF;
	}
	
	public abstract void appliqueEffet();
	
	
	

}
