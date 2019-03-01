import java.text.NumberFormat;

abstract class BankingAccount {
    double balance;
    static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

    BankingAccount (double startingBalance) {
        this.balance = startingBalance;
    }

    BankingAccount () {
        this.balance = 0;
    }

    void processTransaction(String transaction, double amount) {
        if (transaction.equals("w")) {
            withdrawAmount(amount);
        } else if (transaction.equals("d")) {
            depositAmount(amount);
        } else {
            System.out.println("Invalid transaction.");
        }
    }

    void withdrawAmount(double amount) {
        if (amount > this.balance) {
            System.out.println("Overdraft is not allowed, transaction is cancelled.");
        } else {
            this.balance -= amount;
        }
    }

    void depositAmount(double amount) {
        this.balance += amount;
    }

}

class CheckingAccount extends BankingAccount {
    private double monthlyBankingFee;

    CheckingAccount (double startingBalance, double bankingFee) {
        super(startingBalance);
        monthlyBankingFee = bankingFee;
    }

    String displayBalance() {
        return String.format("Checking: %s", currencyFormatter.format(this.balance));
    }

    void chargeBankingFee() {
        System.out.format("Checking fee:\t\t\t\t%s\n", currencyFormatter.format(monthlyBankingFee));
        withdrawAmount(monthlyBankingFee);
    }

}

class SavingsAccount extends BankingAccount {

    private double interestRate;

    SavingsAccount (double startingBalance, double interestRate) {
        super(startingBalance);
        this.interestRate = interestRate;
    }

    String displayBalance() {
        return String.format("Savings: %s", currencyFormatter.format(this.balance));
    }

    void getInterestPayment() {
        double interestPayment = this.balance * this.interestRate / 100;
        System.out.format("Savings interest payment:\t%s\n", currencyFormatter.format(interestPayment));
        depositAmount(interestPayment);
    }
}
