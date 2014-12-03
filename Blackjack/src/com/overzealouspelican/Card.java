package com.overzealouspelican;

public class Card {
	private String suit;
	private String rank;
	private int value;
	private boolean visible = true;
	
	public Card(String suit,String rank, int value){
		setSuit(suit);
		setRank(rank);
		setValue(value);
	}
	
	public void setVisible(boolean b){
		visible = b;
	}
	
	public boolean isVisible(){
		return visible;
	}
	
	public String toString(){
		return getRank() + " of " + getSuit();
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
