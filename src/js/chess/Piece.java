package js.chess;
public class Piece {
    private String symbol;
    private Color color;

    public Piece(String symbol, Color color) {
        this.symbol = symbol;
        this.color = color;
    }

    public String getSymbol() {
        return this.symbol;
    }
    
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}
