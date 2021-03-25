import java.util.Scanner;
class blackjack{
	public static void main(String[] args){
		String[][] decks = getData();//gets 6 decks of standard playing cards
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to play blackjack?  \n\n [y] = yes	|    [n] = no");//prompts the user
		String answer = input.nextLine();
		if(answer.equals("y")){
			while(true){
				clearClass.clear();
				decks = play.game(decks);//plugs the decks into the play class. Returns the same deck and used card pile after your game is over so it can be used in the next game
				System.out.println("\nWould you like to play again?  \n\n [y] = yes	|    	[n] = no");//Asks if they would like to play again
				String newGame = input.nextLine();
				if(newGame.equals("y")){
				}else{
					clearClass.clear();//clears all previous text
					System.out.println("Goodbye");
					break;//breks the loop, ending the program
				}
			}
		}else if(answer != "y"){
			clearClass.clear();
			System.out.println("Goodbye");
		}
	}
	static String[][] getData(){ //builds the initial starting deck and creates the array for a dead deck pile
		String[] freshDeck = deckClass.buildDeck();
		String[] deadDeck = new String[0];
		String[][] startingData = new String[2][];
		startingData[0] = freshDeck.clone();
		startingData[1] = deadDeck.clone();
		return startingData;
	}
}
