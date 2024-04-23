public class Strings {
    public static void main(String args[])
    {
        String name = new String("My Name");
        System.out.println(name);
        System.out.println(name.hashCode());

        System.out.println("Length of String: " + name.length());
        System.out.println("Character at index 3: " + name.charAt(3));
        System.out.println("Substring from index 3: " + name.substring(3));
        System.out.println("Substring from index 3 to 6: " + name.substring(3, 7));
        System.out.println("Index of 'N': " + name.indexOf('N'));
        System.out.println("Index of 'x': " + name.indexOf('x'));
        System.out.println("String starts with 'My': " + name.startsWith("My"));
        System.out.println("String ends with 'me': " + name.endsWith("me"));


        //String constant pool

        //The String constant pool is a special area in the Java heap memory 
        //where Java stores string literals to optimize memory usage and 
        //improve performance.


        //New object is not created if same string is encountered

        //In the code snippet, str1 and str2 are two string variables initialized with the same string literal "Hello Java !".
        //Both str1 and str2 refer to string objects created in the string constant pool.

        String str1 = "Hello Java !";
        String str2 = "Hello Java !";
        System.out.println("\nString Constant Pool");
        System.out.println(str1 == str2);

    }
}
