public class Account {
    private double balance;
    private int accountNumber;
    private static int numberOfAccounts = 999;

    public Account(double initialDeposit) {
        this.balance = initialDeposit;
        this.accountNumber = ++numberOfAccounts;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Amount deposited: $" + amount);
        System.out.println("Updated balance: $" + this.balance);
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("You have insufficient funds.");
        } else {
            this.balance -= amount;
            System.out.println("Amount withdrawn: $" + amount);
            System.out.println("Updated balance: $" + this.balance);
        }
    }

    public String toString() {
        return "Account number: " + this.accountNumber + "\nBalance: $" + this.balance + "\n";
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}