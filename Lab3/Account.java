/*
 * Name: Angela Giddings // ensure you use YOUR name
 * Student ID: 0123456789 // ensure you use YOUR student ID number
 * Course & Section: CST8132 304 // ensure you use YOUR lab section number * Assignment: Lab 3
 * Date: Sept 28, 2018 // can be due date or submission date
 */
import java.util.Random;

public class Account {
    private long accountNum;
    private Client client;
    private double balance;

    public Account(Client client, double balance) {
        Random r = new Random();
        this.client = client;
        this.balance = balance;
        this.accountNum = r.nextLong();
    }

    public void deposit(double amt) {
        this.balance += amt;
    }

    public boolean withdraw(double amt) {
        boolean canWithdraw = amt < this.balance;
        this.balance = (canWithdraw) ? this.balance - amt : this.balance;
        return canWithdraw;
    }

    public long getAccountNum() {
        return this.accountNum;
    }

    public Client getClient() {
        return this.client;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getName() {
        return this.client.getName();
    }

}