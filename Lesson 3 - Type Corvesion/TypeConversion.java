public class TypeConversion {
    public static void main(String args[]) {
        // Type Conversion
        
        // Type conversion, also known as type casting, is the process of converting one data type into another.
        // Java supports two types of type conversion: implicit (automatic) and explicit (manual).
        
        // Implicit Type Conversion
        
        // Implicit type conversion occurs when a data type with a smaller range is converted to a data type with a larger range.
        // It is performed automatically by the compiler without any explicit instructions.
        
        byte b = 127; // byte has a smaller range than int
        int a = 256;  // int has a larger range than byte
        
        // b = a; // This will not work as byte < int
        // This assignment will result in a compilation error because we are narrowing the data type.
        
        // Explicit Type Conversion
        
        // Explicit type conversion, also known as casting, is the process of manually converting one data type into another.
        // It is required when converting from a data type with a larger range to a data type with a smaller range (narrowing).
        // Explicit type conversion is performed by placing the desired type in parentheses before the value to be converted.
        
        a = b; // This works because implicit type conversion is widening the data type.
        
        // External Type Casting
        
        // External type casting is another term for explicit type conversion.
        // It involves explicitly specifying the target data type using parentheses.
        
        b = (byte) a; // This works and is external type casting
        
        // Example: Converting Floating-Point to Integer
        
        float f = 5.6f; // Floating-point number
        int x = (int) f; // Type casting float to int
        
        System.out.println(x); // Output: 5
    }
}
