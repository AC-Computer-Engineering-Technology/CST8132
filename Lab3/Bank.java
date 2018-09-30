
/*
 * Name: Angela Giddings // ensure you use YOUR name
 * Student ID: 0123456789 // ensure you use YOUR student ID number
 * Course & Section: CST8132 304 // ensure you use YOUR lab section number * Assignment: Lab 3
 * Date: Sept 28, 2018 // can be due date or submission date
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Bank {
    public String bankName;
    public Account[] accounts;
    private Scanner input;

    public Bank() {
        this.input = new Scanner(System.in);
        System.out.print("Enter your bank name: ");
        this.bankName = this.input.nextLine();
        System.out.print("Enter the number of accounts: ");
        boolean control = true;
        String numberOfAccounts = this.input.next();
        int index = 0;
        while (control) {
            try {
                index = Integer.parseInt(numberOfAccounts);
                control = false;
            } catch (Exception e) {
                System.out.println("Invalid integer index. Try again ");
                System.out.print("Enter the number of accounts: ");
                numberOfAccounts = this.input.next();
            }
        }

        this.accounts = new Account[index];

        for (int i = 0; i < this.accounts.length; i++) {
            System.out.println("-------------");
            System.out.printf("   Client %d  \n", i + 1);
            System.out.println("-------------");

            System.out.print("Enter client's first name: ");
            String firstName = this.input.next();
            System.out.print("Enter client's last name: ");
            String lastName = this.input.next();
            System.out.print("Enter client's phone number: ");
            long phoneNum = this.input.nextLong();
            System.out.print("Enter client's email address: ");
            String email = this.input.next().toLowerCase();
            boolean isValidEmail = email.contains("@") && email.lastIndexOf(".") != -1;
            while (!isValidEmail) {
                System.out.println("Invalid email address. Try again");
                System.out.print("Enter client's email address: ");
                email = this.input.next().toLowerCase();
                isValidEmail = email.contains("@") && email.lastIndexOf(".") != -1;
            }

            Client client = new Client(firstName, lastName, phoneNum, email);
            System.out.print("Enter client's opening balance: ");
            double balance = this.input.nextDouble();
            this.accounts[i] = new Account(client, balance);
            System.out.print("\n");
        }
    }

    public void printAccounts() {
        DecimalFormat output = new DecimalFormat("##.##");
        for (int i = 0; i < this.accounts.length; i++) {
            String name = this.accounts[i].getName();
            String email = this.accounts[i].getClient().getEmail();
            long phoneNum = this.accounts[i].getClient().getPhoneNum();
            double balance = this.accounts[i].getBalance();
            String formatedBalance = output.format(balance);
            System.out.printf("Index: %d, Name: %s, Balance: %s, email: %s, Phone Number: %d \n", i, name,
                    formatedBalance, email, phoneNum);
        }
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();
        System.out.println("---------------------");
        System.out.printf("    %s \n", bank.bankName);
        System.out.println("---------------------");
        boolean exec = true;

        while (exec) {
            System.out.println("\nValid Options: P or p, W or w, D or d, Q or q ");
            System.out.print("Enter a valid option: ");
            String option = input.next().toLowerCase();
            int index = -1;
            double amount = 0.0;
            boolean control = true;
            String indexString = "";

            switch (option) {
            case "p":
                bank.printAccounts();
                break;
            case "w":
                DecimalFormat output = new DecimalFormat("##.##");
                System.out.print("Enter index of account: ");
                indexString = input.next();
                while (control) {
                    try {
                        index = Integer.parseInt(indexString);
                        control = false;
                    } catch (Exception e) {
                        System.out.println("Invalid integer index. Try again ");
                        System.out.print("Enter index of account: ");
                        indexString = input.next();
                    }
                }
                System.out.print("Enter amount to withdraw: ");
                amount = input.nextDouble();
                boolean canWithdraw = bank.accounts[index].withdraw(amount);
                if (!canWithdraw) {
                    System.out.printf("Insufficient Funds! Balance is $%s \n", output.format(bank.accounts[index].getBalance()));
                }
                break;
            case "d":
                System.out.print("Enter index of account: ");
                indexString = input.next();
                while (control) {
                    try {
                        index = Integer.parseInt(indexString);
                        control = false;
                    } catch (Exception e) {
                        System.out.println("Invalid integer index. Try again ");
                        System.out.print("Enter index of account: ");
                        indexString = input.next();
                    }
                }
                System.out.print("Enter amount to deposit: ");
                amount = input.nextDouble();
                bank.accounts[index].deposit(amount);
                break;
            case "q":
                System.out.println("Quiting Program....");
                exec = false;
                break;
            default:
                break;
            }
        }

    }
}