package com.example.project;

public class Question {
    public static void Authentific () {
        System.out.println("{ 'status' : 'error', 'message' : 'You need to be authenticated'}");
    }
    public static void LoginFailed () {
        System.out.println("{ 'status' : 'error', 'message' : 'Login failed'}");
    }
    public static void Succes() {
        System.out.println("{ 'status' : 'ok', 'message' : 'Question added successfully'}");
    }
}