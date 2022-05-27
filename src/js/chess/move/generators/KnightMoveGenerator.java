package js.chess.move.generators;

import java.util.ArrayList;
import java.util.List;

import js.chess.Board;
import js.chess.Color;
import js.chess.Square;
import js.chess.move.Move;
import js.chess.move.MoveType;
import js.chess.move.MoveGenerator;

public class KnightMoveGenerator extends GenericMoveGenerator implements MoveGenerator {

    private int[] offsets = {
            -17, -15,
            -10, -6,
            6, 10,
            15, 17
    };

    private int[] horizontalOffsets = {
            -1, 1,
            -2, 2,
            -2, 2,
            -1, 1
    };

    // TODO check if in check
    @Override
    public List<Move> getPossibleMoves(int currentPos, Board board) {
        Color color = getPieceColor(currentPos, board);

        List<Move> moves = new ArrayList<>(8);

        for (int i = 0; i < offsets.length; i++) {

            // checking if in bounds horizontally
            int horizontalPos = currentPos % 8;
            int finalPosHor = horizontalPos + horizontalOffsets[i];
            boolean inBoundsHorizontally = finalPosHor >= 0 && finalPosHor < 8;

            // checking if in bounds vertically
            int finalPos = currentPos + offsets[i];
            boolean inBoundsVertically = finalPos >= 0 && finalPos < 64;

            if (inBoundsHorizontally && inBoundsVertically) {

                Square square = board.getSquares().get(finalPos);

                if (square.isEmpty()) {
                    moves.add(new Move(currentPos, finalPos, MoveType.QUIET_MOVE));
                } else if (square.getPiece().get().getColor() != color) {
                    moves.add(new Move(currentPos, finalPos, MoveType.CAPTURES));
                }
            }
        }

        return moves;
    }

}