package rps;

import java.util.Random;

public class Computer extends Player {

	public Computer() {
		super("HAL");
	}

	@Override
	public boolean takeTurn() {
		Random random = new Random();
		this.lastMove = HandSign.values()[random.nextInt(3)];
		System.out.println(this.getName() + ", its your turn!");
		System.out.println(this.getName() + " played " + this.lastMove.name());
		return true;
	}

}
