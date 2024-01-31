package RPSLO;


import java.util.Random;
import java.util.Scanner;

public class RPSLOv2 {
    // Table array for results: [userMove][computerMove]

    // Rock = 0, Paper = 1, Scissors = 2, Lizard = 3, Spock = 4
    // Scissors cut Paper
    // Paper covers Rock
    // Rock crushes Lizard
    // Lizard poisons Spock
    // Spock smashes Scissors
    // Scissors decapitate Lizard
    // Lizard eats Paper
    // Paper disproves Spock
    // Spock vaporizes Rock
    // Rock crushes Scissors

    private static final int[][] RESULTS = {
            // Rock, Paper, Scissors, Lizard, Spock
            {0, -1, 1, 1, -1},   // Rock
            {1, 0, -1, 0, 1},    // Paper
            {-1, 1, 0, 1, -1},   // Scissors
            {-1, 0, -1, 0, 1},   // Lizard
            {1, -1, 1, -1, 0}    // Spock
    };

    private static final String INVALID_MOVE = "Invalid input (valid inputs: R, P, S, L, O)";
    private static final String[] MOVES = {"R", "P", "S", "L", "O"};

    public static void main(String[] args) {
        System.out.println("Enter your play: R, P, S, L, O");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next().toUpperCase();
        // Generates the computer movement
        String computerMovement = computerMove();
        // Match Starts
        checkMatch(userInput, computerMovement);
    }

    /**
     * Generates a random move for the computer
     *
     * @return The string representation of the computer's move
     */
    public static String computerMove() {
        int randomKeyPlay = new Random().nextInt(MOVES.length);
        return MOVES[randomKeyPlay];
    }

    /**
     * Validates if the user wins against the computer
     *
     * @param userInput         The user move (string)
     * @param computerMovement The computer move (string)
     */
    public static void checkMatch(String userInput, String computerMovement) {
        int userIndex = getIndex(userInput);
        int computerIndex = getIndex(computerMovement);

        if (userIndex == -1 || computerIndex == -1) {
            System.out.println(INVALID_MOVE);
            return;
        }

        String computerMoveMessage = String.format("Computer play is %s", computerMovement);
        int result = RESULTS[userIndex][computerIndex];

        System.out.println(computerMoveMessage);
        checkResult(result);
    }

    /**
     * Returns the index of a move in the MOVES array
     *
     * @param move The move to find the index for
     * @return The index of the move, or -1 if the move is invalid
     */
    public static int getIndex(String move) {
        for (int i = 0; i < MOVES.length; i++) {
            if (MOVES[i].equals(move)) {
                return i;
            }
        }
        return -1; // Invalid move
    }

    /**
     * Validates the result obtained in the match
     * @param result The result of the match (integer)
     */
    public static void checkResult(int result) {
        // Enhanced switch statement only available in Java 14+
        switch (result) {
            // User loses the game
            case 0 -> System.out.println("Computer wins!");

            // User wins the game
            case 1 -> System.out.println("You win!");

            // It's a tie
            case -1 -> System.out.println("It is a tie!");
        }
    }

    /**
     * The checkOldResult method validates the result obtained in the match
     * @param result The result of the match (integer)
     */
    public static void checkOldResult(int result) {
        switch (result) {
            // User loses the game
            case 0:
                System.out.println("Computer wins!");
                break;

            // User wins the game
            case 1:
                System.out.println("You win!");
                break;

            // It's a tie
            case -1:
                System.out.println("It is a tie!");
                break;
        }
    }

}
