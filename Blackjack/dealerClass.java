import java.util.ArrayList;
class dealerClass{
	static String[][] dealerTurn(String[][] allCards){
		ArrayList<String> deck = arrayConvert.toAL(allCards[0]);
		ArrayList<String> deadDeck = arrayConvert.toAL(allCards[1]);
		ArrayList<String> dealerHand = arrayConvert.toAL(allCards[2]);
		ArrayList<String> playerHand = arrayConvert.toAL(allCards[3]);
		int dealerValue = valueClass.cardTotal(dealerHand);
		int playerValue = valueClass.cardTotal(playerHand);
		while(dealerValue <= 17){//Loop will execute until the value of the dealer's hand is 17 or greater
			pause();//adds a 1 second delay between each execution of the loop
			dealerHand = dealerDraw(dealerHand, deck, deadDeck);//draws a card for the dealer
			board(dealerHand, playerHand, true);//Sends both hands to the game board
			dealerValue = valueClass.cardTotal(dealerHand);//calls the valueClass to get the value of the hand
		}
		if(dealerValue == playerValue){//Will push if the value of the player and dealer hands is the same
			System.out.println("Draw!! must push!");
		}else if(dealerValue > 21){//If the value of the dealerHand is greater than 21, the dealer will bust
			System.out.println("Dealer Bust! You Win!");
		}else if(dealerValue > playerValue && dealerValue <= 21){//If the value of the dealer hand is greater than the player hand and less than or equal to 21
			System.out.println("Dealer Wins!!");
		}else if(dealerValue < playerValue){//The player wins if the player value is greater than the dealer value
			System.out.println("You Win!!");
		}
		String[][] cardM = arrayConvert.prepare(deck, deadDeck, dealerHand, playerHand);//will combine all cards into a 2d array
		return cardM;//returns the 2d array
	}
	static ArrayList<String> dealerDraw(ArrayList<String> dealerHand, ArrayList<String> deck, ArrayList<String> deadDeck){
		if(deck.size() == 0){
			deck = shuffleClass.reFill(deck, deadDeck);
			deadDeck.clear();
		}
		dealerHand.add(deck.get(0));
		deck.remove(0);
		return dealerHand;
	}
	static void board(ArrayList<String> dealerHand, ArrayList<String> playerHand, boolean dealerTurn){
		clearClass.clear();
		gameboardClass.gameBoard(dealerHand, playerHand, dealerTurn);
	}
	static void pause(){
		try{
			Thread.sleep(1000);

		}catch(InterruptedException e){
			System.out.println("ERROR");
		}
	}
}
