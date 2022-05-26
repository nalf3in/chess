import java.util.List;

import js.chess.Board;
import js.chess.Color;
import js.chess.Piece;
import js.chess.Symbol;
import js.chess.move.Move;
import js.chess.move.generators.BishopMoveGenerator;

public class TestBishopMoveGenerator {

    public static void main(String[] args) {

        Board board = new Board();

        Piece blackPiece = new Piece(Symbol.ROOK, Color.BLACK);
        Piece whitePiece = new Piece(Symbol.BISHOP, Color.WHITE);
        Piece test0 = new Piece(Symbol.TEST0, Color.WHITE);
        Piece test1 = new Piece(Symbol.TEST1, Color.WHITE);

        BishopMoveGenerator bishopMoveGenerator = new BishopMoveGenerator(board);
        
        int pos = 36;
        board.setPiece(pos, blackPiece);
        board.setPiece(54, whitePiece);
        board.setPiece(pos - 18, blackPiece);

        System.out.println("\n AVANT");
        System.out.println(board.toString());
        System.out.println("\n APRES");

        List<Move> possibleMoves = bishopMoveGenerator.getPossibleMoves(54, Color.WHITE);

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
