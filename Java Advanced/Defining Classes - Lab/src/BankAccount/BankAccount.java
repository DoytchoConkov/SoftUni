package BankAccount;

public class BankAccount {
    private static double interest = 0.02;
    private static int bankAccounCounter = 1;
    private int id;
    private double balance;

    public BankAccount() {
        this.id = bankAccounCounter++;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interest = interest;
    }

    public double getInterest(int years) {
        return this.balance * years * BankAccount.interest ;
    }

    public void deposit(double amount) {
        this.balance = amount;
    }

    public int getId() {
        return this.id;
    }
}
