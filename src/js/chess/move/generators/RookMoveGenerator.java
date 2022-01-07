package js.chess.move.generators;

import java.util.ArrayList;
import java.util.List;

import js.chess.Board;
import js.chess.Color;
import js.chess.Square;
import js.chess.move.Move;
import js.chess.move.MoveGenerator;
import js.chess.move.MoveType;

public class RookMoveGenerator implements MoveGenerator {

    private Board board;

    private final int[][] offsets = {
            { -1, -2, -3, -4, -5, -6, -7 }, // left
            { -8, -16, -24, -32, -40, -48, -56 }, // top
            { 1, 2, 3, 4, 5, 6, 7 }, // right
            { 8, 16, 24, 32, 40, 48, 56 }, // bottom
    };

    public RookMoveGenerator(Board board) {
        this.board = board;
    }

    @Override
    public List<Move> getPossibleMoves(int currentPos, Color color) {
        List<Move> toReturn = new ArrayList<>(offsets.length);

        for (int[] line : offsets) {
            int previousPos = currentPos;

            for (int offset : line) {
                int nextPos = currentPos + offset;
                if (nextPos >= 0 && nextPos < 64) {

                    if (Math.abs((nextPos / 8) - (previousPos / 8)) != 1)
                        break; // We skip to the next diagonal if we are "out of bounds"

                    Square square = board.getSquares().get(nextPos);

                    if (square.isEmpty()) {
                        toReturn.add(new Move(currentPos, nextPos, MoveType.QUIET_MOVE));
                    } else {
                        if (square.getPiece().get().getColor() != color)
                            toReturn.add(new Move(currentPos, nextPos, MoveType.CAPTURES));

                        break; // We stop once we meet the first piece in the line
                    }

                }
            }
        }
        return toReturn;
    }
}
