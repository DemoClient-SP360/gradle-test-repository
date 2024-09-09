package main.java.gradle.project.fail;

import java.util.ArrayList;

public class ModuleOne {
    
    // BUG: Null pointer dereference vulnerability
    public void process(String input) {
        if (input.length() > 5) { // This can lead to a NullPointerException if input is null
            System.out.println("Input length is greater than 5");
        }
    }

    // CODE SMELL: Unused private method
    private void unusedMethod() {
        System.out.println("This method is never used");
    }

    // CODE SMELL: Using a raw type
    public void useRawType() {
        ArrayList rawList = new ArrayList(); // Raw type instead of using generics
        rawList.add("test");
    }

    // SECURITY VULNERABILITY: Hardcoded password
    public void connectToDatabase() {
        String password = "SuperSecretPassword123"; // Hardcoded password is a bad practice
        System.out.println("Connecting to database with password: " + password);
    }

     // BUG: SQL Injection vulnerability
    public void fetchUserData(String userInput) {
        String query = "SELECT * FROM users WHERE name = '" + userInput + "'"; // Dangerous SQL query
        System.out.println("Executing query: " + query);
    }

    // CODE SMELL: Duplicate code
    public void duplicateCodeExample1() {
        System.out.println("This is duplicate code");
    }

    public void duplicateCodeExample2() {
        System.out.println("This is duplicate code"); // Same logic as above
    }

    // BUG: Unused local variable
    public void unusedVariable() {
        String unused = "This variable is never used"; // Unused variable
    }

    // VULNERABILITY: Division by zero
    public void divideByZero(int value) {
        int result = 100 / value; // No check for division by zero
        System.out.println("Result: " + result);
    }

    // Build error: Method has invalid return type
    public String invalidReturnTypeMethod() {
        int number = 5; 
        return number; // Trying to return an int when the method should return a String
    }

    // Build error: Method signature is incorrect
    public void incorrectMethodSignature String methodWithSyntaxError() { // Incorrect syntax for method declaration
        System.out.println("This method has a syntax error");
    }

    // Build error: Undeclared variable
    public void undeclaredVariableError() {
        System.out.println("The value of undeclaredVar is: " + undeclaredVar); // undeclaredVar is not defined
    }
}