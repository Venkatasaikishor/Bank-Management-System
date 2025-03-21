import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, User> accounts = new HashMap<>();
    private int nextAccountNumber = 1001;

    // Create new account
    public int createAccount(String name, double initialBalance, String pin) {
        User user = new User(name, nextAccountNumber, initialBalance, pin);
        accounts.put(nextAccountNumber, user);
        return nextAccountNumber++;
    }

    // Authenticate user
    public User authenticate(int accountNumber, String pin) {
        if (accounts.containsKey(accountNumber)) {
            User user = accounts.get(accountNumber);
            if (user.validatePin(pin)) {
                return user;
            }
        }
        return null;
    }

    // Get account by account number
    public User getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }
}
