class clearClass{
	static void clear(){//when called, this method will clear all text previously on the screen
		System.out.println("\033[H\033[J");
		System.out.flush();
	}
}
