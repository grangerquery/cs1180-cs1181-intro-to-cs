public class Manager {
    private static final int JOB_COUNT = 1000;
    private static volatile int nextJob = 0;
    public static int work[] = new int[JOB_COUNT];

    public synchronized int getNextJob() {
        if (nextJob >= JOB_COUNT) {
            return -1;
        }
        nextJob++;
        return nextJob - 1;
    }

    public void doWork(int position) {
        work[position]++;
    }
}
