package js.chess.move.generators;

import java.util.ArrayList;
import java.util.List;

import js.chess.Board;
import js.chess.Color;
import js.chess.Square;
import js.chess.move.Move;
import js.chess.move.MoveGenerator;
import js.chess.move.MoveType;

public class BishopMoveGenerator implements MoveGenerator {

    private Board board;

    private final int[][] offsets = {
            { -9, -18, -27, -36, -45, -54, -63 }, // top left diagonal
            { -7, -14, -21, -28, -35, -42, -49 }, // top right diagonal
            { 7, 14, 21, 28, 35, 42, 49 }, // bottom left diagonal
            { 9, 18, 27, 36, 45, 54, 63 }, // bottom right diagonal
    };

    public BishopMoveGenerator(Board board) {
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
                    } else if (square.getPiece().get().getColor() != color) {
                        toReturn.add(new Move(currentPos, nextPos, MoveType.CAPTURES));
                        break; // We stop once we meet the first piece in the line
                    }

                    previousPos = nextPos;
                }
            }
        }
        return toReturn;
    }
}
