import java.util.List;

import js.chess.Board;
import js.chess.Color;
import js.chess.Piece;
import js.chess.Square;
import js.chess.move.Move;
import js.chess.move.generators.BishopMoveGenerator;

public class TestBishopMoveGenerator {

    private static int[] offsets1 = {
            -9, -18, -27, -36, -45, -54, -63, // top left diagonal
            -7, -14, -21, -28, -35, -42, -49, // top right diagonal
            7, 14, 21, 28, 35, 42, 49, // top left diagonal
            9, 18, 27, 36, 45, 54, 63 // bottom right diagonal
    };

    // Could also do it in 1d array but that's for another day
    private static int[][] offsets = {
            {-9, -18, -27, -36, -45, -54, -63}, // top left diagonal
            {-7, -14, -21, -28, -35, -42, -49}, // top right diagonal
            {7, 14, 21, 28, 35, 42, 49},        // bottom left diagonal 
            {9, 18, 27, 36, 45, 54, 63},        // bottom right diagonal
    };

    public static void main(String[] args) {

        Board board = new Board();
        List<Square> squares = board.getSquares();

        Piece whitePiece1 = new Piece("♗", Color.WHITE);
        Piece test = new Piece("X", Color.BLACK);

        int pos = 23;

        squares.get(pos).setPiece(whitePiece1);

        for (int[] line : offsets) {
            int previousPos = pos;

            for (int offset : line) {
                int nextPos = pos + offset;
                if (nextPos >= 0 && nextPos < 64) {

                    if (Math.abs((nextPos / 8) - (previousPos / 8)) != 1)
                        break; // We skip to the next diagonal if we are "out of bounds"

                    squares.get(nextPos).setPiece(test);
                    previousPos = nextPos;
                }
            }
        }

        BishopMoveGenerator bishopMoveGenerator = new BishopMoveGenerator(board);
        System.out.println(board.toString());

        List<Move> possibleMoves = bishopMoveGenerator.getPossibleMoves(35, Color.BLACK);

        System.out.println(board.toString());
    }
}
