public class LargestNumber {
    public static void main(String[] args) {
        int x = 30;
        int y = 80;
        int z = 90;

        if(x>y)
        {
            if(x > z)
            {
                System.out.println(x+" Largest Number");
            }
            else
            {
                System.out.println(z+" Largest Number");
            }

        }
        else if(y>z){
            System.out.println(y+" Largest Number");
        }
        else
        {
            System.out.println(z+" Largest Number");
        }
    }
}
