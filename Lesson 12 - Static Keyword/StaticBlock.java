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
    public static void main(String[] args) {
        System.out.println("Static Block Example");

        Sample s1 = new Sample(0);

        //As you notice, Instantiating object will cause a call of Static Block



    }

}

