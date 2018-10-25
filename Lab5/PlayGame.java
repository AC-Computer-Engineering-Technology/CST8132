package rps;

public class PlayGame {

	public static void main(String[] args) {
		RockPaperScissors rps = new RockPaperScissors(3);
		rps.play();
		rps.displayResults();
	}

}
