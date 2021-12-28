import java.util.List;

import js.chess.Board;
import js.chess.Color;
import js.chess.Piece;
import js.chess.Square;
import js.chess.move.Move;
import js.chess.move.generators.KnightMoveGenerator;

public class TestKnightMoveGenerator {

    public static void main(String[] args) {
        
        Board board = new Board();
        List<Square> squares = board.getSquares();

        Piece whitePiece0 = new Piece("♘", Color.WHITE, 18);
        Piece whitePiece1 = new Piece("♘", Color.WHITE, 1);
        Piece blackPiece = new Piece("♞", Color.BLACK, 2);
        Piece blackPiece2 = new Piece("♞", Color.BLACK, 3);

        squares.get(0).setPiece(whitePiece0);
        squares.get(2).setPiece(blackPiece);
        squares.get(17).setPiece(blackPiece2);
        squares.get(32).setPiece(whitePiece1);

        KnightMoveGenerator knightMoveGenerator = new KnightMoveGenerator(board);
        System.out.println(board.toString());

        List<Move> possibleMoves = knightMoveGenerator.getPossibleMoves(blackPiece);


        System.out.println(board.toString());
    }
}
