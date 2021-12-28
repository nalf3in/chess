package js.chess.move;

import java.util.List;

import js.chess.Piece;

public interface MoveGenerator {
    public List<Move> getPossibleMoves(Piece piece);
}
