class Calculator {
    // First add method that takes two integers and returns their sum
    int add(int a, int b) {
        return a + b;
    }

    // Second add method that takes three integers and returns their sum
    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
        // Creating an instance of the Calculator class
        Calculator calc = new Calculator();

        // Calling the first add method with two parameters and printing the result
        System.out.println("Addition of 2 numbers: " + calc.add(20, 30));

        // Calling the second add method with three parameters and printing the result
        System.out.println("Addition of 3 numbers: " + calc.add(20, 30, 50));
    }
}
