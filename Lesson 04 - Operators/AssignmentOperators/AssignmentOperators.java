public class AssignmentOperators {
    public static void main(String args[]) {
        // Assignment Operators
        
        // Assignment operators are used to assign values to variables.
        // They are shorthand notations for simple assignment operations.
        // Java supports various assignment operators, including simple assignment, compound assignment, and unary assignment operators.
        
        // Simple Assignment Operator (=)
        
        int x = 10; // Assigning the value 10 to the variable x
        
        // Shorthand Assignment Operators
        
        int y = 5;
        y += 3; // Equivalent to y = y + 3;
        
        // Other shorthand assignment operators: -=, *=, /=, %=
        
        // Unary Assignment Operators
        
        // Unary assignment operators perform increment (++) or decrement (--) operations on variables.
        // They are used to increase or decrease the value of a variable by one.
        
        int z = 7;
        z++; // Increment z by 1
        // Equivalent to: z = z + 1;
        
        // Other unary assignment operators: -- (decrement)
        z--;
        
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

        //Pre increment and Post Increment

    
        System.out.println(++x); // first increment then fetch
        System.out.println(x++); // first fetch then increment
        
        //Therefore both outputs will be 11

        



    }
}
