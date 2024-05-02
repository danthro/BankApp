import java.util.*;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    //private Bank bank = new Bank();
    private Teller bank = new Teller("Joe","Doe");

    public void displayMainMenu() {
        System.out.println(bank);
        System.out.println("*********MENU*********");
        System.out.println(" ");
        System.out.println("Please make a selection:");
        System.out.println("1) Access Account");
        System.out.println("2) Open a New Account");
        System.out.println("3) Close All Accounts");
        System.out.println("4) Exit");
        System.out.print(">> ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                accessAccount();
                break;
            case 2:
                openNewAccount();
                break;
            case 3:
                closeAllAccounts();
                break;
            case 4:
                System.out.println("Thank you for using D.L Banking App Goodbye. Exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid input. Please enter a number between 1-4.");
        }
    }

    private void accessAccount() {
        System.out.println("Enter PIN: ");
        System.out.print(" ");
        int pin = scanner.nextInt();
        Customer customer = bank.getCustomerByPin(pin);
        if (customer == null) {
            System.out.println("PIN is invalid.");
            return;
        }
        System.out.println("***Active Accounts***:");
        System.out.println(customer.getAllAccountsInfo());
        System.out.println("Please Enter the account number of the account you would like to access: ");
        System.out.print(" ");
        int accountNumber = scanner.nextInt();
        Account account = customer.getAccountByNumber(accountNumber);
        if (account == null) {
            System.out.println("Account number invalid.");
            return;
        }
        displayAccountMenu(account, pin);
    }

    private void displayAccountMenu(Account account, int pin) {
        while (true) {
            System.out.println("Please make a selection:");
            System.out.println("1. Make a deposit");
            System.out.println("2. Make a withdraw");
            System.out.println("3. See account balance");
            System.out.println("4. Close account");
            System.out.println("5. Exit");
            System.out.print(">> ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter amount to deposit: ");
                    System.out.print(" ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw: ");
                    System.out.print(" ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: $" + account.getBalance());
                    break;
                case 4:
                    int accountNumber = account.getAccountNumber();
                    Customer customer = bank.getCustomerByPin(pin);
                    customer.removeAccount(account);
                    System.out.println("Account number " + accountNumber + " closed.");
                    return;
                case 5:
                    return;
                default:
                    System.out.println("Invalid entry. Please enter a number between 1-5.");
            }
        }
    }

    private void openNewAccount() {
        System.out.println("Are you a new customer?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        System.out.print("");

        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Enter first name: ");
            System.out.print(" ");
            String firstName = scanner.next();
            System.out.println("Enter last name: ");
            System.out.print(" ");
            String lastName = scanner.next();
            System.out.println("Enter PIN: ");
            System.out.print(" ");
            int pin = scanner.nextInt();
            Customer newCustomer = new Customer(firstName, lastName, pin);
            bank.addCustomer(newCustomer);
            System.out.println("Please enter deposit amount: ");
            System.out.print(" ");
            double initialDeposit = scanner.nextDouble();
            Account newAccount = new Account(initialDeposit);
            newCustomer.addAccount(newAccount);
            System.out.println("New Account Opened: " + newAccount.getAccountNumber());
        } else if (choice == 2) {
            System.out.println("Please enter PIN: ");
            System.out.print(" ");
            int pin = scanner.nextInt();
            Customer existingCustomer = bank.getCustomerByPin(pin);
            if (existingCustomer == null) {
                System.out.println("PIN invalid.");
                return;
            }
            System.out.println("Please enter deposit amount: ");
            System.out.print(" ");
            double initialDeposit = scanner.nextDouble();
            Account newAccount = new Account(initialDeposit);
            existingCustomer.addAccount(newAccount);
            System.out.println("New Account Opened: " + newAccount.getAccountNumber());
        } else {
            System.out.println("Invalid input. Please enter 1 for Yes or 2 for No.");
        }
    }

    private void closeAllAccounts() {
        System.out.println("Enter PIN: ");
        System.out.print(" ");
        int pin = scanner.nextInt();
        Customer customer = bank.getCustomerByPin(pin);
        if (customer == null) {
            System.out.println("PIN invalid.");
            return;
        }
        bank.removeCustomer(customer);
        System.out.println("All accounts closed for customer: " + customer.getFirstName() + " " + customer.getLastName());
    }
}
