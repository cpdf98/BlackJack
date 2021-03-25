import java.util.ArrayList;
import java.util.Collections;
class shuffleClass{
	static ArrayList<String> shuffleDeck(ArrayList<String> deck){//Shuffles the deck 20 times
		for(int i = 0; i < 20; i++){
			Collections.shuffle(deck);
		}
		return deck;
	}
	static ArrayList<String> reFill(ArrayList<String> deck, ArrayList<String> deadDeck){//Puts all the cards from the dead deck into the deck
		for(int i = 0; i < deadDeck.size(); i++){
			deck.add(deadDeck.get(i));
		}
		deck = shuffleDeck(deck);//calls the shuffle method
		return deck;
	}
	static ArrayList<String> emptyHand(ArrayList<String> playerHand, ArrayList<String> dealerHand, ArrayList<String> deadDeck){//empties all the cards from the player and dealer hands into the dead deck
		for(int i = 0; i < playerHand.size(); i++){
			deadDeck.add(playerHand.get(i));
		}
		for(int i = 0; i < dealerHand.size(); i++){
			deadDeck.add(dealerHand.get(i));
		}
		playerHand.clear();
		dealerHand.clear();
		return deadDeck;
	}
}
