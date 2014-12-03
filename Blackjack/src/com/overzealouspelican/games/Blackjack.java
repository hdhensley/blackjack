package com.overzealouspelican.games;

import java.util.Collections;

import com.overzealouspelican.interfaces.IGame;
import com.overzealouspelican.resources.Card;
import com.overzealouspelican.resources.Deck;
import com.overzealouspelican.resources.Game;
import com.overzealouspelican.resources.Hand;
import com.overzealouspelican.resources.Player;
import com.overzealouspelican.resources.Deck.OutOfCardsException;

public class Blackjack extends Game implements IGame{

	Player house = new Player("House",new Hand());
	
	private int hitUnder = 12;
	private int lowCardCount = 5;
	
	public static void main(String[] args) {
		new Blackjack();
	}
	
	public Blackjack(){					
		
		String[] playerNames = {"Player0","Player1","Player2","Player3"};
		
		for(String p : playerNames ){
			players.add(new Player(p,new Hand()));
		}
		
		for( int i = 0; i < numberOfGames; i++ ){
			play();
		}
		
		printSummary();
	}
	
	public void play(){
		try{
			if( d.size() <= lowCardCount ){
				d = new Deck();
			}
			
			Collections.shuffle(d);
			
			house.getHand().reset();			
			house.addCard(d.deal());
			Card secondHouseCard = d.deal();
			secondHouseCard.setVisible(false);
			house.addCard(secondHouseCard);
			
			for(Player p : players ){
				p.getHand().reset();
				p.addCard(d.deal());
				p.addCard(d.deal());
			}
			
			while(house.getHand().getValue() < hitUnder ){
				house.addCard(d.deal());
			}
			
			for(Player p : players ){
				while( p.getHand().getValue() < hitUnder ){
					p.addCard(d.deal());
				}
			}
			
			printResult();
		} catch( OutOfCardsException e ){
			d = new Deck();
			System.out.println("Out of cards, adding new deck.");
			System.out.println("-----------------------------");
			numberOfGames++;
		}
	}
	
	public void printResult(){
		int houseValue = house.getHand().getValue();
		
		for( Player p : players ){
			int playerValue = p.getHand().getValue();
			System.out.println("House Value : " + houseValue + "(" + house.getHand().toString() + ")");
			System.out.println(p.getName() + " Value : " + playerValue + " (" + p.getHand().toString() + ")");
			
			if( playerValue < houseValue && ! house.getHand().isBusted() ){
				System.out.println(p.getName() + " loses.");
				p.addLoss();
			} else if( playerValue == houseValue && ! house.getHand().isBusted() ){
				System.out.println(p.getName() + " pushed.");
				p.addPush();
			} else {
				System.out.println(p.getName() + " wins!");
				p.addWin();
			}
			System.out.println("-----------------------------");
		}
	}
	
	public void printSummary(){
		for(Player p : players){
			System.out.println(p.getName() + " ~\n" +
							   "  Wins : " + p.getWins() + "\n" +
							   "  Losses : " + p.getLoses() + "\n" +
							   "  Pushes : " + p.getPushes() + "\n" +
							   "  Win % : " + ( ( (float) p.getWins() + p.getPushes() ) / p.getGameCount())*100);
		}
	}

}
