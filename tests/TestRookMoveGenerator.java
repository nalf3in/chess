import java.util.List;

import js.chess.Board;
import js.chess.Color;
import js.chess.Piece;
import js.chess.Symbol;
import js.chess.move.Move;
import js.chess.move.generators.RookMoveGenerator;

public class TestRookMoveGenerator {

    public static void main(String[] args) {

        Board board = new Board();

        Piece whitePiece0 = new Piece(Symbol.ROOK, Color.WHITE);
        Piece whitePiece1 = new Piece(Symbol.ROOK, Color.WHITE);
        Piece blackPiece = new Piece(Symbol.ROOK, Color.BLACK);
        Piece blackPiece2 = new Piece(Symbol.ROOK, Color.BLACK);
        Piece test0 = new Piece(Symbol.TEST0, Color.WHITE);
        Piece test1 = new Piece(Symbol.TEST1, Color.WHITE);

        board.setPiece(1, whitePiece0);
        board.setPiece(2, blackPiece);
        board.setPiece(17, blackPiece2);
        board.setPiece(33, whitePiece1);

        System.out.println("\n AVANT");
        System.out.println(board.toString());
        System.out.println("\n APRES");

        RookMoveGenerator rookMoveGenerator = new RookMoveGenerator(board);
        List<Move> possibleMoves = rookMoveGenerator.getPossibleMoves(17, Color.BLACK);

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
