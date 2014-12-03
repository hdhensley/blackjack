package com.overzealouspelican;

import java.util.ArrayList;

public class Deck extends ArrayList<Card> {
	
	private static final long serialVersionUID = 1L;

	public Deck(){
		String[] ranks = {"1","2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		String[] suits = {"Diamonds","Clubs","Spades","Hearts"};
		
		for(String s : suits){
			int i=1;
			for(String r : ranks){
				if( i > 10){
					i = 10;
				}
				if( r.equalsIgnoreCase("A") ){
					i = 11;
				}
				this.add(new Card(s,r,i));
				i++;
			}
		}
	}
	
	public Card deal() throws OutOfCardsException{
		if( this.size() > 0 ){
			return this.remove(0);
		}
		
		throw new OutOfCardsException();
	}
	
	public class OutOfCardsException extends Exception {
		private static final long serialVersionUID = 1L;

		public OutOfCardsException(){
			super("Out of cards.");
		}
	}
}
