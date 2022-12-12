public class Knight extends Piece {
    public Knight(String position, boolean isBlack) {
        super(position, isBlack);
        symbol = 'n';
    }

    // Knights can move 2 horizontally and 1 vertically or 1 horizontall and 2 vertically
    public boolean isValidMove(String targetPosition) {
        // check parent rules
        if (!super.isValidMove(targetPosition)) {
            return false;
        }
        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startCol = ChessUtils.getColumnFromPosition(getPosition());
        int endRow = ChessUtils.getRowFromPosition(targetPosition);
        int endCol = ChessUtils.getColumnFromPosition(targetPosition);
        if (((Math.abs(startRow-endRow)==2) && (Math.abs(startCol-endCol)==1)) ||
            ((Math.abs(startRow-endRow)==1) && (Math.abs(startCol-endCol)==2))) {
            return true;
        }
        // all other moves are illegal
        return false;
    }

}
