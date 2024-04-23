public class MultiDimensionalArray{
    public static void main(String args[])
    {
        int multiDimArr[][] = new int[4][4];

        // System.out.println(multiDimArr[0][0]);


        //Traversing
        for(int i=0;i<multiDimArr.length ;i++)
        {
            for(int j = 0;j<multiDimArr[0].length; j++)
            {
                System.out.print(multiDimArr[i][j]+ " ");
            }
            System.out.println();
        }

    }
};
