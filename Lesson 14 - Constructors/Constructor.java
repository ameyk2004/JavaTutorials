class Demo{
    int demo;

    Demo()
    {
        System.out.println("Default Constructor");
        demo = 0;
    }

    Demo(int d)
    {
        System.out.println("Paremeterized Constructor");
        demo = d;
    }
}

public class Constructor {
    public static void main(String args[])
    {
        System.out.println("Constructors in Java");
        Demo d1 = new Demo();
        Demo d2 = new Demo(20);

        System.out.println(d1.demo);
        System.out.println(d2.demo);
    }
}
