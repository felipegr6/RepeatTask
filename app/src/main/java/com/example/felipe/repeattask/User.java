package com.example.felipe.repeattask;

public class User {

    private String login;
    private String name;
    private String location;

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

}