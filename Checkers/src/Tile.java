import javafx.scene.shape.Rectangle;

/**
 * Class that represents a square on the gameboard
 * @author Declan
 * @version 1.0
 *
 */
public class Tile extends Rectangle{
	
	private boolean colour;
	private int x;
	private int y;
	
	public Tile(boolean colour, int x, int y) {
		setWidth(Gameboard.TILE_SIZE);
		setHeight(Gameboard.TILE_SIZE);
		
		relocate(x * Gameboard.TILE_SIZE, y * Gameboard.TILE_SIZE);
	}
}
