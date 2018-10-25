package rps;

import java.util.Scanner;

public abstract class Game implements Playable {
	public int numRounds;
	public Player players [];
	public Scanner in;
	
	public Game(int value) {
		this.numRounds = value;
		this.players = new Player[Playable.NUM_PLAYERS];
		this.in = new Scanner(System.in);
	}
	
	public void initPlayers() {
		try {
            // this.in.close();
      } catch (Exception e) {  }
	}
	
}
