// Base class
class Calculator {
    // Addition method
    public int add(int a, int b) {
        return a + b;
    }

    // Subtraction method
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplication method
    public int multiply(int a, int b) {
        return a * b;
    }

    // Division method
    public double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero!");
            return 0;
        }
        return (double) a / b;
    }
}

// Derived class inheriting from Calculator
class AdvancedCalculator extends Calculator {
    // Method to calculate square root
    public double squareRoot(int num) {
        return Math.sqrt(num);
    }

    // Method to calculate power
    public double power(int base, int exponent) {
        return Math.pow(base, exponent);
    }
}

// Main class
public class Example {
    public static void main(String[] args) {
        // Creating an object of AdvancedCalculator class
        AdvancedCalculator advancedCalc = new AdvancedCalculator();

        // Using methods from the base class Calculator
        System.out.println("Addition: " + advancedCalc.add(5, 3));
        System.out.println("Subtraction: " + advancedCalc.subtract(10, 4));
        System.out.println("Multiplication: " + advancedCalc.multiply(6, 2));
        System.out.println("Division: " + advancedCalc.divide(8, 2));

        // Using methods from the derived class AdvancedCalculator
        System.out.println("Square Root: " + advancedCalc.squareRoot(25));
        System.out.println("Power: " + advancedCalc.power(2, 3));
    }
}
