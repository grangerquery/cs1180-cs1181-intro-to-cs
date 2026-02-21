import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * This program is a simple game with a stack of tiles numbered 1 through 3 and
 * a queue containing a pool of additional tiles. It returns the number of turns
 * that it takes for the stack of tiles to become empty after executing a few
 * different operations based on the value of the top number.
 * 
 * @author Brayden Granger
 * @since 03/19/2024
 */
public class TileGame {
    public static void main(String[] args) {
        ArrayDeque<Integer> myStack = new ArrayDeque<>(Arrays.asList(2, 1, 2, 3)); // Bottom -> Top
        Queue<Integer> myQueue = new ArrayDeque<>(Arrays.asList(1, 2, 2, 1, 3, 1, 2, 1, 2, 3)); // Front -> Back

        System.out.println(tileGame(myStack, myQueue));
    }

    /**
     * Executes a few different operations based on the tile number at the top of
     * the stack and increments the number of turns while it still contains tiles,
     * returning the number of turns at the end.
     * 
     * @param stack The stack
     * @param q     The queue
     * @return The number of turns
     */
    public static int tileGame(ArrayDeque<Integer> stack, Queue<Integer> q) {
        int turns = 0;
        while (!stack.isEmpty()) {
            try {
                if (stack.peek() == 1) {
                    // Remove the tile plus one more
                    stack.pop();
                    stack.pop();
                } else if (stack.peek() == 2) {
                    // Remove the tile plus two more
                    stack.pop();
                    stack.pop();
                    stack.pop();
                } else if (stack.peek() == 3) {
                    // Remove the tile and add next three tiles from queue to top
                    stack.pop();
                    stack.push(q.poll());
                    stack.push(q.poll());
                    stack.push(q.poll());
                }
            } catch (Exception e) {
                // Do nothing - still counts as a turn
            }
            turns++;
        }
        return turns;
    }
}