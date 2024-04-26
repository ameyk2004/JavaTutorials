class A{
    void show()
    {
        System.out.println("in A show");
    }
    void config()
    {
        System.out.println("in A config");
    }
}

class B extends A{
    void show() // method Overriding
    {
        System.out.println("in B show");
    }
    
}

public class MethodOverriding {
    public static void main(String[] args) {
        B obj = new B();
        obj.config();;
        obj.show();
    }
}
