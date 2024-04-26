class A
{
    //by default extends the Object class in java
    A()
    {
        System.out.println("A constructor called");
    }
}

class B extends A
{
    B()
    {
        System.out.println("B constructor called");
    }
}
public class ThisandSuper {
    public static void main(String args[])
    {
        B obj = new B();
        System.out.println((obj.getClass())); // prints the class
    }
    
}