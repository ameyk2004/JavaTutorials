class Human{

    //You know lot of stuff

    //En capsulating , i.e hiding of data

    int age;
    String name;

}


public class Encapsulation {

    public static void main(String args[])
    {
        System.out.println("Encapsulation");

        Human obj = new Human();
        obj.age = 20;
        obj.name = "Amey";

        System.out.println("\n"+obj.name+" : "+obj.age);

        // No encapsultion, var accesed outside clss

    }
}