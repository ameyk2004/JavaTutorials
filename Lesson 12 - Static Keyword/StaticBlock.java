class Sample{

    int data;

    static{
        System.out.println("Static Block is Called");
    }

    Sample(int d)
    {
        this.data = d;
    }


}


public class StaticBlock {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Static Block Example");

        // Sample s1 = new Sample(0);

        //As you notice, Instantiating object will cause a call of Static Block


        //How to Load a class Without creating instance ??
        //Here the java class "Class" come to help

        Class.forName("Sample");

        //As you can see we have loaded the static block without instantiating the object
        


    }

}

