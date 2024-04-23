class Mobile{
    String brand;
    int price;
    String name;

    static int no_of_phones;

    Mobile(String b, int p, String n)
    {
        this.brand = b;
        this.price = p;
        this.name = n;

        no_of_phones += 1; // Incrementing the static variable
    }
    

    void display()
    {
        System.out.println("\n\nBrand : "+this.brand+"\nPrice : "+this.price+"\nName : "+this.name);
    }


};
public class StaticVaraible {
    public static void main(String[] args) {
        
        Mobile m1 = new Mobile("Apple", 180000, "IPHONE 13");
        Mobile m2 = new Mobile("Samsung", 9000, "M30");
        Mobile m3 = new Mobile("Nokia", 7800, "E 51");

        Mobile mobiles[] = {m1,m2,m3};

        for(Mobile mob : mobiles)
        {
            mob.display();

        }

        System.out.println(Mobile.no_of_phones);
    }
    
}

/*
Static Variable Notes:
1. Static variables belong to the class rather than individual instances of the class.
2. They are shared among all instances of the class and are initialized only once at the start of the program.
3. In this example, 'no_of_phones' is a static variable that tracks the total number of mobile phones created.
4. It is incremented in the constructor whenever a new mobile phone object is created.
5. Static variables can be accessed using the class name, e.g., Mobile.no_of_phones.
6. They are useful for storing data that needs to be shared across all instances of a class.
*/