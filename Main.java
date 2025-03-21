import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Bank Management System ===");

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Login to Account");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount(bank, scanner);
                    break;
                case 2:
                    login(bank, scanner);
                    break;
                case 3:
                    System.out.println("Thank you for using our service. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Create a new account
    private static void createAccount(Bank bank, Scanner scanner) {
        System.out.print("Enter your name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        
        System.out.print("Enter initial balance: ₹");
        double initialBalance = scanner.nextDouble();
        
        System.out.print("Set your 4-digit PIN: ");
        String pin = scanner.next();
        
        int accountNumber = bank.createAccount(name, initialBalance, pin);
        System.out.println("Account created successfully! Your account number is: " + accountNumber);
    }

    // Login to account
    private static void login(Bank bank, Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        
        System.out.print("Enter PIN: ");
        String pin = scanner.next();
        
        User user = bank.authenticate(accountNumber, pin);
        
        if (user != null) {
            System.out.println("Login successful! Welcome, " + user.getAccountNumber());
            userMenu(user, scanner);
        } else {
            System.out.println("Invalid account number or PIN. Please try again.");
        }
    }

    // User account operations
    private static void userMenu(User user, Scanner scanner) {
        while (true) {
            System.out.println("\n1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    user.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    user.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Your current balance is: ₹" + user.getBalance());
                    break;
                case 4:
                    System.out.println("Transaction History:");
                    for (String transaction : user.getTransactionHistory()) {
                        System.out.println(transaction);
                    }
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
