import java.util.Scanner;

public class ChessGame {

    /**
     *  2D array to represent chessboard
     *  -------------------------------
     *  Capital letters represent white pieces
     *  R = Rook, N = Knight, B = Bishop, Q = Queen, K = King, P = Pawn
     *  -------------------------------
     *  Lowercase letters represent black pieces
     *  r = Rook, n = Knight, b = Bishop, q = Queen, k = King, p = Pawn
     */
    static char[][] chessboard = {
            {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'},
            {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'}
    };

    /**
     * This method displays the chessboard
     */
    static void displayChessboard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(chessboard[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * This method moves a piece from one position to another
     * @param startX The starting X position
     * @param startY The starting Y position
     * @param endX The ending X position
     * @param endY The ending Y position
     */
    static void movePiece(int startX, int startY, int endX, int endY) {
        char piece = chessboard[startX][startY];
        chessboard[startX][startY] = ' ';
        chessboard[endX][endY] = piece;
    }

    // זכור ליישם את תנועת השחמט על ידי החלפת הלוגיקה :) לכל יחיד

    /**
     * This method checks which piece was selected
     * @param startX The starting X position
     * @param startY The starting Y position
     */
    static void checkSelectedPiece(int startX, int startY) {
        char piece = chessboard[startX][startY];
        switch (piece) {
            case 'R' -> System.out.println("You selected a Rook");
            case 'N' -> System.out.println("You selected a Knight");
            case 'B' -> System.out.println("You selected a Bishop");
            case 'Q' -> System.out.println("You selected a Queen");
            case 'K' -> System.out.println("You selected a King");
            case 'P' -> System.out.println("You selected a Pawn");
            default -> System.out.println("You selected an empty space");
        }
    }

    /**
     * This is the main method that will be used to test the code in CodeGrade
     * @param args Arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example: Moving a pawn from (6, 4) to (4, 4)
        System.out.println("Initial Chessboard:");
        displayChessboard();

        // Ask user to choose a piece to move
        System.out.println("\nChoosing a piece to move ...");
        System.out.println();
        // Get user input
        System.out.println("Enter the x coordinate of the piece you want to move:");
        int startX = scanner.nextInt();
        System.out.println("Enter the y coordinate of the piece you want to move:");
        int startY = scanner.nextInt();

        // Check selected piece
        checkSelectedPiece(startX, startY);

        // Ask user to choose a position to move the piece to
        System.out.println("\nChoosing a position to move the piece to ...");
        System.out.println();
        // Get user input
        System.out.println("Enter the x coordinate of the position you want to move the piece to:");
        int endX = scanner.nextInt();
        System.out.println("Enter the y coordinate of the position you want to move the piece to:");
        int endY = scanner.nextInt();

        // Move the piece
        movePiece(startX, startY, endX, endY);

        // Display the chessboard after the move
        System.out.println("\nChessboard After Move:");
        displayChessboard();

        scanner.close();
    }
}
