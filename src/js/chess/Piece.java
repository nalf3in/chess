package js.chess;
public class Piece {
    private Symbol symbol;
    private Color color;

    public Piece(Symbol symbol, Color color) {
        this.symbol = symbol;
        this.color = color;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }
    
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.symbol.toString(this.color);
    }
}
