package js.chess.move;

import java.util.List;

import js.chess.Color;

public interface MoveGenerator {
    public List<Move> getPossibleMoves(int currentPos, Color color);
}
