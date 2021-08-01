package js.chess.move;

public class Move {
    private int from;
    private int to; 
    private MoveType moveType;

    public Move(int from, int to, MoveType moveType) {
        this.from = from;
        this.to = to;
        this.moveType = moveType;
    }

    public boolean isCapture() {
        return moveType == MoveType.CAPTURES ||
            moveType == MoveType.EP_CAPTURE ||
            moveType == MoveType.KNIGHT_PROMO_CAPTURE || 
            moveType == MoveType.BISHOP_PROMO_CAPTURE || 
            moveType == MoveType.ROOK_PROMO_CAPTURE || 
            moveType == MoveType.QUEEN_PROMO_CAPTURE;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }
    public int getTo() {
        return to;
    }
    public void setTo(int to) {
        this.to = to;
    }
    public MoveType getMoveType() {
        return moveType;
    }
    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }
}
