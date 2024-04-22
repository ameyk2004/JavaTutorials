class Calculator{
    int num1;
    int num2;

    Calculator(int n1, int n2)
    {
        num1 = n1;
        num2 = n2;
    }
    int add() // adding values with using constructor
    
    {
        return num1 + num2;
    }
}

public class Classes {
    public static void main(String args[])
    {
        Calculator calc = new Calculator(100, 200);
        
        int a = 100;
        int b = 200;

        System.out.println("Addition is : " + calc.add());
    }
}
