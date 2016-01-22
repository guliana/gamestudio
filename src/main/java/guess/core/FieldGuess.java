package guess.core;

import java.util.Random;

public class FieldGuess {
	private final int fromNumber;
	
	private long startMillis;
	
	private final int toNumber;

	public FieldGuess(int fromNumber, int toNumber) {
		this.fromNumber = fromNumber;
		this.toNumber = toNumber;
		
	}

	public int generateNumber() {
		startMillis = System.currentTimeMillis();
		Random rd = new Random();
		return fromNumber + rd.nextInt(toNumber - fromNumber + 1);
		
	}
	
	public int getFromNumber() {
		return fromNumber;
	}
	
	public int getToNumber() {
		return toNumber;
	}
	
	public int getPlayingSeconds() {
		return (int) ((System.currentTimeMillis() - startMillis) / 1000);
	}
}
