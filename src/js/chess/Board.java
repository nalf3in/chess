package js.chess;
import java.util.ArrayList;
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
