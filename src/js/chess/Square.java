package js.chess;
import java.util.Optional;

// TODO ajouter la couleur ?
public class Square {
    private Optional<Piece> piece;

    public Square() {
        this.piece = Optional.empty();
    }

    public Square(Piece piece) {
        this.piece = Optional.of(piece);
    }
    
    public Optional<Piece> getPiece () {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = Optional.of(piece);
    }

    public void removePiece() {
        this.piece = Optional.empty();
    }

    public boolean isEmpty(){
        return !piece.isPresent();
    }

    @Override
    public String toString() {
        String toReturn = " ";

        if(piece.isPresent()) 
            toReturn = piece.get().getSymbol();

        return toReturn;
    }
}
