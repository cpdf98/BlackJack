import java.util.Scanner;
import java.util.ArrayList;
class play{
	static String[][] game(String[][] startingData){
		boolean dealerTurn = true;//If true, it will display the dealer's hidden card. If false, it will hide it
		Scanner input = new Scanner(System.in);
		ArrayList<String> preShuffleDeck = arrayConvert.getDeck(startingData, 0);
		ArrayList<String> deadDeck = arrayConvert.getDeck(startingData, 1);
		ArrayList<String> deck = shuffleClass.shuffleDeck(preShuffleDeck);
		ArrayList<String> playerHand = new ArrayList<String>();
		ArrayList<String> dealerHand = new ArrayList<String>();
		playerHand = draw(playerHand, deck, deadDeck);
		playerHand = draw(playerHand, deck, deadDeck);
		dealerHand = draw(dealerHand, deck, deadDeck);
		dealerHand = draw(dealerHand, deck, deadDeck);
		boolean playerhandStatus = instantWin(playerHand);
		boolean dealerhandStatus = instantWin(dealerHand);
		if(playerhandStatus && dealerhandStatus){ 
			board(dealerHand, playerHand, dealerTurn);
			System.out.println("\nYou two have both drawn blackjack. Push? [y]\n");//If both the player and dealer have drawn a blackjack
			input.nextLine();
		}else if(playerhandStatus && !dealerhandStatus){//if the player draws a blackjack
			board(dealerHand, playerHand, dealerTurn);
			System.out.println("\nYou have drawn a blackjack. You win!");
		}else if(!playerhandStatus && dealerhandStatus){//If the dealer draws a blackjack
			board(dealerHand, playerHand, dealerTurn);
			System.out.println("The dealer has drawn a blackjack. You lose!");
		}else{//Executes if there is no blackjack on draw
			dealerTurn = false;
			board(dealerHand, playerHand, dealerTurn);
			int playerValue = playerTurn(dealerHand, playerHand, dealerTurn, deck, deadDeck);//Executes the player's turn. Returns the value of the cards in the player's hand
			dealerTurn = true;
			board(dealerHand, playerHand, dealerTurn);
			if(playerValue > 21){//If the player's hand is worth more than 21
				System.out.println("Bust!! You Lose!");
			}else{
				String[][] allDecks = arrayConvert.prepare(deck, deadDeck, dealerHand, playerHand);//Sends all cards to the arrayConvert class to be combined in a 2d array
				dealerClass.dealerTurn(allDecks);//Sends the cards to the dealerCLass
			}
		}
		deadDeck = shuffleClass.emptyHand(playerHand, dealerHand, deadDeck);
		String[][] decks = arrayConvert.combineDecks(deck, deadDeck);
		return decks;
	}
	static int playerTurn(ArrayList<String> dealerHand, ArrayList<String> playerHand, boolean dealerTurn, ArrayList<String> deck, ArrayList<String> deadDeck){//will prompt the user during their turn
		Scanner input = new Scanner(System.in);
		boolean bust = false;
		int value = 0;
		while(true){//Will keep going if the bust boolean is false
			board(dealerHand, playerHand, dealerTurn);
			System.out.println("[H] : Hit	    [S] : Stand");
			String select = input.nextLine();
			if(select.equals("H") || select.equals("h")){
				draw(playerHand, deck, deadDeck);
				board(dealerHand, playerHand, dealerTurn);
				value = valueClass.cardTotal(playerHand);
				if(value > 21){ //Breaks the loop if the value has gone over 21
					bust = true;
					break;
				}
			}else if(select.equals("S") || select.equals("s")){//Breaks the loop if the player inserts an s
				break;
			}else{
				continue;
			}
		}
		return value;
	}
	static ArrayList<String> draw(ArrayList<String> hand, ArrayList<String> deck, ArrayList<String> deadDeck){//will draw a card from the deck
		if(deck.size() == 0){
			deck = shuffleClass.reFill(deck, deadDeck);
			deadDeck.clear();
		}
		hand.add(deck.get(0));
		deck.remove(0);
		return hand;
	}
	static void board(ArrayList<String> dealerHand, ArrayList<String> playerHand, boolean dealerTurn){ //sends the two hands to the game board to be displayed
		clearClass.clear();
		gameboardClass.gameBoard(dealerHand, playerHand, dealerTurn);
	}
	static boolean instantWin(ArrayList<String> hand){ //checks to see if either the player or the dealer have a blackjack on draw
		boolean win = false;
		String x = hand.get(0);
		String y = hand.get(1);
		x = x.substring(0, x.length() - 1);
		y = y.substring(0, y.length() - 1);
		if(x.equals("A") && !y.equals("A")){
			if(y.equals("10") || y.equals("J") || y.equals("Q") || y.equals("K")){
				win = true;
			}
		}else if(!x.equals("A") && y.equals("A")){
			if(x.equals("10") || x.equals("J") || x.equals("Q") || x.equals("K")){
				win = true;
			}
		}
		return win;
	}
}
