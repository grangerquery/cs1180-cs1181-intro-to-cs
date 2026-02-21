public class TwoDimArrays {
    public static void main(String[] args) {
        int[][] nums = {
                { 0, 6, 5, 7, 9 },
                { 2, 3, 4, 5, 89 },
                { 3, 4, 6, 7, 67 }
        };

        nums[2][0] = 42;
        int rows, cols = 0;
        rows = nums.length;
        cols = nums[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println();
        }
    }
}