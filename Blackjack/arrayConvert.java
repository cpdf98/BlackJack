import java.util.ArrayList;
class arrayConvert{
	static String[] convertToArray(ArrayList<String> x){
		String[] converted = new String[x.size()];//converts arraylist to array
		for(int i = 0; i < x.size(); i++){
			converted[i] = x.get(i);
		}
		return converted;
	}
	static ArrayList<String> toAL(String[] array){//converts array to arraylist
		ArrayList<String> cards = new ArrayList<String>();
		for(int i = 0; i < array.length; i++){
			cards.add(array[i]);
		}
		return cards;
	}
	static String[][] prepare(ArrayList<String> deck, ArrayList<String> deadDeck, ArrayList<String> dealerHand, ArrayList<String> playerHand){//combines all arrays into a 2d array
		String[][] allCards = new String[4][];
		allCards[0] = convertToArray(deck).clone();
		allCards[1] = convertToArray(deadDeck).clone();
		allCards[2] = convertToArray(dealerHand).clone();
		allCards[3] = convertToArray(playerHand).clone();
		return allCards;
	}
	static String[][] combineDecks(ArrayList<String> deck, ArrayList<String> deadDeck){ //combines the two arraylists into a 2d array
		String[][] decks = new String[2][];
		String[] convertedDeck = convertToArray(deck);
		String[] convertedDeadDeck = convertToArray(deadDeck);
		decks[0] = convertedDeck.clone();
		decks[1] = convertedDeadDeck.clone();
		return decks;
	}
	static ArrayList<String> getDeck(String[][] startingData, int select){//splits the startingData into two arraylists. One for a live deck, and the other for a dead deck
		ArrayList<String> deck = new ArrayList<String>();	
		for(int i = 0; i < startingData[select].length; i++){
			deck.add(startingData[select][i]);
		}
		return deck;
	}
}
