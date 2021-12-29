import java.util.List;

import js.chess.Board;
import js.chess.Color;
import js.chess.Piece;
import js.chess.Square;
import js.chess.move.Move;
import js.chess.move.generators.BishopMoveGenerator;

public class TestBishopMoveGenerator {

    public static void main(String[] args) {

        Board board = new Board();
        List<Square> squares = board.getSquares();

        Piece whitePiece1 = new Piece("♗", Color.WHITE);
        Piece test = new Piece("X", Color.BLACK);

        int pos = 63;
        squares.get(pos).setPiece(whitePiece1);
        squares.get(54).setPiece(whitePiece1);

        BishopMoveGenerator bishopMoveGenerator = new BishopMoveGenerator(board);
        List<Move> possibleMoves = bishopMoveGenerator.getPossibleMoves(pos, Color.BLACK);

        for (Move move : possibleMoves) { 
            squares.get(move.getTo()).setPiece(test);
        }

        System.out.println(board.toString());
        System.out.println("damn");
    }
}
