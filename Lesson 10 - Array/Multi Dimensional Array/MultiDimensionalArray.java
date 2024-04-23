public class MultiDimensionalArray{
    public static void main(String args[])
    {

        int x = (int)(Math.random()*10);
        int y = (int)(Math.random()*10);
        int multiDimArr[][] = new int[x][y];

        System.out.println("Matrix Size : "+x+"x"+y);

        // System.out.println(multiDimArr[0][0]);
        // Creating Random Matrix



        for(int i=0;i<multiDimArr.length ;i++)
        {
            for(int j = 0;j<multiDimArr[0].length; j++)
            {
                int num = (int)(Math.random()*10);
                System.out.print(num+ " ");
            }
            System.out.println();
        }

    }
};
