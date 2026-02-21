import java.io.*;
import java.util.*;

/**
 * This program reads in item data from a file and uses that data to create
 * chromosomes which are randomly paired, crossed over, and mutated to form a
 * child chromosome, which are used for determining the optimal combination of
 * items to maximize value verses weight. The program outputs the most optimal
 * chromosome after randomly generating children from the 10 best chromosomes 20
 * times.
 * 
 * @author Brayden Granger
 * @since 02/06/2024
 */
public class GeneticAlgorithm {
    /**
     * Reads in a data file with the format shown below and creates and returns an
     * ArrayList of Item objects.
     * The data file should be structurd as such:
     * item1_label, item1_weight, item1_value
     * item2_label, item2_weight, item2_value
     * ...
     * 
     * @param fileName A string representing the data file's relative path
     * @return An ArrayList of items
     * @throws FileNotFoundException
     */
    public static ArrayList<Item> readData(String fileName) throws FileNotFoundException {
        File itemFile = new File(fileName);
        Scanner itemReader = new Scanner(itemFile);
        ArrayList<Item> items = new ArrayList<Item>();

        while (itemReader.hasNextLine()) {
            String[] data = itemReader.nextLine().split(", ");
            items.add(new Item(data[0], Double.valueOf(data[1]), Integer.valueOf(data[2])));
        }
        itemReader.close();
        return items;
    }

    /**
     * Creates and returns an ArrayList of populationSize Chromosome objects that
     * each contain the items, with their included =ield randomly set to true or
     * false.
     * 
     * @param items          An ArrayList of items
     * @param populationSize An integer representing the population size
     * @return An ArrayList of chromosomes
     */
    public static ArrayList<Chromosome> initializePopulation(ArrayList<Item> items, int populationSize) {
        ArrayList<Chromosome> chromosomes = new ArrayList<Chromosome>();

        for (int i = 0; i < populationSize; i++) {
            chromosomes.add(new Chromosome(items));
        }
        return chromosomes;
    }

    /**
     * Reads the data about the items in from a file called items.txt and performs
     * the steps described in the Running the Genetic Algorithm section of the lab
     * 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Chromosome> currentPopulation = new ArrayList<Chromosome>();
        ArrayList<Chromosome> nextGeneration = new ArrayList<Chromosome>();

        // Create a set of ten random individuals to serve as the initial population
        currentPopulation = initializePopulation(readData("Projects\\Project 1\\Items.txt"), 10);

        // Repeat twenty times
        for (int i = 0; i < 20; i++) {
            // Add each of the individuals in the current population to the next generation
            for (Chromosome chromosome : currentPopulation) {
                nextGeneration.add(chromosome);
            }

            // Randomly pair off the individuals and perform crossover to create a child and
            // add it to the next generation as well. (currentPopulation and nextGeneration
            // should both have 10 items contained in them at this point)
            Collections.shuffle(currentPopulation);
            Collections.shuffle(nextGeneration);

            for (int j = 0; j < 10; j++) {
                nextGeneration.add(currentPopulation.get(j).crossover(nextGeneration.get(j)));
            }

            // Randomly choose ten percent of the individuals in the next generation and
            // expose them to mutation
            for (Chromosome chromosome : nextGeneration) {
                chromosome.mutate();
            }

            // Sort the individuals in the next generation according to their fitness
            Collections.sort(nextGeneration);

            // Clear out the current population and add the top ten of the next generation
            // back into the population
            currentPopulation.clear();

            for (Chromosome chromosome : nextGeneration) {
                currentPopulation.add(chromosome);
            }

            nextGeneration.clear();
        }

        // Sort the population and display the fittest individual to the console
        Collections.sort(currentPopulation);
        System.out.println(currentPopulation.get(0));
    }
}
