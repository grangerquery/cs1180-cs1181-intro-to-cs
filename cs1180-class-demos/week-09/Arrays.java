public class Arrays {

    /**
     * Prints array
     * 
     * @param args
     */
    public static void printArray(int[] aa) {
        for (int a : aa) {
            System.out.print(a + "\t");
        }
    }

    public static void main(String[] args) {
        // INTEGER ARRAY
        int[] nums = { 5, 8, 10, 12, 90, 45, 23, 89, 12 };

        System.out.println(nums.length);

        System.out.println("The 3rd number (2nd index) is: " + nums[2]);

        // for loops version
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
        System.out.println();

        // for-each loop version
        for (int num : nums) {
            System.out.print(num + "\t");
        }
        System.out.println();

        // STRING & CHAR ARRAY
        String[] play = { "hello", "play", "this is a larger phrase" };
        String[] breaker = play[2].split(" ");
        char[] word = new char[breaker[4].length()];

        for (int i = 0; i < breaker.length; i++) {
            System.out.print(breaker[i] + "\t");
        }
        System.out.println();

        // for loop version
        for (int i = 0; i < word.length; i++) {
            word[i] = breaker[4].charAt(i);
            System.out.print(word[i] + " ");
        }
        System.out.println();

        // for-each loop version
        for (char ch : word) {
            System.out.print(ch + " ");
        }
        System.out.println();

        System.out.println(breaker);
        System.out.println("The stored in breker array is: ");
        printArray(nums);
    }
}