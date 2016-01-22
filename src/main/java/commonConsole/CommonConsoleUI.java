package commonConsole;

import java.util.Scanner;

import fifteenpuzzle.consoleUI.ConsoleUIPuzzle;
import guess.consoleUI.ConsoleUIGuess;
import minesweeper.consoleui.ConsoleUIMines;

public class CommonConsoleUI {

	private ConsoleUIPuzzle consoleUIPuzzle;
	private ConsoleUIMines consoleUIMnes;
	private ConsoleUIGuess consoleUIGuess;

	public ConsoleUIPuzzle getConsoleUIPuzzle() {
		return consoleUIPuzzle;
	}

	public void setConsoleUIPuzzle(ConsoleUIPuzzle consoleUIPuzzle) {
		this.consoleUIPuzzle = consoleUIPuzzle;
	}

	public ConsoleUIMines getConsoleUIMnes() {
		return consoleUIMnes;
	}

	public void setConsoleUIMnes(ConsoleUIMines consoleUIMnes) {
		this.consoleUIMnes = consoleUIMnes;
	}

	public ConsoleUIGuess getConsoleUIGuess() {
		return consoleUIGuess;
	}

	public void setConsoleUIGuess(ConsoleUIGuess consoleUIGuess) {
		this.consoleUIGuess = consoleUIGuess;
	}

	public void play() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println(
				"Select your game : For MINES press 1\n For FIFTEEN PUZZLE press 2 \n For GUESS MY NUMBER press 3");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			consoleUIMnes.play();
			break;
		case 2:
			consoleUIPuzzle.play();
			break;
		case 3:
			consoleUIGuess.play();
			break;
		default:
			System.out.println("You pressed wrong number. We do not offer games for morons. Bye. For Ever!");
			break;
		}

	}

}
