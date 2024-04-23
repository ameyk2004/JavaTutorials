public class StringBuffersInJava {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("Amey");
        System.out.println(sb);
        sb.append(" Kulkarni");
        System.out.println(sb);
        sb.deleteCharAt(4);
        System.out.println(sb);


    }
}


/*
Advantages of StringBuffer:
1. Mutability: StringBuffer is mutable, allowing for modification of its content without creating new objects.
2. Efficient String Manipulation: Provides methods like append(), insert(), delete(), replace(), and reverse() for efficient string manipulation.
3. Thread-Safe: StringBuffer is thread-safe, ensuring safe access and modification by multiple threads concurrently.
4. Resizable Capacity: Automatically adjusts capacity to accommodate varying string lengths, improving efficiency.
5. Backward Compatibility: Available in older Java versions, ensuring compatibility with legacy codebases.
*/
