package com.overzealouspelican;


public class Player {

	private String name;
	private Hand hand;
	private int wins = 0;
	private int loses = 0;
	private int pushes = 0;
	
	public Player(String name, Hand hand){
		setName(name);
		setHand(hand);
	}
	
	public void addPush(){
		pushes++;
	}
	
	public int getPushes(){
		return pushes;
	}
	
	public void addWin(){
		wins++;
	}
	
	public int getWins(){
		return wins;
	}
	
	public void addLoss(){
		loses++;
	}	
	
	public int getLoses(){
		return loses;
	}
	
	public int getGameCount(){
		return wins + loses + pushes;
	}
	
	public void addCard(Card c){
		getHand().addCard(c);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
}
