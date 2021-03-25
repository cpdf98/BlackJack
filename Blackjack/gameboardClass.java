import java.util.ArrayList;
class gameboardClass{
	static void gameBoard(ArrayList<String> dealerHand, ArrayList<String> playerHand, boolean dealerTurn){ //this displays the game for the player
		System.out.println("-------------------------------------------\n");
		System.out.println("Dealer's hand: \n");
		dDealer(dealerHand, dealerTurn);
		System.out.println("\n\nPlayer's hand: \n");
		hand(playerHand);
		System.out.println("\n\n");
		System.out.println("-------------------------------------------\n");
	}
	static void hand(ArrayList<String> hand){
		for(int i = 0; i < hand.size(); i++){
			buildCard(hand.get(i));
		}
		System.out.println("");
	}
	static void dDealer(ArrayList<String> dealerHand, boolean dealerTurn){//this will filter how the dealer's hand is displayed
		if(!dealerTurn){ //if it is still the player's turn, then the first card in the dealer's hand is hidden
			buildCard(" ");
			buildCard(dealerHand.get(1));
		}else if(dealerTurn){//if it is the dealer's turn, the dealer's hand is on full display
			hand(dealerHand);
		}
	}
	static void buildCard(String index){ //add brackets around the card value and suit to give it a card shape
		String card = "[" + index + "]";
		System.out.print(card);
	}
}
