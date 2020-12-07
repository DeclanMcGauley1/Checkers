
public class Move {

    private MoveType type;

    public MoveType getType() {
        return type;
    }

    private Piece piece;

    public Piece getPiece() {
        return piece;
    }

    public Move(MoveType type) {
        this(type, null);
    }

    public Move(MoveType type, Piece piece) {
        this.type = type;
        this.piece = piece;
    }
}
