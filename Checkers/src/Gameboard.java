
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


/**
 * Class that creates a gameboard that the game can be played on
 * Controls the javafx that shows the game to the user
 * @author Declan McGauley
 * @version 1.0
 */
public class Gameboard extends Application{
	
	public static final int BOARD_HEIGHT = 8;
	public static final int BOARD_WIDTH = 8;
	public static final int TILE_SIZE = 100;
	
	private Tile[][] board = new Tile[BOARD_WIDTH][BOARD_HEIGHT];
	private Group tiles = new Group();
	private Group pieces = new Group();
	
	
	private Parent createBoard() {
		Pane root = new Pane();
		root.setPrefSize(TILE_SIZE * BOARD_WIDTH, TILE_SIZE * BOARD_HEIGHT);
		root.getChildren().addAll(tiles, pieces);
		
		for (int i = 0; i < BOARD_HEIGHT; i++) {
			for (int j = 0; j < BOARD_WIDTH; j++) {
				Tile tile = new Tile((i + j) % 2 == 0, j, i);
				board[j][i] = tile;
				
				tiles.getChildren().add(tile);
				
				Piece piece = null;
				if (i <= 2 && (i + j) % 2 != 0) {
					piece = makePiece(PeiceType.RED, j, i);
				}
				
				if (i >= 5 && (i + j) % 2 != 0) {
					piece = makePiece(PeiceType.WHITE, j, i);
				}
				
				if (piece != null) {
					tile.setPiece(piece);
					pieces.getChildren().add(piece);
				}
			}
		}
		return root;
	}
	
	private Piece makePiece(PeiceType type, int x, int y) {
		Piece piece = new Piece(type, x, y);
		return piece;
	}
	
	public void start(Stage primaryStage) throws Exception{
		Scene scene = new Scene(createBoard());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Checkers!");
		primaryStage.show();
	}
	
	
	public static void main (String[] args) {
		Application.launch(args);
	}
}
