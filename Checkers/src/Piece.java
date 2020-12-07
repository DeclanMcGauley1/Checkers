import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * Class that represents the checks Piece that will be moving around the board
 * @author Declan
 * @version 1.0
 */
public class Piece extends StackPane {
	
	private PeiceType type;
	
	public PeiceType getType() {
		return this.type;
	}
	
	public Piece(PeiceType type, int x, int y) {
		this.type = type;
		relocate(x * Gameboard.TILE_SIZE, y * Gameboard.TILE_SIZE);
		
		Ellipse thisPiece = new Ellipse(Gameboard.TILE_SIZE * 0.3, Gameboard.TILE_SIZE * 0.2);
		thisPiece.setFill(type == PeiceType.RED ? Color.valueOf("#FF0000") : Color.valueOf("#FFFFFF"));
		
		thisPiece.setTranslateX((Gameboard.TILE_SIZE - Gameboard.TILE_SIZE * 0.3 * 2) / 2);
		thisPiece.setTranslateY((Gameboard.TILE_SIZE - Gameboard.TILE_SIZE * 0.2 * 2) / 2);
		
		getChildren().addAll(thisPiece);
	}
}
