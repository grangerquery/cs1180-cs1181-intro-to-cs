public class MethodDemo {
    final static int sum = 0;

    // method stub
    public static void printHello() {
        // System.out.println("Hello world!");
        String start = "Hello";
        String end = "World";
        System.out.println(start + end);
    }

    // adds two numbers together and returns the sum
    public static int adder() {
        // make two ints
        return 9 + 8;
    }

    // prints a user string
    public static void printStr(String str) {
        System.out.println(str);
    }

    // take two numbers and return the sum
    public static int addSum(int a, int b) {
        return a + b;
    }

    // pyramid
    public static void triangle(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Beginning of my program");
        printHello();
        int val = adder();
        System.out.println("Return value from adder is " + val);
        printStr("My string from main");
        System.out.println(addSum(8, 9));
        triangle(21);
        System.out.println("End of program");
    }
}