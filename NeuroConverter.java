import java.util.Scanner;

public class NeuroConverter {

    private static final int FORTY_NINE_CENTS_VALUE = 49;
    private static final int NINE_CENTS_VALUE = 9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your amount?:");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        converter(amount);
        // scanner.close() to avoid have memory leak
    }
    public static void converter(double amount) {
        int amountInCents = convertToCents(amount);
        int fortyNineCoins = amountInCents / FORTY_NINE_CENTS_VALUE;
        System.out.println(fortyNineCoins);
        int nineCoins = (amountInCents % FORTY_NINE_CENTS_VALUE) / NINE_CENTS_VALUE;
        System.out.println(nineCoins);
        int oneCoins = (amountInCents % FORTY_NINE_CENTS_VALUE) % NINE_CENTS_VALUE;
        System.out.println(oneCoins);
    }

    public static int convertToCents(double value) {
        int intPart = (int) value;
        System.out.println(intPart);
        return (int) Math.round((value - intPart) * 100);
    }
}
