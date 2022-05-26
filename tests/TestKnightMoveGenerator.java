import java.util.List;

import js.chess.Board;
import js.chess.Color;
import js.chess.Piece;
import js.chess.Symbol;
import js.chess.move.Move;
import js.chess.move.generators.KnightMoveGenerator;

public class TestKnightMoveGenerator {

    public static void main(String[] args) {
        
        Board board = new Board();

        Piece whitePiece0 = new Piece(Symbol.KNIGHT, Color.WHITE);
        Piece whitePiece1 = new Piece(Symbol.KNIGHT, Color.WHITE);
        Piece blackPiece = new Piece(Symbol.KNIGHT, Color.BLACK);
        Piece blackPiece2 = new Piece(Symbol.KNIGHT, Color.BLACK);
        Piece test0 = new Piece(Symbol.TEST0, Color.WHITE);
        Piece test1 = new Piece(Symbol.TEST1, Color.WHITE);

        KnightMoveGenerator knightMoveGenerator = new KnightMoveGenerator(board);

        board.setPiece(0, whitePiece0);
        board.setPiece(2, blackPiece);
        board.setPiece(17, blackPiece2);
        board.setPiece(32, whitePiece1);

        System.out.println("\n AVANT");
        System.out.println(board.toString());
        System.out.println("\n APRES");

        List<Move> possibleMoves = knightMoveGenerator.getPossibleMoves(17, Color.BLACK);

        for (Move move : possibleMoves) {
            if (move.isCapture()) {
                board.setPiece(move.getTo(), test1);
            } else {
                board.setPiece(move.getTo(), test0);
            }
        }

        System.out.println(board.toString());
    }
}
