import java.util.Scanner;

public class BankingApp {

    private static Scanner sc = new Scanner(System.in);
    private static String answer = "y";

    private static BankingSystemInterface bs = new BankingSystem();

    public static void main(String[] args) {
        String transaction;
        String type;
        double amount;

        System.out.println("Welcome to the Account application.");

        bs.displayBalances("\nStarting Balances");

        System.out.println("\nEnter the transactions for the month");

        while (answer.equalsIgnoreCase("y")) {

            transaction = Validator.getAnswer(sc, "\nWithdrawal or deposit", "w", "d");
            type = Validator.getAnswer(sc, "Checking or savings", "c", "s");
            amount = Validator.getAmount(sc);

            bs.postTransaction(transaction, type, amount);

            answer = Validator.getAnswer(sc, "\nContinue", "y", "n");
        }

        bs.processFeesAndPayments();
        bs.displayBalances("\nFinal Balances");

    }
}
