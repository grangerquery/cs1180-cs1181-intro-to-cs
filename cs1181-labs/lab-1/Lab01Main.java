public class Lab01Main {
    public static void main(String[] args) {
        // PROVIDED CODE
        System.out.println("Non-secure user:");

        User user1 = new User("Michelle", "12345");
        System.out.println("1. " + user1.isValidPassword()); // false -- less than 8 characters

        User user2 = new User("Michelle", "12345Michelle");
        System.out.println("2. " + user2.isValidPassword()); // false -- contains username

        User user3 = new User("Michelle", "12345678");
        System.out.println("3. " + user3.isValidPassword()); // true

        System.out.println("4. " + user2.authenticate("ABCDE")); // false -- incorrect password
        System.out.println("5. " + user2.authenticate("12345Michelle")); // true 

        System.out.println("6. " + user3.authenticate("12345678")); // true

        // MY CODE
        System.out.println("\nSecure user: ");

        SecureUser su1 = new SecureUser("Brayden", "12345");
        System.out.println("01. " + su1.authenticate("12345")); // true

        System.out.println("02. " + su1.authenticate("123456")); // false -- incorrect password
        System.out.println("03. " + su1.authenticate("123456")); // false -- incorrect password
        System.out.println("04. " + su1.authenticate("123456")); // false -- incorrect password

        System.out.println("05. " + su1.authenticate("12345")); // false -- 3 consecutive authentications

        SecureUser su2 = new SecureUser("Brayden", "Hello world!");
        System.out.println("06. " + su2.authenticate("Hello world!")); // true

        System.out.println("07. " + su2.authenticate("654321")); // false -- incorrect password
        System.out.println("08. " + su2.authenticate("654321")); // false -- incorrect password
        System.out.println("09. " + su2.authenticate("Hello world!")); // true

        System.out.println("10. " + su2.authenticate("Hello world!")); // true -- number of authentications reset after 09
    }
}
