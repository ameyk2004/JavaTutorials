import java.util.Scanner;

public class practice{
    public static void main(String[] args) {
        System.out.println("Arrays in Java");

        int n,odd=0,even=0;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n : ");
        n = sc.nextInt();

        int arr[] = new int[n];

        for(int i=0;i<n;i++)
        {
            System.out.print("\nEnter ["+i+"] : ");
            arr[i] = sc.nextInt();
        }

        for(int num : arr)
        {
            System.out.print(num+" ");
            if(num%2 == 0)
                even+=1;

            else
                odd+=1;
        }

        System.out.println("\nOdd =  "+odd);
        System.out.println("Even =  "+even);

        sc.close();


    }
}
