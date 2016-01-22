package minesweeper.consoleui;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import minesweeper.core.Clue;
import minesweeper.core.FieldMines;
import minesweeper.core.GameState;
import minesweeper.core.Tile;
import score.HallOfFame;
import score.HallOfFameHibernate;

public class ConsoleUIMines {
	private FieldMines field;
	
	private HallOfFameHibernate hallOfFame;
	
	private static final Pattern INPUT_PATTERN = Pattern.compile("([O|M])([A-I])([0-8])");	
	
	public ConsoleUIMines(FieldMines field) {
		this.field = field;
	}

	public HallOfFame getHallOfFame() {
		return hallOfFame;
	}
	
	public void setHallOfFame(HallOfFameHibernate hallOfFame) {
		this.hallOfFame = hallOfFame;
	}
	
	public void play() {		
		show();
		while(field.getState() == GameState.PLAYING) {
			processInput();
			show();
		}
		show();
		
		if(field.getState() == GameState.SOLVED) {
			String name = System.getProperty("user.name");
			String game = "mines";
			//String game = "mines";
			try {
				
				hallOfFame.addScore(name, game, field.getPlayingSeconds());
				hallOfFame.loadScore(game);
				System.out.println(hallOfFame);
			} catch (Exception e) {
				System.err.println("Nepodarilo sa ulozit score");
				e.printStackTrace();
			}
			
			System.out.println("Vyhral si!");
			System.out.println("Enter your rating please ");
			
			System.out.println(hallOfFame);
		} else {
			System.out.println("Prehral si!");
		}
	}
	
	private void processInput() {
		System.out.println("Zrob daco");
		String line = new Scanner(System.in).nextLine().toUpperCase();
		if("X".equals(line)) {
			System.exit(0);
		}
		Matcher matcher = INPUT_PATTERN.matcher(line);
		if(matcher.matches()) {
			int row = matcher.group(2).charAt(0) - 'A';
			int column = Integer.parseInt(matcher.group(3));
			if("O".equals(matcher.group(1))) {
				field.openTile(row, column);
			} else {
				field.markTile(row, column);
			}
		} else {
			System.out.println("Zrob ine, ne toto");
		}
	}

	public void show() {
		showHeader();		
		showField();
	}

	private void showField() {
		for(int row = 0; row < field.getRowCount(); row++) {
			System.out.print((char)(row + 'A'));
			
			for(int column = 0; column < field.getColumnCount(); column++) {
				System.out.print(" ");
				
				Tile tile = field.getTile(row, column);
				switch (tile.getState()) {
				case CLOSED:
					System.out.print("-");	
					break;
				case MARKED:
					System.out.print("M");	
					break;
				case OPEN:
					if(tile instanceof Clue) {
						System.out.print(((Clue) tile).getValue());
					} else {
						System.out.print("X");
					}						
					break;
				default:
					break;
				}				
			}
			
			System.out.println();						
		}
	}

	private void showHeader() {
		System.out.println("Time: " + field.getPlayingSeconds() + " s");
		
		System.out.print(" ");
		for(int column = 0; column < field.getColumnCount(); column++) {
			System.out.print(" "+ column);
		}
		System.out.println();
	}
}
