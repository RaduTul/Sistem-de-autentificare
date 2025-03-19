package com.example.project;

public class User {
    public static void ProvideUser () {
        System.out.println("{ 'status' : 'error' , 'message' : 'Please provide username'}");
    }
    public static void ProvidePassword () {
        System.out.println("{ 'status' : 'error' , 'message' : 'Please provide password'}");
    }
    public static void UserSucces () {
        System.out.println("{ 'status' : 'ok', 'message' : 'User created successfully'}");
    }
    public static void UserExists () {
        System.out.println("{'status':'error','message':'User already exists'}");
    }
}

