public class SwitchCaseBlock {

    public static void main(String args[]) {
        // Switch-Case Statement
        
        // The switch-case statement is used for decision-making in Java.
        // It evaluates the value of an expression and executes a block of code based on the value.
        
        // Syntax:
        // switch (expression) {
        //     case value1:
        //         // Code block to execute if expression equals value1
        //         break;
        //     case value2:
        //         // Code block to execute if expression equals value2
        //         break;
        //     ...
        //     default:
        //         // Code block to execute if expression doesn't match any case
        //         break;
        // }
        
        // Example:
        
        int choice = 4;

        switch (choice) {
            case 1:
                System.out.println("Choice 1 ...");
                break;

            case 2:
                System.out.println("Choice 2 ...");
                break;

            case 3:
                System.out.println("Choice 3 ...");
                break;

            case 4:
                System.out.println("Choice 4 ...");
                break;

            case 5:
                System.out.println("Choice 5 ...");
                break;

            default:
                System.out.println("Default choice ...");
                break;
        }
    
    }
}
