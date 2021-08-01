package js.chess.move;

import java.util.List;

public interface MoveGenerator {
    public List<Move> getPossibleMoves();
}
