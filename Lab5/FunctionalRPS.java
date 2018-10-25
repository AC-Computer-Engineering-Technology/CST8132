package rps;

import java.util.Scanner;
import java.util.Random;

// bonus: Rock, Paper, Scissors, Lizard, Spock
// bonus: 3 player
// bonus: additional rounds upon end of game
// bonus: enum for HandSigns

public class FunctionalRPS {

	public static void main(String[] args) {
		
		// initialize game
		int numRounds = 9;
		Scanner input = new Scanner(System.in);
		String[] handSigns = new String[]{"ROCK", "PAPER", "SCISSORS"};
		
		// initialize players
		// each player has a name, a move, number of wins
		// players share a tie score
		// players have helper variables for each of their moves
		String playerOneName;
		String playerTwoName = "HAL";
		String playerOneMove = "";
		String playerTwoMove = "";
		int playerOneWins = 0;
		int playerTwoWins = 0;
		int ties = 0;
		String playerOneInput = "x";
		Random rand = new Random();
		
		System.out.println("Welcome to Angela's Rock, Paper, Scissors!");
		
		System.out.print("Enter the name of Player One: ");
		playerOneName = input.next();
		
		System.out.println();
		
		playGame:
		for (int i = 0; i < numRounds; i++) {
			
			// playerOneMove
			System.out.println(playerOneName + ", it's your turn!");
			System.out.print("Enter 1 for Rock, 2 for Paper, 3 for Scissors, or Q to Quit: ");
			
			// validate
			while (playerOneInput.equals("x")) {
				
				// get the first character of the user's input as an upper case letter
				playerOneInput = input.next().toUpperCase().substring(0,1);
				
				switch (playerOneInput) {
				
				case "1": case "2": case "3": 
					playerOneMove = handSigns[Integer.parseInt(playerOneInput) - 1];
					break;
				case "Q": 
					break playGame;
				default:
					playerOneInput = "x";
					playerOneMove = "";
				}
				
			}
			
			// playerTwoMove
			System.out.println("HAL, it's your turn!");
			// random move for HAL, if user did not quit
			playerTwoMove = handSigns[rand.nextInt(3)];
			
			System.out.println();
			
			// output player moves
			System.out.println(playerOneName + " played " + playerOneMove);
			System.out.println(playerTwoName + " played " + playerTwoMove);
			
			if ((playerOneMove == "ROCK" && playerTwoMove == "SCISSORS") ||
				(playerOneMove == "SCISSORS" && playerTwoMove == "PAPER") ||
				(playerOneMove == "PAPER" && playerTwoMove == "ROCK")) {
				// playerOne wins
				playerOneWins += 1;
				System.out.println(playerOneName + " wins! Score: " + playerOneWins);
			} else if (playerOneMove == playerTwoMove) {
				// tie
				ties += 1;
				System.out.println("It's a tie! Ties: " + ties);
			} else {
				//playerTwo wins
				playerTwoWins += 1;
				System.out.println(playerTwoName + " wins! Score: " + playerTwoWins);
			}
			
			playerOneInput = "x";
			System.out.println();
		}
		
		System.out.println("Game Over! The final scores are:");
		
		System.out.println(playerOneName + ": " + playerOneWins);
		System.out.println(playerTwoName + ": " + playerTwoWins);
		System.out.println("Ties: " + ties);
	
		input.close();
		
	}		
}
