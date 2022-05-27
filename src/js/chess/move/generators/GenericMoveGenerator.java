package js.chess.move.generators;

import java.util.Optional;

import js.chess.Board;
import js.chess.Color;
import js.chess.Piece;
import js.chess.move.MoveGenerator;

public abstract class GenericMoveGenerator implements MoveGenerator {
    
    protected Color getPieceColor(int currentPos, Board board) {
        Optional<Piece> piece = board.getSquares().get(currentPos).getPiece();

        if (piece.isEmpty())
            throw new IllegalArgumentException("getPieceColor() was called on a square which doesn't have a piece");

        return board.getSquares().get(currentPos).getPiece().get().getColor();
    }
}
