package js.chess.move.generators;

import java.util.ArrayList;
import java.util.List;

import js.chess.Board;
import js.chess.Color;
import js.chess.Square;
import js.chess.move.Move;
import js.chess.move.MoveGenerator;
import js.chess.move.MoveType;

public class RookMoveGenerator extends GenericMoveGenerator implements MoveGenerator {

    private final int horizontalOffsets[][] = {
        { -1, -2, -3, -4, -5, -6, -7 }, // left
        { 1, 2, 3, 4, 5, 6, 7 }, // right
    };

    private final int verticalOffsets[][] = {
        { 8, 16, 24, 32, 40, 48, 56 }, // bottom
        { -8, -16, -24, -32, -40, -48, -56 }, // top
    };

    // TODO do better
    @Override
    public List<Move> getPossibleMoves(int currentPos, Board board) {
        Color color = getPieceColor(currentPos, board);

        List<Move> toReturn = new ArrayList<>(28);

        for (int[] line : horizontalOffsets) {
            int previousPos = currentPos;

            for (int offset : line) {
                int nextPos = currentPos + offset;
                if (nextPos >= 0 && nextPos < 64) {

                    if (Math.abs((nextPos / 8) - (previousPos / 8)) != 0)
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

        for (int[] line : verticalOffsets) {

            for (int offset : line) {
                int nextPos = currentPos + offset;
                if (nextPos >= 0 && nextPos < 64) {

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
