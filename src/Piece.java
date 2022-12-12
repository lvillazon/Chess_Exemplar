public class Piece {
    private int row;
    private int column;
    private boolean isBlack;
    protected char symbol;

    public Piece(int row, int column, boolean isBlack) {
        this.row = row;
        this.column = column;
        this.isBlack = isBlack;
        symbol = 'x';  // dummy symbol - shouldn't ever appear on the board
    }

    public Piece(String position, boolean isBlack) {
        this.isBlack = isBlack;
        symbol = 'x';
        row = ChessUtils.getRowFromPosition(position);
        column = ChessUtils.getColumnFromPosition(position);
    }


    public char getSymbol() {
        if (isBlack) {
            return Character.toUpperCase(symbol);
        }
        return Character.toLowerCase(symbol);
    }

    // convert row and column values to chess notation eg 0,0 -> A1
    public String getPosition() {
        return ChessUtils.columnToLetter(column) + ChessUtils.rowToNumber(row);
    }

    // update the row and column values to a new chess position
    public void setPosition(String position) {
        row = ChessUtils.getRowFromPosition(position);
        column = ChessUtils.getColumnFromPosition(position);
    }

    public boolean isValidMove(String targetPosition) {
        // staying on the same spot is always illegal for any piece
        if (targetPosition.equals(getPosition())) {
            return false;
        }
        return true;
    }
}

