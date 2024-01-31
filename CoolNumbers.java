import java.util.*;

public class CoolNumbers {
    /*
        This week you’ll write an algorithmic approach to what we call “cool” numbers. Given a (non-zero) positive
        integer n, a number is considered “cool” if n is divisible by each of the number’s digits without remainder.
        Some examples follow:
        If n=16, then 2418 is a “cool” number because 16/2=8, 16/4=4, 16/1=16, 16/8=2 (none of these divisions leaves a remainder).
        If n=16, then 489 is not a “cool” number because 16/9=1 and leaves a remainder of 7. Note that the other digits are divisible with no remainder, however recall that we want all of them to be divisible.
        If n=5, then 10000 is not a “cool” number since division by 0 is not possible -you need to take care of that in your program.
        Your program should read three integers n, a and b. Given n, the program will count all possible “cool” numbers between a and b (including a and b).
     */

    /**
     * This is the main method that will be used to test the code in CodeGrade
     * @param args
     */
    public static void main(String[] args) {
        //This is just to test your method
        System.out.println("Number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("From: ");
        int fromNumber = scanner.nextInt();
        System.out.println("To: ");
        int toNumber = scanner.nextInt();
        int coolCounter = countCools(number, fromNumber, toNumber);
        System.out.println("The number of cool numbers between " + fromNumber + " and " + toNumber + " is: " + coolCounter);
    }

    /**
     * This method checks if a number is cool
     * @param number
     * @param n
     * @return
     */
    public static boolean isCool(int number, int n) {
        int temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || n % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }

    /**
     * This method counts the number of cool numbers between a and b
     * @param n
     * @param a
     * @param b
     * @return
     */
    public static int countCools(int n, int a, int b) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (isCool(i, n)) {
                count++;
            }
        }
        return count;
    }
}
