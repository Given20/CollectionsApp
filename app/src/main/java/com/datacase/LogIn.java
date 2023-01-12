package com.datacase;

public class LogIn {
    private String Username;
    private String Email;
    private String PhoneNumber;
    private String Password;


    public LogIn() {
    }

    public LogIn(String username, String email, String phoneNumber, String password) {
        Username = username;
        Email = email;
        PhoneNumber = phoneNumber;
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
