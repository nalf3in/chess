package js.chess;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Board board = new Board();
        List<Square> squares = board.getSquares();

        for(int i = 0; i < 64; i++) {
            squares.get(i).setPiece(new Piece(i % 10 + "", Color.WHITE, i));
        }

        System.out.println(board.toString());
    }
}
