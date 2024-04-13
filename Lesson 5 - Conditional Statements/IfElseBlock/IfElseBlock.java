public class IfElseBlock {
    public static void main(String args[]) {
        // If-Else Statements
        
        // If-else statements are used for decision-making in Java.
        // They allow you to execute certain blocks of code based on whether a condition is true or false.
        
        // Syntax:
        // if (condition) {
        //     // Code block to execute if the condition is true
        // } else {
        //     // Code block to execute if the condition is false
        // }
        
        // Example 1: Checking if a number is positive or negative
        
        int number = -10;
        
        if (number > 0) {
            System.out.println(number + " is positive.");
        } else {
            System.out.println(number + " is negative.");
        }
        
        // Example 2: Checking if a number is even or odd
        
        int num = 15;
        
        if (num % 2 == 0) {
            System.out.println(num + " is even.");
        } else {
            System.out.println(num + " is odd.");
        }
        
        // Example 3: Nested if-else statement
        
        int x = 10;
        int y = 20;
        
        if (x > y) {
            System.out.println("x is greater than y.");
        } else if (x < y) {
            System.out.println("x is less than y.");
        } else {
            System.out.println("x is equal to y.");
        }
    }
}
