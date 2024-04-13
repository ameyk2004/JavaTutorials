public class ForLoop {
    public static void main(String[] args) {
        // For Loop
        
        // The for loop in Java is used to iterate over a range of values.
        // It consists of three parts: initialization, condition, and increment/decrement.
        // The loop continues as long as the condition is true.
        //entry controlled loop
        //checking condition before entering loop
    

        // Example 1: Printing numbers from 1 to 5
        
        System.out.println("\nExample 1: (Numbers 1 to 5)");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        
        // Example 2: Printing even numbers from 2 to 10
        
        System.out.println("\n\nExample 2: (Even Numbers 1 to 10)");
        for (int j = 2; j <= 10; j += 2) {
            System.out.print(j+" ");
        }
        
        // Example 3: Printing numbers from 10 to 1 in reverse order
        
        System.out.println("\n\nExample 3: (Numbers 10 to 1)");
        for (int k = 10; k >= 1; k--) {
            System.out.print(k+" ");
        }
    }
}
