class A
{
    //by default extends the Object class in java
    A()
    {
        System.out.println("A constructor called");
    }

    A(String param)
    {
        System.out.println("A constructor called with "+param);
    }
    
}

class B extends A
{
    B()
    {
        //super(); // calls default constructor of A
        super("Parameter"); // calls parameterized const of A

        
        System.out.println("B constructor called");
    }

    B(String param)
    {
        this();
        System.out.println("B constructor called with "+param);
    }
}
public class ThisandSuper {
    public static void main(String args[])
    {
        B obj = new B("hello");
        System.out.println((obj.getClass())); // prints the class

        //first the basd class onstructor is called
    }
    
}