/*
 * Name: Angela Giddings // ensure you use YOUR name
 * Student ID: 0123456789 // ensure you use YOUR student ID number
 * Course & Section: CST8132 304 // ensure you use YOUR lab section number * Assignment: Lab 3
 * Date: Sept 28, 2018 // can be due date or submission date
 */

public class Client {
    private String firstName;
    private String lastName;
    private long phoneNum;
    private String email;

    public Client(String firstName, String lastName, long phoneNum, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public long getPhoneNum() {
        return this.phoneNum;
    }

    public String getEmail() {
        return this.email;
    }
}