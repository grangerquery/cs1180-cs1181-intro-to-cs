public class Employee extends Raider {
    private int uid;

    public Employee() {
        System.out.println("Calling constructor for class Employee");
        uid = 0;
    }

    public Employee(String lastName, String firstName, int uid) {
        super(lastName, firstName);
        this.uid = uid;
    }

    @Override
    public String toString() {
        return super.toString() + " (u" + uid + ")";
    }
}
