public class King extends Piece {
    private boolean inCheck;

    public King(String position, boolean isBlack) {
        super(position, isBlack);
        symbol = 'k';
        inCheck = false;
    }

    // Kings can move in 1 square in any direction
    public boolean isValidMove(String targetPosition) {
        // add code here
    }
}

