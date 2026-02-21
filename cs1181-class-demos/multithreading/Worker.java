import java.util.ArrayList;

public class Worker extends Thread {
    private Manager myManager;

    public Worker(Manager myManager) {
        this.myManager = myManager;
    }

    @Override // All threads must have a 'run' method
    public void run() {
        int nextJob = myManager.getNextJob();
        // Thread switches 0 to 1
        while (nextJob != -1) {
            myManager.doWork(nextJob);
            nextJob = myManager.getNextJob();
        }
    }

    public static void main(String[] args) {
        Manager theManager = new Manager();

        ArrayList<Worker> workers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Worker myWorker = new Worker(theManager);
            workers.add(myWorker);
            myWorker.start();
        }

        for (Worker myWorker : workers) {
            try {
                myWorker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 1000; i++) {
            System.out.print(theManager.work[i] + " ");
        }
    }
}
