package fifteenpuzzle.core;

public class Tile {
	private TileState state = TileState.CLICABLE;

	public TileState getState() {
		return state;
	}

	public void setState(TileState state) {
		this.state = state;
	}
}
