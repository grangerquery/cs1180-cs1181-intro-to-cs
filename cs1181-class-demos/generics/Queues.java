import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queues {
    public static void main(String[] args) {
        Queue<String> q = new ArrayDeque<>();

        q.offer("Bob");
        q.offer("Sally");

        System.out.println("Normal queue: ");
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (a < b) {
                return 1;
            } else if (a > b) {
                return -1;
            } else {
                return 0;
            }
        });

        pq.offer(12);
        pq.offer(22);
        pq.offer(5);
        pq.offer(16);
        pq.offer(35);
        pq.offer(2);

        System.out.println("\nPriority queue: ");
        System.out.println(pq);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        // Priority queue that checks if numbers are even then sorts
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> {
            if ((a + b) % 2 == 0) {
                return a.compareTo(b);
            } else if (a % 2 == 0) {
                return -1;
            } else {
                return 1;
            }
        });

        pq2.offer(1);
        pq2.offer(12);
        pq2.offer(7);
        pq2.offer(2);
        pq2.offer(2);
        pq2.offer(1);
        pq2.offer(1);
        pq2.offer(4);
        pq2.offer(4);
        pq2.offer(7);
        pq2.offer(7);

        System.out.println("\nPriority queue 2: ");
        System.out.println(pq2);
        while (!pq2.isEmpty()) {
            System.out.println(pq2.poll());
        }
    }
}
