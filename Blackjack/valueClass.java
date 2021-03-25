import java.util.ArrayList;
class valueClass{
	static int cardTotal(ArrayList<String> hand){
		int aces = aCount(hand);
		int value = getValue(hand);
		if(value > 21){//If statement for value adjustment if the total value is over 21
			if(aces == 1){ //if there is only 1 ace, will suptract 10 from the value 
				value -= 10;
			}else if(aces != 0 && aces != 1){//execute if there are more than 1 aces
				for(int i = 0; i <= aces; i++){ //Will subtract 10 for each ace
					value -= 10;
					if(value <= 21){//will break the loop early if the value drops below 21 at any point
						break;
					}
				}
			}
		}
		return value;
	}
	static int getValue(ArrayList<String> hand){//Gets the individual card from the arraylist
		int value = 0;
		for(int i = 0; i < hand.size(); i++){
			value += value(hand.get(i));
		}
		return value;
	}
	static int value(String card){//counts the value of all the cards in the hand
		int value = 0;
		card = card.substring(0, card.length() - 1);
		if(card.equals("J") || card.equals("Q") || card.equals("K")){
			value += 10;
		}else if(card.equals("A")){
			value += 11;
		}else{
			int convert = Integer.parseInt(card);
			value += convert;
		}
		return value;
	}
	static int aCount(ArrayList<String> hand){ //counts the number of aces in the hand
		int count = 0;
		for(int i = 0; i < hand.size(); i++){
			String value = hand.get(i);
			value = value.substring(0, value.length() - 1);
			if(value.equals("A")){
				count++;
			}
		}
		return count;
	}
}
