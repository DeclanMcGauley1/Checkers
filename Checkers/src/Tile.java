import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Declan
 */
public class Tile extends Rectangle {

    private Piece piece;

    public boolean hasPiece() {
        return piece != null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Tile(boolean light, int x, int y) {
        setWidth(Gameboard.TILE_SIZE);
        setHeight(Gameboard.TILE_SIZE);

        relocate(x * Gameboard.TILE_SIZE, y * Gameboard.TILE_SIZE);

        setFill(light ? Color.valueOf("#feb") : Color.valueOf("#582"));
    }
}