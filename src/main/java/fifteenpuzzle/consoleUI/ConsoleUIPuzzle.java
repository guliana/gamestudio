package fifteenpuzzle.consoleUI;

import java.util.Random;


import java.util.Scanner;

import fifteenpuzzle.core.FieldPuzzle;
import score.HallOfFame;
import score.HallOfFameDatabase;



public class ConsoleUIPuzzle {
	Scanner sc = new Scanner(System.in);

	private FieldPuzzle field;

	private HallOfFame hallOfFame;
	
	public ConsoleUIPuzzle(FieldPuzzle field) {
		this.field = field;
	}

	public HallOfFame getHallOfFame() {
		return hallOfFame;
	}
	

	public void setHallOfFame(HallOfFame hallOfFame) {
		this.hallOfFame = hallOfFame;
	}


	public void play() {
		field = new FieldPuzzle(3, 3);
		
		show();

		while (!(field.isWinner() == true)) {
			System.out.println("Move: UP<8> DOWN<2> RIGHT<6> LEFT<4> ");
			int input = sc.nextInt();

			switch (input) {
			case 8:
				field.moveTileUp();
				show();
				break;
			case 2:
				field.moveTileDown();
				show();
				break;
			case 4:
				field.moveTileLeft();
				show();
				break;
			case 6:
				field.moveTileRight();
				show();
				break;
			default:
				System.out.println("You pressed wrong number you fool!");
				break;
			}
		}
	
		String name = System.getProperty("user.name");
		String game = "15puzzle";
		System.out.println(name + " " + field.getPlayingSeconds() + "s");
		try {
			//hallOfFame.load();
			hallOfFame.addScore(name, game, field.getPlayingSeconds());
			//hallOfFame.save();
		} catch (Exception e) {
			System.err.println("Nepodarilo sa ulozit score");
			e.printStackTrace();
		}
		System.out.println("You won!!! Congratulation!!");
		System.out.println(hallOfFame);

	}

	private void show() {
		System.out.println("Time: " + field.getPlayingSeconds() + " s");

		for (int row = 0; row < field.getRowCount(); row++) {
			for (int column = 0; column < field.getColumnCount(); column++) {
				System.out.print(field.getTiles(row, column) + "\t");
			}
			System.out.println();
		}
	}


	
}
