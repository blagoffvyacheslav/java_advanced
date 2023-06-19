package com.dmdev.common.models;


public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String nickname;

    public User(String firstName, String lastName, String email, String nickname) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nickname = nickname;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}