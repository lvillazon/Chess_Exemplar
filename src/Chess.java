import java.util.Scanner;

public class Chess {
    private Piece[][] board;

    // set up the board for the start of the game
    public Chess() {
        board = new Piece[8][8];
        // create the pawns TODO: replace with actual pawns, not generic Piece objects
        for (int c=0; c<8; c++) {
            board[1][c] = new Piece(1, c, false);
            board[6][c] = new Piece(6, c, true);
        }
        // place Rooks
        board[0][0] = new Rook("A1", false);
        board[0][7] = new Rook("H1", false);
        board[7][0] = new Rook("A8", true);
        board[7][7] = new Rook("H8", true);
        // place Knights
        board[0][1] = new Knight("B1", false);
        board[0][6] = new Knight("G1", false);
        board[7][1] = new Knight("B8", true);
        board[7][6] = new Knight("G8", true);
        // place Kings
        board[0][4] = new King("E1", false);
        board[7][3] = new King("D8", true);
    }

    // print the current board layout
    public void display() {
        System.out.println("  A B C D E F G H");
        for (int r=0; r<8; r++) {
            System.out.print(r+1+" ");  // start each row with the row number
            for (int c=0; c<8; c++) {
                if (board[r][c] != null) {
                    System.out.print(board[r][c].getSymbol() + " ");
                } else {
                    System.out.print("  ");  // blank square
                }
            }
            System.out.println(r+1+" ");  // add row numbers and start a new row
        }
        System.out.println("  A B C D E F G H");
    }

    // takes chess coords eg A8 and returns the piece at that loc or null
    public Piece getPieceAt(String position) {
        int row = ChessUtils.getRowFromPosition(position);
        int column = ChessUtils.getColumnFromPosition(position);
        return board[row][column];
    }

    public void setPieceAt(String position, Piece p) {
        int row = ChessUtils.getRowFromPosition(position);
        int column = ChessUtils.getColumnFromPosition(position);
        board[row][column] = p;
    }

    // take input from the user for a chess move and validate
    public void move() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the piece to move:");
        String startPosition = input.nextLine().toUpperCase();
        System.out.print("Enter the square to move to:");
        String endPosition = input.nextLine().toUpperCase();
        Piece toMove = getPieceAt(startPosition);
        boolean validMove = false;
        if (toMove != null) {
            validMove = toMove.isValidMove(endPosition);
        }
        if (validMove) {
            System.out.println(toMove.getSymbol() + " moves to " + endPosition);
            setPieceAt(startPosition, null);
            setPieceAt(endPosition, toMove);
            toMove.setPosition(endPosition);
        } else {
            System.out.println("You can't do that!");
        }
    }
}

