class StaticExample{
    int instanceVar = 10;
    static int classVar = 20;

    static void display()
    {
        //can be accessed by Classname
        // we can use static variable but cannot use instance Variable Here

        System.out.println(classVar); // noerror
        //System.out.println(instanceVar); // error
        //Cannot make a static reference to the non-static field instanceVar

    }

}

public class StaticMethod {
    public static void main(String[] args) {
        StaticExample st = new StaticExample();
        StaticExample.display();
        System.out.println(st.instanceVar);
    }
}
