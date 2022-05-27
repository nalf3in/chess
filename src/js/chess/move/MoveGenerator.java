package js.chess.move;
import java.util.List;
import js.chess.Board;

public interface MoveGenerator {
    public List<Move> getPossibleMoves(int currentPos, Board board);
}
