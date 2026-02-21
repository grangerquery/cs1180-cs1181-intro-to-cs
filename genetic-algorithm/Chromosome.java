import java.util.*;

/**
 * Class Chromosome - Holds the information of a chromosome
 * 
 * @author Brayden Granger
 * @since 02/05/2024
 */
public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome> {
    private static Random rng; // Used for random number generation

    /**
     * This no-arg constructor can be empty
     */
    public Chromosome() {
    }

    /**
     * Adds a copy of each of the items passed in to this Chromosome. Uses a random
     * number to decide whether each item’s included field is set to true or false.
     * 
     * @param items An ArrayList of items
     */
    public Chromosome(ArrayList<Item> items) {
        rng = new Random();

        for (Item item : items) {
            Item newItem = new Item(item);
            newItem.setIncluded(rng.nextBoolean());
            this.add(newItem);
        }
    }

    /**
     * Creates and returns a new child chromosome by performing the crossover
     * operation on this chromosome and the other one that is passed in (i.e. for
     * each item, use a random number to decide which parent’s item should be copied
     * and added to the child)
     * 
     * @param other A chromosome representing what this chromosome is being crossed
     *              with
     * @return A new child chromosome
     */
    public Chromosome crossover(Chromosome other) {
        Chromosome child = new Chromosome();
        rng = new Random();

        for (Item item : this) {
            int num = rng.nextInt(10) + 1;

            if (num < 6) {
                child.add(item);
            } else {
                child.add(other.get(this.indexOf(item)));
            }
        }
        return child;
    }

    /**
     * Performs the mutation operation on this chromosome (i.e. for each item in
     * this chromosome, use a random number to decide whether or not to flip it’s
     * included field from true to false or vice versa)
     */
    public void mutate() {
        rng = new Random();

        for (Item item : this) {
            int num = rng.nextInt(10) + 1;

            if (num == 1) {
                item.setIncluded(!item.isIncluded());
            }
        }
    }

    /**
     * Returns the fitness of this chromosome. If the sum of all of the included
     * items’ weights are greater than 10, the fitness is zero. Otherwise, the
     * fitness is equal to the sum of all of the included items’ values.
     * 
     * @return An integer representing the chromosome's fitness
     */
    public int getFitness() {
        int fitness = 0; 
        double totalWeight = 0;

        for (Item item : this) {
            if (item.isIncluded()) {
                totalWeight += item.getWeight();
                fitness += item.getValue();
            }
        }

        if (totalWeight <= 10) {
            return fitness;
        } else {
            return 0;
        }
    }

    /**
     * Returns -1 if this chromosome’s fitness is greater than the other’s fitness,
     * +1 if this chromosome’s fitness is less than the other one’s, and 0 if their
     * fitness is the same
     * 
     * @param other A chromosome representing what this chromosome is being compared
     *              to
     * @returns A -1 if this chromosome’s fitness is greater than the other’s
     *          fitness, +1 if this chromosome’s fitness is less than the other
     *          one’s, and 0 if their fitness is the same
     */
    @Override
    public int compareTo(Chromosome other) {
        if (getFitness() > other.getFitness()) {
            return -1;
        } else if (getFitness() < other.getFitness()) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Displays the name, weight and value of all items in this chromosome whose
     * included value is true, followed by the fitness of this chromosome.
     *
     * @return The information of the items in the chromosome followed by its
     *         fitness.
     */
    @Override
    public String toString() {
        String output = "";

        for (Item item : this) {
            if (item.isIncluded()) {
                output += item + "\n";
            }
        }
        output += "Fitness: " + getFitness();
        return output;
    }
}