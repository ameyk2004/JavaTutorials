public class LogicalOperators {
    public static void main(String args[]) {
        // Logical Operators
        
        // Logical operators are used to perform logical operations on boolean values.
        // Java supports three logical operators: AND (&&), OR (||), and NOT (!).
        
        // AND Operator (&&)
        
        boolean operand1 = true;
        boolean operand2 = false;
        
        boolean resultAND = operand1 && operand2; // Evaluates to false
        System.out.println("AND Operator Result: " + resultAND);
        
        // OR Operator (||)
        
        boolean resultOR = operand1 || operand2; // Evaluates to true
        System.out.println("OR Operator Result: " + resultOR);
        
        // NOT Operator (!)
        
        boolean resultNOT = !operand1; // Evaluates to false
        System.out.println("NOT Operator Result: " + resultNOT);
        
        // Short-Circuit Evaluation
        
        // Example of Short-Circuit Evaluation
        
        int num1 = 5;
        int num2 = 0;
        
        // Using logical AND (&&) with short-circuit evaluation
        if (num1 != 0 && num2 != 0) {
            // This block will not be executed because num1 != 0 is false,
            // so there's no need to evaluate num2 != 0
            System.out.println("Both numbers are not zero.");
        }
        
        // Using logical OR (||) with short-circuit evaluation
        if (num1 == 0 || num2 == 0) {
            // This block will be executed because num1 == 0 is true,
            // so there's no need to evaluate num2 == 0
            System.out.println("At least one number is zero.");
        }
    }
}
