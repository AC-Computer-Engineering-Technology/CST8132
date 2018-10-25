package rps;

import java.util.Scanner;

public class Human extends Player {
	Scanner in;

	public Human(Scanner input) {
		// TODO Auto-generated constructor stub
		super(input.next());
		this.in = input;
	}

	@Override
	public boolean takeTurn() {
		String firstLetter;
		boolean control = false;
	    do {
	    	System.out.print(this.getName() + ", it’s your turn (Enter R for Rock, P for Paper, S for Scissors, or Q to quit): ");
	    	firstLetter = this.in.next().toUpperCase();
	    	firstLetter = firstLetter.substring(0, 1);
	    	control = true;
	    	switch(firstLetter) {
	    	case "Q":
	    		return false;
	    	case "S":
	    		this.lastMove = HandSign.getHandSign(firstLetter);
	    		System.out.println(this.getName() + " played " + this.lastMove.name());
	    		break;
	    	case "P":
	    		this.lastMove = HandSign.getHandSign(firstLetter);
	    		System.out.println(this.getName() + " played " + this.lastMove.name());
	    		break;
	    	case "R":
	    		this.lastMove = HandSign.getHandSign(firstLetter);
	    		System.out.println(this.getName() + " played " + this.lastMove.name());
	    		break;
	    	default:
	    		System.out.println("Invalid input, please try again...");
	    		control = false;
	    		break;
	    	}
	    } while(!control);
	    
		return true;
	}

}
