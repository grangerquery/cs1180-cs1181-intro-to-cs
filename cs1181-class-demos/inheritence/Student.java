public class Student extends Raider {
    private int uid;
    private double gpa;

    public Student() {
        super();
        uid = 0;
        gpa = 0.0;
    }

    public Student(String lastName, String firstName, int uid, double gpa) {
        super(lastName, firstName);
        this.uid = uid;
        this.gpa = gpa;
    }

    public int getUid() {
        return this.uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public double getGpa() {
        return this.gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() + " (u" + uid + ") GPA: " + gpa;
    }
}
