import java.util.List;

import js.chess.Board;
import js.chess.Color;
import js.chess.Piece;
import js.chess.Square;
import js.chess.move.Move;
import js.chess.move.generators.BishopMoveGenerator;

public class TestBishopMoveGenerator {

    // There's a white piece at G,1 the last move (a capture) is supposed to be there and there's 
    // a white piece at C,6 which should block the bishop

    public static void main(String[] args) {

        Board board = new Board();
        List<Square> squares = board.getSquares();

        Piece blackPiece = new Piece("♝", Color.BLACK);
        Piece whitePiece = new Piece("♗", Color.WHITE);
        Piece test = new Piece("X", Color.BLACK);

        int pos = 36;
        squares.get(pos).setPiece(blackPiece);
        squares.get(54).setPiece(whitePiece);
        squares.get(pos - 18).setPiece(blackPiece);

        BishopMoveGenerator bishopMoveGenerator = new BishopMoveGenerator(board);
        List<Move> possibleMoves = bishopMoveGenerator.getPossibleMoves(pos, Color.BLACK);

        for (Move move : possibleMoves) { 
            squares.get(move.getTo()).setPiece(test);
        }

        System.out.println(board.toString());
        System.out.println("damn");
    }
}
