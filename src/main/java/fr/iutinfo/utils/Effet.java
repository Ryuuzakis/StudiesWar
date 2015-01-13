package fr.iutinfo.utils;

/**
 * Une action prioritaire annule les autres effets
 * @author cuvillic
 *
 */
public abstract class Effet {
	
	protected byte dDebut ;
	protected byte dFin ;
	protected byte priorite;
	

	
	public Effet(byte dD,byte dF,byte pri){
		this.dDebut = dD;
		this.dFin = dF;
		this.priorite = pri;
	}
	
	public abstract void modifNote(Note n);
	
	

}