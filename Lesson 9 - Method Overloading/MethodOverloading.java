class Calculator{

    int add(int a, int b)
    {
        return a+b;
    }
   
    int add(int a, int b, int c)
    {
        return a + b +c;
    }


};
class MethodOverloading{
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println(" Addition of 2 numbers : "+ calc.add(20, 30));
        System.out.println(" Addition of 3 numbers : "+ calc.add(20, 30, 50));
    }
}