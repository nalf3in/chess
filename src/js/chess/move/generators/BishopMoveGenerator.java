package js.chess.move.generators;

import java.util.List;

import js.chess.Board;
import js.chess.Color;
import js.chess.move.Move;
import js.chess.move.MoveGenerator;

public class BishopMoveGenerator implements MoveGenerator{
    
    private Board board;

    private int[] offsets = {
        -9, -7, 7, 9,
        -10, -8, 8, 10,
        -11, -9, 9, 11,
        -12, -10, 10, 12,
        -13, -11, 11, 13,
        -14, -12, 12, 14,
        -15 , -13, 13, 15
    };
    
    public BishopMoveGenerator(Board board) {
        this.board = board;
    }

    @Override
    public List<Move> getPossibleMoves(int currentPos, Color color) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
