package fifteenpuzzle.core;

import java.util.Random;

public class FieldPuzzle {

	private final int rowCount;
	private final int columnCount;
	private final int[][] tiles;
	private long startMillis;

	public int getTiles(int row, int column) {
		return tiles[row][column];
	}

	public FieldPuzzle(int rowCount, int columnCount) {
		tiles = new int[rowCount][columnCount];
		this.rowCount = rowCount;
		this.columnCount = columnCount;

		if (!(rowCount > 0 && columnCount > 0)) {
			throw new IllegalArgumentException("Mistake...");
		}
		generate();
		mix();
		startMillis = System.currentTimeMillis();
	}

	private void generate() {
		generateNumbers();
	}

	private void generateNumbers() {
		int number = 1;
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				tiles[row][column] = number;
				number += 1;
			}
		}
		tiles[rowCount - 1][columnCount - 1] = 0;
	}

	public void NeighbourNumbers(int row, int column) {
		if (tiles[row][column] == 0) {
			for (int rowOfSet = -1; rowOfSet <= 1; rowOfSet++) {
				int actualRow = row + rowOfSet;
				if (actualRow >= 0 && actualRow < rowCount) {
					for (int columnOfSet = 0; columnOfSet < tiles.length; columnOfSet++) {
						int actualColumn = column + columnOfSet;
						if (actualColumn >= 0 && actualColumn < columnCount) {

						}
					}
				}
			}
		}
	}

	public void moveTileUp() {
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				if ((tiles[row][column]) == 0) {
					if (row - 1 >= 0) {
						tiles[row][column] = tiles[row - 1][column];
						tiles[row - 1][column] = 0;
						return;
					}
				}
			}
		}
	}

	public void moveTileDown() {
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				if ((tiles[row][column]) == 0) {
					if (row + 1 < rowCount) {
						tiles[row][column] = tiles[row + 1][column];
						tiles[row + 1][column] = 0;
						return;
					}
				}
			}
		}
	}

	public void moveTileRight() {
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				if ((tiles[row][column]) == 0) {
					if (column + 1 < columnCount) {
						tiles[row][column] = tiles[row][column + 1];
						tiles[row][column + 1] = 0;
						return;
					}
				}
			}
		}
	}

	public void moveTileLeft() {
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				if ((tiles[row][column]) == 0) {
					if (column - 1 >= 0) {
						tiles[row][column] = tiles[row][column - 1];
						tiles[row][column - 1] = 0;
						return;
					}
				}
			}
		}
	}

	public boolean isWinner() {
		int number = 1;
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				if (row == rowCount - 1 && column == columnCount - 1) {
					return true;
					//return tiles[row - 1][column - 1] == 0;
				} else if (tiles[row][column] != number) {
					return false;
				}
				number++;
			}
		}

		return true;
	}

	private void mix() {

		for (int i = 0; i < 10; i++) {

			int randomBackMove = (int) ((Math.random() * 4) + 1);

			switch (randomBackMove) {
			case 1:
				moveTileUp();
				break;
			case 2:
				moveTileDown();
				break;
			case 3:
				moveTileLeft();
				break;
			case 4:
				moveTileRight();
				break;
			}
		}
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public int getPlayingSeconds() {
		return (int) ((System.currentTimeMillis() - startMillis) / 1000);
	}
}
