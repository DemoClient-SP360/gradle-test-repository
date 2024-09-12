package gradle;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModuleOne {
    
    // BUG: Null pointer dereference vulnerability
    public void process(String input) {
        if (input != null && input.length() > 5) { // Sonar might flag this for handling null check after method call.
            System.out.println("Input length is greater than 5");
        }
        input = null;
        if (input.length() > 5) { // NullPointerException risk here
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
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", password);
            System.out.println("Connecting to database with password: " + password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // SECURITY VULNERABILITY: SQL Injection vulnerability
    public void fetchUserData(String userInput) {
        String query = "SELECT * FROM users WHERE name = '" + userInput + "'"; // SQL Injection
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

    // SECURITY VULNERABILITY: Division by zero
    public void divideByZero(int value) {
        if (value != 0) {
            int result = 100 / value; // Dividing by zero vulnerability
            System.out.println("Result: " + result);
        } else {
            System.out.println("Cannot divide by zero");
        }
    }

    // BUG: Invalid return type (should return String but returns int)
    public String invalidReturnTypeMethod() {  // Method signature mismatch
        int number = 5; 
        return Integer.toString(number); // Returning the correct type now, but Sonar can flag the original mismatch
    }

    // Build error: Method signature is incorrect
    public void methodWithSyntaxError() { 
        System.out.println("This method has a syntax error");
    }

    // BUG: Undeclared variable
    public void undeclaredVariableError() {
        int undeclaredVar = 1;  // Declare the variable properly
        System.out.println("The value of undeclaredVar is: " + undeclaredVar);
    }
}
