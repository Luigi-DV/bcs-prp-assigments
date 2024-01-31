package RPSLO;

import java.util.Random;
import java.util.Scanner;

public class RPSLO {
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

    private static final String INVALID_MOVE = "Invalid input (valid inputs: R, P, S, L, O)";
    private static final String ROCK = "R";
    private static final String PAPER = "P";
    private static final String SCISSORS = "S";
    private static final String LIZARD = "L";
    private static final String SPOCK = "O";
    private static final String[] PLAYS = {ROCK, PAPER, SCISSORS, SPOCK};


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
     * The computerPlay method generates a random move for the computer
     *
     * @return The machine string of the machine movement
     */
    public static String computerMove() {
        int randomKeyPlay = new Random().nextInt(PLAYS.length);
        return PLAYS[randomKeyPlay];
    }

    /**
     * The checkGame method validates if the user wins again machine
     *
     * @param userInput        The user move (string)
     * @param computerMovement The machine move (string)
     */
    public static void checkMatch(String userInput, String computerMovement) {
        String computerMoveMessage = String.format("Computer play is %s", computerMovement);
        switch (userInput) {
            case ROCK: {
                int result = checkRock(computerMovement);
                System.out.println(computerMoveMessage);
                checkResult(result);
            }
            ;
            break;
            case PAPER: {
                int result = checkPaper(computerMovement);
                System.out.println(computerMoveMessage);
                checkResult(result);
            }
            ;
            break;
            case SCISSORS: {
                int result = checkScissor(computerMovement);
                System.out.println(computerMoveMessage);
                checkResult(result);
            }
            ;
            break;
            case LIZARD: {
                int result = checkLizard(computerMovement);
                System.out.println(computerMoveMessage);
                checkResult(result);
            }
            ;
            break;
            case SPOCK: {
                int result = checkSpock(computerMovement);
                System.out.println(computerMoveMessage);
                checkResult(result);
            }
            ;
            break;
            default: {
                System.out.println(INVALID_MOVE);
            }
        }
    }

    /**
     * The checkResult method validates the result obtained in the match
     *
     * @param result The result of the match (integer)
     */
    public static void checkResult(int result) {
        switch (result) {
            // User lose the game
            case 0:
                System.out.println("Computer wins!");
                break;
            // User win the game
            case 1:
                System.out.println("You win!");
                break;
            // User draw with machine
            case -1:
                System.out.println("It is a tie!");
                break;
        }
    }

    /**
     * The checkRock method will return 1 (win) when play against SCISSORS & LIZARD
     *
     * @param computerMovement The Machine input (string)
     * @return The Result of the move comparing Rock with all possibilities
     */
    public static int checkRock(String computerMovement) {
        switch (computerMovement) {
            case ROCK:
                return -1;
            case SCISSORS:
                return 1;
            case PAPER:
                return 0;
            case LIZARD:
                return 1;
            case SPOCK:
                return 0;
            default:
                return -2;
        }
    }

    /**
     * The checkPaper method will return 1 (win) when play against ROCK & SPOCK
     *
     * @param computerMovement The Machine input (string)
     * @return The Result of the move comparing Rock with all possibilities
     */
    public static int checkPaper(String computerMovement) {
        switch (computerMovement) {
            case ROCK:
                return 1;
            case SCISSORS:
                return 0;
            case PAPER:
                return -1;
            case LIZARD:
                return 0;
            case SPOCK:
                return 1;
            default:
                return -2;
        }
    }

    /**
     * The checkScissor method will return 1 (win) when play against PAPER & LIZARD
     *
     * @param computerMovement The Machine input (string)
     * @return The Result of the move comparing Rock with all possibilities
     */
    public static int checkScissor(String computerMovement) {
        switch (computerMovement) {
            case ROCK:
                return 0;
            case SCISSORS:
                return -1;
            case PAPER:
                return 1;
            case LIZARD:
                return 1;
            case SPOCK:
                return 0;
            default:
                return -2;
        }
    }

    /**
     * The checkLizard method will return 1 (win) when play against PAPER & SPOCK
     *
     * @param computerMovement The Machine input (string)
     * @return The Result of the move comparing Rock with all possibilities
     */
    public static int checkLizard(String computerMovement) {
        switch (computerMovement) {
            case ROCK:
                return 0;
            case SCISSORS:
                return 0;
            case PAPER:
                return 1;
            case LIZARD:
                return -1;
            case SPOCK:
                return 1;
            default:
                return -2;
        }
    }

    /**
     * The checkSpock method will return 1 (win) when play against ROCK & SCISSORS
     *
     * @param computerMovement The Machine input (string)
     * @return The Result of the move comparing Rock with all possibilities
     */
    public static int checkSpock(String computerMovement) {
        switch (computerMovement) {
            case ROCK:
                return 1;
            case SCISSORS:
                return 1;
            case PAPER:
                return 0;
            case LIZARD:
                return 0;
            case SPOCK:
                return -1;
            default:
                return -2;
        }
    }
}
