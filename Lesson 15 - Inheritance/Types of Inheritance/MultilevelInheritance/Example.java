class Base{
    Base() {
        System.out.println("Base");
    }
}
class Level1 extends Base{
    Level1()
    {
        System.out.println("Level 1");
    }
}

class Level2 extends Level1 {
    Level2()
    {
        System.out.println("Level 2");
    }
}

public class Example {

     public static void main(String args[])
     {
        Level2 l2 = new Level2();
        l2.getClass();
     }
}