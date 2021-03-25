class deckClass{
	static String[] buildDeck(){
		String[] cardValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; //The card numbers and faces
		String[] suits = {"\u2660", "\u2666", "\u2663", "\u2665"};//Each element of this array displays the 4 card suits
		String[] spades = spadeDiamonds(cardValues, suits[0]);//creates the spade cards
		String[] diamonds = spadeDiamonds(cardValues, suits[1]);//creates the diamond cards
		String[] clubs = clubsHearts(cardValues, suits[2]);//creates the club cards
		String[] hearts = clubsHearts(cardValues, suits[3]);//creates the heart cards
		String[] firstHalf = merge(spades, diamonds);//Combines the spades and diamonds
		String[] secondHalf = merge(clubs, hearts);//combines the clubs and hearts
		String[] fullDeck = merge(firstHalf, secondHalf);//Creates a deck in new deck order
		String[] repeat = merge(fullDeck, fullDeck);//will add another deck, meaning that repeat will be 2 full decks
		for(int i = 0; i < 2; i++){//This will add 4 decks
			fullDeck = merge(fullDeck, fullDeck);
		}
		fullDeck = merge(fullDeck, repeat);//when combining fullDeck and repeat, there will be 6 full decks of cards in the game
		return fullDeck;
	}
	static String[] spadeDiamonds(String[] cardValues, String suit){//combines the spades and diamonds
		String[] suitValues = new String[cardValues.length];
		for(int i = 0; i < cardValues.length; i++){
			suitValues[i] = cardValues[i] + suit;
		}
		return suitValues;
	}
	static String[] clubsHearts(String[] cardValues, String suit){//combines the clubs and hearts
		String[] suitValues = new String[cardValues.length];
		for(int i = cardValues.length - 1, j = 0; i >= 0; i--, j++){
			suitValues[j] = cardValues[i] + suit;
		}
		return suitValues;
	}
	static String[] merge(String[] first, String[] second){//merges two sets of arrays into one
		String[] combined = new String[first.length + second.length];
		for(int i = 0; i < first.length; i++){
			combined[i] = first[i];
		}
		for(int i = first.length, j = 0; i < combined.length; i++, j++){
			combined[i] = second[j];
		}
		return combined;
	}
}
