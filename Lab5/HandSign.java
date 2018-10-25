package rps;

/**
 * Define an enumeration called Sign, with 3 elements, referred to as:
 * HandSign.SCISSORS, HandSign.PAPER, HandSign.ROCK.
 * @author Jesse Okeya
 * @version 1.1
 * @since 1.8
 */
public enum HandSign {
	
	ROCK, PAPER, SCISSORS;
	
	/**
	 * Get the HandSign for a given letter.
	 * @param firstLetter The letter representing a HandSign value (R, P, or S).
	 * @return The HandSign value which corresponds to the given letter, otherwise return null.
	 */
	public static HandSign getHandSign(String firstLetter) {
		for (HandSign h : HandSign.values())
			if (h.name().startsWith(firstLetter.toUpperCase()))
				return h;
		return null;
	}
	
	public static int getWinner(HandSign[] moves) {
		if (moves[0] == moves[1]){
			return -1;
		}
		else if ((moves[0] == HandSign.SCISSORS && moves[1] == HandSign.PAPER) ||
				 (moves[0] == HandSign.PAPER && moves[1] == HandSign.ROCK) ||
				 (moves[0] == HandSign.ROCK && moves[1] == HandSign.SCISSORS)) {
			return 0;
		} 
		else {
			return 1;
		}
	}
}
