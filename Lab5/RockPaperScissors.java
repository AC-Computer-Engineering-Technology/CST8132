package rps;

public class RockPaperScissors extends Game {

	public RockPaperScissors(int value) {
		super(value);
		this.initPlayers();
		System.out.print("Enter players name: ");
		this.players[0] = new Human(this.in);
		this.players[1] = new Computer();
	}
	
	public void play() {
		for (int i = 0; i < this.numRounds; i++) {
			boolean quits = this.players[0].takeTurn();
			if (quits == false) {
				break;
			} else {
				this.players[1].takeTurn();
			}
			this.evaluateRound();
		}
	}

	public void evaluateRound() {
		HandSign[] moves = new HandSign[]{players[0].getLastMove(), players[1].getLastMove()};
		int winner = HandSign.getWinner(moves);
		if (winner == -1) {
			Player.tie();
			System.out.println("It’s a tie!");
			System.out.println("Ties: " + Player.ties + "\n");
		}
		if (winner != -1) {
			int loser = (winner == 0) ? 1 : 0;
			System.out.println(players[winner].lastMove.name() + " beats " + players[loser].lastMove.name() + " " + players[winner].getName()  + " wins! \n");
			players[winner].win();
		}
	}
	
	public void displayResults() {
		Player winner = null;
		for(int i = 0; i < this.players.length; i++) {
			this.players[i].toString();
			if (this.players[i].getWins() > this.numRounds/2) {
				winner = this.players[i];
			}
		}
		System.out.println("Ties: " + Player.ties);
		if (winner == null) {
			System.out.println("It’s a tie game!");
		} else {
			System.out.println("The winner is " + winner.getName() + "! ");
			System.out.println("Thanks for playing Rock, Paper, Scissors. Bye!");
		}
	}

}
