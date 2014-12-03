package com.overzealouspelican.resources;

import java.util.ArrayList;


public class Hand extends ArrayList<Card> {
	
	private static final long serialVersionUID = 1L;
	private int value = 0;
	private boolean busted = false;

	public Hand(){
		
	}
	
	public String toString(){
		String cards = "";
		for(Card c : this){
			cards += c.toString() + ",";
		}
		return cards.substring(0, cards.length() - 1);
	}
	
	public void reset(){
		clear();
		setValue(0);
	}
	
	public boolean isBusted(){
		return busted;
	}
	
	public void addCard(Card c){
		//If an Ace is being added and would bust the player with a value of 11, set the value to 1
		if( c.getRank().equals("A") && getValue() + 11 > 21 ){
			c.setValue(1);
		}
		
		setValue(getValue() + c.getValue());
		this.add(c);
	}
	
	public int getValue(){
		return value;
	}
	
	private void setValue(int value){
		if( value > 21 ){
			busted = true;
		}
		this.value = value;
	}
}
