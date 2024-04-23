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
    }
}
