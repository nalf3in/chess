package js.chess;
public class Piece {
    private String symbol;
    private Color color;
    private int pos;

    public Piece(String symbol, Color color, int pos) {
        this.symbol = symbol;
        this.color = color;
        this.pos = pos;
    }

    public String getSymbol() {
        return this.symbol;
    }
    
    public Color getColor() {
        return color;
    }

    public int getPos() { 
        return pos;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}
