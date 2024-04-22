class Calculator{

    Calculator()
    {
        System.out.println("Object Created");
    }
    int add(int a, int b) // adding values with passing parameters
    {
        return a + b;
    }
}

public class Classes {
    public static void main(String args[])
    {
        Calculator calc = new Calculator();
        
        int a = 100;
        int b = 200;

        System.out.println("Addition is : " + calc.add(a, b));
    }
}
