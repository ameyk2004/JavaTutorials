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

        no_of_phones += 1;
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