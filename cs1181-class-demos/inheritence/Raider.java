public class Raider {
    private String firstName;
    private String lastName;

    public Raider(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Raider() {
        System.out.println("Calling constructor for class Raider");
        lastName = "No Last Name Given";
        firstName = "No First Name Given";
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }
}
