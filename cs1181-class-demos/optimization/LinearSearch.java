public class LinearSearch {
    public static void main(String[] args) {
        int[] values = { 1, 9, 52, 17, 38, 45, 12, 109, 220, 67 };
        System.out.println(search(values, 52));
        System.out.println(search(values, 77));
    }

    /**
     * Best case  : Tc(n) = O(1)
     * Worst case : Tc(n) = O(n)
     */
    public static boolean search(int[] values, int target) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                return true;
            }
        }
        return false;
    }
}