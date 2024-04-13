public class TernaryStatements {
    public static void main(String[] args) {
        // Ternary Conditional Operator
        
        // The ternary conditional operator (also known as the conditional operator or ternary operator) is a shorthand way
        // to express an if-else statement in a single line of code.
        // It evaluates a boolean expression and returns one of two values based on the result of the evaluation.
        
        // Syntax:
        // condition ? value1 : value2
        
        int n = 5;
        int result = 0;

        // Traditional if-else statement:
        // if(n % 2 == 0)
        //     result = 10;
        // else
        //     result = 20;

        // Using ternary conditional operator:
        result = (n % 2 == 0) ? 10 : 20;

        System.out.println(result); // Output: 20 (since 5 is odd, result will be assigned 20)
    }
}
