public class JaggedArrays {
    public static void main(String[] args) {
        // Declare and initialize a jagged array
        int nums[][] = new int[4][]; // Jagged Array

        // Define the size of each sub-array
        nums[0] = new int[2];
        nums[1] = new int[3];
        nums[2] = new int[4];
        nums[3] = new int[2];

    

        // Print the elements of the jagged array
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}
