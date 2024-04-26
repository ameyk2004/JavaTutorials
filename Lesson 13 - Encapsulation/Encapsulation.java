class Human{

    //You know lot of stuff

    //En capsulating , i.e hiding of data

    // int age;
    // String name;

    private String name;

    void setName(String n)
    {
        name = n;
    }
    String getName()
    {
        return this.name;
    }
        // now accessible in same class
}


public class Encapsulation {

    public static void main(String args[])
    {
        System.out.println("Encapsulation");
        Human obj = new Human();

        obj.setName("Amey");
        //obj.age = 20; //error generated
        //obj.name = "Amey"; //error generated

        System.out.println("\n"+obj.getName());

        // No encapsultion, var accesed outside clss

    }
}