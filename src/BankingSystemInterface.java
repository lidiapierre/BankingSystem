interface BankingSystemInterface {
    double startingDeposit = 1000;
    double bankingFee = 1;
    double interestRate = 1;

    CheckingAccount ca = new CheckingAccount(startingDeposit, bankingFee);
    SavingsAccount sa = new SavingsAccount(startingDeposit, interestRate);

    void postTransaction(String transaction, String accountType, double amount);

    void displayBalances(String title);

    void processFeesAndPayments();
}
