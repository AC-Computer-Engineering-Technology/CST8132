package rps;

public abstract class Player {
	public static int ties = 0;
	public String name;
	public HandSign lastMove;
	private int wins;
	
	public Player(String name) {
		this.wins  = 0;
		this.name = name;
	}
	
	public void win() {
		this.wins++;
	}
	
	public static void tie() {
		Player.ties++;
	}
	
	public String toString() {
		return "Sample OutPut: \n + Player: " + this.name + "\n Wins: " + this.wins;
	}
	
	public abstract boolean takeTurn();
	
	public String getName() {
		return this.name;
	}
	
	public HandSign getLastMove() {
		return this.lastMove;
	}
	
	public int getWins() {
		return this.wins;
	}
	
	public int getTies() {
		return this.ties;
	}
}
