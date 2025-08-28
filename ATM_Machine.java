import java.util.*;

public class ATM_Machine {

    private static int pin = 1234;
    private static double balance = 1000;
    private static String holderName = "xyz";
    private static String address = "#632";
    private static int age = 34;
    private static Scanner sc = new Scanner(System.in); // Global Scanner to prevent resource leak

    static void customerDetails() {
        System.out.println("\n--- Customer Details ---");
        System.out.println("User Name    : " + holderName);
        System.out.println("User Age     : " + age);
        System.out.println("User Balance : " + balance);
        System.out.println("User Location: " + address);
        System.out.println("User PIN     : " + pin);
    }

    static void withdraw() {
        System.out.print("\nEnter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount Successfully Withdrawn!");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            System.out.println("Invalid Amount Entered!");
        }
    }

    static void deposit() {
        System.out.print("\nEnter amount to deposit: ");
        double amount = sc.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Successfully Deposited!");
        } else {
            System.out.println("Invalid Amount Entered!");
        }
    }

    static void modifyDetails() {
        int choice;
        do {
            System.out.println("\n--- Modify Customer Details ---");
            System.out.println("1. Name\n2. PIN\n3. Location\n4. Age\n5. Exit");
            System.out.print("Enter Your Choice (1-5): ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter New Name: ");
                    holderName = sc.nextLine();
                    System.out.println("Name Updated Successfully!");
                    break;
                case 2:
                    System.out.print("Enter New PIN: ");
                    pin = sc.nextInt();
                    System.out.println("PIN Updated Successfully!");
                    break;
                case 3:
                    System.out.print("Enter New Location: ");
                    address = sc.nextLine();
                    System.out.println("Location Updated Successfully!");
                    break;
                case 4:
                    System.out.print("Enter Updated Age: ");
                    age = sc.nextInt();
                    System.out.println("Age Updated Successfully!");
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid Choice! Try Again.");
            }
        } while (choice != 5);
    }

    static void atm_operations() {
        int choice;
        do {
            System.out.println("\n--- ATM Operations ---");
            System.out.println("1. Customer Details\n2. Withdraw\n3. Deposit\n4. Modify Customer Details\n5. Quit");
            System.out.print("Enter Your Choice (1-5): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    customerDetails();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    modifyDetails();
                    break;
                case 5:
                    System.out.println("\n\t\t\t\t\t\t<<-- THANK YOU for Using This ATM -->>");
                    break;
                default:
                    System.out.println("Invalid Choice! Try Again.");
            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        System.out.println("\n\t\t\t\t\t\t<<-- WELCOME TO ATM MACHINE -->>\n");

        int attempts = 3;
        boolean accessGranted = false;

        while (!accessGranted && attempts > 0) {
            System.out.print("Enter the 4-digit PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredPin == pin) {
                accessGranted = true;
                System.out.println("\nCorrect PIN! Access Granted.\n");
                atm_operations();
            } else {
                attempts--;
                if (attempts > 0) {
                    System.out.println("Incorrect PIN! Try again. " + attempts + " attempts left.\n");
                } else {
                    System.out.println("\nYou have exceeded your attempts. YOUR ACCOUNT HAS BEEN LOCKED!");
                }
            }
        }

        sc.close(); // Close scanner
    }
}


