import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Class that represents a square on the gameboard
 * @author Declan
 * @version 1.0
 *
 */
public class Tile extends Rectangle{
	private Piece piece;
	private boolean colour;
	private int x;
	private int y;
	private boolean hasPiece;
	
	
	public boolean hasPiece() {
		return hasPiece;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public Piece getPiece() {
		return this.piece;
	}
	
	
	public Tile(boolean colour, int x, int y) {
		setWidth(Gameboard.TILE_SIZE);
		setHeight(Gameboard.TILE_SIZE);
		
		relocate(x * Gameboard.TILE_SIZE, y * Gameboard.TILE_SIZE);
		
		setFill(colour ? Color.valueOf("#add8e6") : Color.valueOf("#000000"));
	}
	
	
}
