package fifteenpuzzle;

import java.util.Scanner;


import com.mysql.jdbc.Field;

import fifteenpuzzle.consoleUI.ConsoleUIPuzzle;
import fifteenpuzzle.core.FieldPuzzle;
import minesweeper.consoleui.ConsoleUIMines;
import score.HallOfFameDatabase;


public class Main {

	public static void play () {
				
		FieldPuzzle field1 = new FieldPuzzle(3, 3);
		ConsoleUIPuzzle console = new ConsoleUIPuzzle(field1);
		console.setHallOfFame(new HallOfFameDatabase());
		console.play();
	}
}
