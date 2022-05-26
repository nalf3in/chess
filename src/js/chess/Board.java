package js.chess;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Square> squares;

    public Board() {
        squares = new ArrayList<>(64);

        for(int i = 0; i < 64; i++) 
            squares.add(new Square());
    }

    public Board(List<Square> squares) {
        this.squares = squares;
    }

    public void setSquares(List<Square> squares) {
        this.squares = squares;
    }

    public List<Square> getSquares() {
        return this.squares;
    }

    public void setPiece(int index, Piece piece) { 
        squares.get(index).setPiece(piece);
    }

    public void reset() {
        squares.clear();

        for(int i = 0; i < 64; i++) 
            squares.add(new Square());
    }

    // Convert the algebraic notation to our implementation specific square
    public int coordsToInt(String coords) {
        if (coords.length() != 2) {
            throw new IllegalArgumentException("The entered coord is invalid (more than 2 chars)");
        }

        List<Character> letters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'));
        List<Character> numbers = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8'));

        int line = letters.indexOf(coords.charAt(0));
        int column = numbers.indexOf(coords.charAt(1));

        if (line == -1 || column == -1) {
            throw new IllegalArgumentException("The entered coord is invalid");
        }

        return line + 8 * line;
    }

    @Override
    public String toString() {
        String line = "   +-+-+-+-+-+-+-+-+";
        String letterLine = "    a b c d e f g h ";
        String nl = System.getProperty("line.separator");

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0) {
                stringBuilder.append(nl);
                stringBuilder.append(line);
                stringBuilder.append(nl);
                stringBuilder.append(8 - (i / 8));
                stringBuilder.append("  ");
                stringBuilder.append("|");
            }
            stringBuilder.append(squares.get(i).toString());
            stringBuilder.append("|");
        }

        stringBuilder.append(nl);
        stringBuilder.append(nl);
        stringBuilder.append(letterLine);

        return stringBuilder.toString();
    }
}
