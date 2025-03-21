import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int accountNumber;
    private double balance;
    private String pin;
    private List<String> transactionHistory;

    public User(String name, int accountNumber, double balance, String pin) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: ₹" + balance);
    }

    // Validate PIN for security
    public boolean validatePin(String pin) {
        return this.pin.equals(pin);
    }

    // Deposit money
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: ₹" + amount + " | New balance: ₹" + balance);
        System.out.println("₹" + amount + " deposited successfully. New balance: ₹" + balance);
    }

    // Withdraw money
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: ₹" + amount + " | New balance: ₹" + balance);
            System.out.println("₹" + amount + " withdrawn successfully. Remaining balance: ₹" + balance);
            return true;
        } else {
            System.out.println("Insufficient balance.");
            return false;
        }
    }

    // Check balance
    public double getBalance() {
        return balance;
    }

    // Get account number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Get transaction history
    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}
