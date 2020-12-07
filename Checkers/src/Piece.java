import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * @author Declan
 */
public class Piece extends StackPane {

    private PeiceType type;

    private double mouseX, mouseY;
    private double oldX, oldY;

    public PeiceType getType() {
        return type;
    }

    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }

    public Piece(PeiceType type, int x, int y) {
        this.type = type;

        move(x, y);

        Ellipse bg = new Ellipse(Gameboard.TILE_SIZE * 0.3125, Gameboard.TILE_SIZE * 0.26);
        bg.setFill(Color.BLACK);

        bg.setStroke(Color.BLACK);
        bg.setStrokeWidth(Gameboard.TILE_SIZE * 0.03);

        bg.setTranslateX((Gameboard.TILE_SIZE - Gameboard.TILE_SIZE * 0.3125 * 2) / 2);
        bg.setTranslateY((Gameboard.TILE_SIZE - Gameboard.TILE_SIZE * 0.26 * 2) / 2 + Gameboard.TILE_SIZE * 0.07);

        Ellipse ellipse = new Ellipse(Gameboard.TILE_SIZE * 0.3125, Gameboard.TILE_SIZE * 0.26);
        ellipse.setFill(type == PeiceType.RED
                ? Color.valueOf("#c40003") : Color.valueOf("#fff9f4"));

        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(Gameboard.TILE_SIZE * 0.03);

        ellipse.setTranslateX((Gameboard.TILE_SIZE - Gameboard.TILE_SIZE * 0.3125 * 2) / 2);
        ellipse.setTranslateY((Gameboard.TILE_SIZE - Gameboard.TILE_SIZE * 0.26 * 2) / 2);

        getChildren().addAll(bg, ellipse);

        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });

        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });
    }

    public void move(int x, int y) {
        oldX = x * Gameboard.TILE_SIZE;
        oldY = y * Gameboard.TILE_SIZE;
        relocate(oldX, oldY);
    }

    public void abortMove() {
        relocate(oldX, oldY);
    }
}