package guess.consoleUI;

import java.util.Scanner;

import guess.core.FieldGuess;
import score.HallOfFame;

public class ConsoleUIGuess {
	private FieldGuess fg;
	
	private HallOfFame hallOfFame;

	public FieldGuess getFg() {
		return fg;
	}

	public void setFg(FieldGuess fg) {
		this.fg = fg;
	}

	public HallOfFame getHallOfFame() {
		return hallOfFame;
	}

	public void setHallOfFame(HallOfFame hallOfFame) {
		this.hallOfFame = hallOfFame;
	}

	public ConsoleUIGuess(FieldGuess fg) {
		super();
		this.fg = fg;
	}

	public void play() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"\t H E L L O! \n I'm the nicest computer in the world..Are you ready??\n So....Try to catch my number..");
		int currentPCNumber = fg.generateNumber();

		int userNumber = 0;
		do {
			System.out.printf("Enter number from %d to %d\n", fg.getFromNumber(), fg.getToNumber());
			userNumber = sc.nextInt();

			if (userNumber > currentPCNumber) {
				System.out.println("Try to remove");
				System.out.println("Guess again my sweetheart <3");
			} else if (userNumber < currentPCNumber) {
				System.out.println("Try to add");
			}
		} while (userNumber != currentPCNumber);

		System.out.println("UNBELIEVABLE !!!\n You lucky bastard, YOU WON \n");
		String name = System.getProperty("user.name");
		String game = "guess";
		System.out.println(name + " " + fg.getPlayingSeconds() + "s");
		try{ 
			hallOfFame.addScore(name, game, fg.getPlayingSeconds());
		} catch (Exception e) {
			System.err.println("nepodarilo sa ulozit score");
			e.printStackTrace();
		}
		System.out.println(hallOfFame);
			
		}
	}

