package fr.iutinfo.studiesWar.models.effet;

import fr.iutinfo.studiesWar.models.Controle;
import fr.iutinfo.studiesWar.models.Note;

/**
 * Une action prioritaire annule les autres effets
 * @author cuvillic
 *
 */
public abstract class Effet {
	
	protected int dDebut ;
	protected int dFin ;
	protected int priorite;
	
	public Effet(int dD, int dF, int pri){
		this.dDebut = dD;
		this.dFin = dF;
		this.priorite = pri;
	}
	
	public boolean estActif(Controle c){
		
		return dDebut <= c.getDate() && dFin > c.getDate();
	}
	
	public int getPriorite() {
		return priorite;
	}

	public abstract void modifNote(Note n);

}
