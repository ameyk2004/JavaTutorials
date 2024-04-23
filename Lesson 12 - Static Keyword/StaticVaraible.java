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
    }
};
public class StaticVaraible {
    public static void main(String[] args) {
        
        Mobile m1 = new Mobile("Apple", 180000, "IPHONE 13");
        Mobile m2 = new Mobile("Samsung", 9000, "M30");
        Mobile m3 = new Mobile("Nokia", 7800, "E 51");
    }
    
}