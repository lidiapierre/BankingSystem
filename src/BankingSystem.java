public class BankingSystem implements BankingSystemInterface {

    public void postTransaction(String transaction, String accountType, double amount) {

        if (accountType.equals("c")) {
            ca.processTransaction(transaction, amount);
        } else if (accountType.equals("s")) {
            sa.processTransaction(transaction, amount);
        } else {
            System.out.println("Invalid banking account type.");
        }
    }

    public void displayBalances(String title) {
        System.out.println(title);
        System.out.println(ca.displayBalance());
        System.out.println(sa.displayBalance());
    }

    public void processFeesAndPayments() {
        System.out.println("\nMonthly Payments and Fees");
        ca.chargeBankingFee();
        sa.getInterestPayment();
    }
}
