public class Literals {
    public static void main(String args[]) {
        // Literals
        
        // A literal is a constant value that is directly written in the source code.
        // Java supports various types of literals, including integer, floating-point, character, string, and boolean literals.
        
        // Integer Literals
        
        // Integer literals represent whole numbers without any decimal point.
        // They can be written in decimal (base 10), octal (base 8), or hexadecimal (base 16) format.
        
        int decimalLiteral = 1000000; // Decimal literal (base 10)
        int octalLiteral = 076; // Octal literal (starts with 0)
        int hexadecimalLiteral = 0xFF; // Hexadecimal literal (starts with 0x)
        
        System.out.println("Decimal Literal: " + decimalLiteral);
        System.out.println("Octal Literal: " + octalLiteral);
        System.out.println("Hexadecimal Literal: " + hexadecimalLiteral);
        
        // Floating-Point Literals
        
        // Floating-point literals represent numbers with a fractional part.
        // They can be written in decimal or scientific notation.
        
        double decimalFloatLiteral = 3.14159; // Decimal floating-point literal
        double scientificFloatLiteral = 3.0e8; // Scientific notation (3.0 x 10^8)
        System.out.println("Decimal Floating-Point Literal: " + decimalFloatLiteral);
        System.out.println("Scientific Notation Literal: " + scientificFloatLiteral);
        // Underscores in Numeric Literals
        
        // Underscores can be used to enhance readability of numeric literals.
        // They can be placed anywhere within the number (except at the beginning or end).
        
        double num1 = 1000000; // Without underscores (may be difficult to count zeros)
        double num2 = 1_000_000; // With underscores (easier to read and count)
        System.out.println("Number without Underscores: " + num1);
        System.out.println("Number with Underscores: " + num2);
        
        // Character and String Literals
        
        // Character literals are enclosed in single quotes ('').
        char charLiteral = 'A';
        
        // String literals are enclosed in double quotes ("").
        String stringLiteral = "Hello, world!";
        System.out.println("Character Literal: " + charLiteral);
        System.out.println("String Literal: " + stringLiteral);
        // Boolean Literals
        
        // Boolean literals represent the two boolean values: true and false.
        boolean booleanLiteral = true;
        System.out.println("Boolean Literal: " + booleanLiteral);

    }

}
