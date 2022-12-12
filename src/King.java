public class King extends Piece {
    private boolean inCheck;

    public King(String position, boolean isBlack) {
        super(position, isBlack);
        symbol = 'k';
        inCheck = false;
    }

    // Kings can move in 1 square in any direction
    public boolean isValidMove(String targetPosition) {
        // staying on the same spot is illegal
        if (targetPosition.equals(getPosition())) {
            return false;
        }
        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startCol = ChessUtils.getColumnFromPosition(getPosition());
        int endRow = ChessUtils.getRowFromPosition(targetPosition);
        int endCol = ChessUtils.getColumnFromPosition(targetPosition);
        // moving more than 1 square in any direction is illegal
        if ((Math.abs(startRow-endRow)>1) || (Math.abs(startCol-endCol)>1)) {
            return false;
        }
        // anything else goes!
        return true;
    }
}

