public class Rook extends Piece{
    public Rook(String position, boolean isBlack) {
        super(position, isBlack);
        symbol = 'R';
    }

    // Rooks can move any amount horizontally or vertically but not both at once
    public boolean isValidMove(String targetPosition) {
        // check parent rules
        if (!super.isValidMove(targetPosition)) {
            return false;
        }
        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startCol = ChessUtils.getColumnFromPosition(getPosition());
        int endRow = ChessUtils.getRowFromPosition(targetPosition);
        int endCol = ChessUtils.getColumnFromPosition(targetPosition);
        if ((startRow == endRow) || (startCol == endCol)) {
            return true;
        }
        // all other moves are illegal
        return false;
    }

    // TODO
    // return an array of all positions the piece moves through, excluding the final position
    // this is used to check if a piece illegally moves through another piece
    public String[] passesThrough(String targetPosition) {
        int startRow = ChessUtils.getRowFromPosition(getPosition());
        int startCol = ChessUtils.getColumnFromPosition(getPosition());
        int endRow = ChessUtils.getRowFromPosition(targetPosition);
        int endCol = ChessUtils.getColumnFromPosition(targetPosition);
        String squares[] = new String[8];  // no piece can pass through more than 8 squares
        // check if we are moving horizontally or vertically
        // add the coordinates of each square along the row or column to the array
        // excluding the start and end square
        return squares;
    }

}
