import java.util.List;

import js.chess.Board;
import js.chess.Color;
import js.chess.Piece;
import js.chess.Square;
import js.chess.Symbol;
import js.chess.move.Move;
import js.chess.move.generators.RookMoveGenerator;


public class TestRookMoveGenerator {
    
    public static void main(String[] args) {
        
        Board board = new Board();
        List<Square> squares = board.getSquares();

        Piece whitePiece0 = new Piece(Symbol.ROOK, Color.WHITE);
        Piece whitePiece1 = new Piece(Symbol.ROOK, Color.WHITE);
        Piece blackPiece = new Piece(Symbol.ROOK, Color.BLACK);
        Piece blackPiece2 = new Piece(Symbol.ROOK, Color.BLACK);

        squares.get(1).setPiece(whitePiece0);
        squares.get(2).setPiece(blackPiece);
        squares.get(17).setPiece(blackPiece2);
        squares.get(33).setPiece(whitePiece1);

        RookMoveGenerator rookMoveGenerator = new RookMoveGenerator(board);
        System.out.println(board.toString());

        List<Move> possibleMoves = rookMoveGenerator.getPossibleMoves(17, Color.BLACK);


        System.out.println(board.toString());
    }
}

