package com.josh.test.user;

/**
 * Created by Josh on 7/2/2016.
 */
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User(String first, String last, String email, String password)
    {
        setFirstName(first);
        setLastName(last);
        setEmail(email);
        setPassword(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
