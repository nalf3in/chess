package js.chess;
public enum Symbol {
    PAWN("♙", "♟"),
    ROOK("♖", "♜"),
    KNIGHT("♘", "♞"),
    BISHOP("♗", "♝"),
    QUEEN("♕", "♛"),
    KING("♔", "♚"),

    TEST0("○", "●"),
    TEST1("X", "X");


    private final String whiteUnicodeSymbol;
    private final String blackUnicodeSymbol;

    Symbol(String whiteUnicodeSymbol, String blackUnicodeSymbol) {
        this.whiteUnicodeSymbol = whiteUnicodeSymbol;
        this.blackUnicodeSymbol = blackUnicodeSymbol;
    }

    public String toString(Color color) {
        if (color.equals(Color.BLACK)) {
            return this.blackUnicodeSymbol;
        } else if(color.equals(Color.WHITE)) {
            return this.whiteUnicodeSymbol;
        } else {
            throw new RuntimeException("Trying to display a symbol without a defined color");
        }
    }

    // To prevent accidentally calling the wrong method while developing
    @Override
    public String toString() {
        throw new RuntimeException("The Symbol enum toString() method is not supposed to be called");
    }
}