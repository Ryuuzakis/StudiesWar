package fr.iutinfo.utils;

import java.util.Random;

public class Tricher extends Action{
	byte eff ;
	Personnage c;
	
	public Tricher(Personnage p,Personnage c){
		super(p);
		Random r = new Random();
		this.eff = (byte) r.nextInt(4);
		this.c = c;
	}

	@Override
	public void agit() {
		p.addEffect(new CopieNote((byte)1,(byte)2,this.c));
	}
	

}

