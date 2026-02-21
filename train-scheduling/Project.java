import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

/**
 * This program simulates a package delivery system involving drones and trucks
 * where trucks must cross a train crossing.
 * 
 * The program tracks events in real time: truck starts, truck waits at
 * crossing, truck crosses crossing, truck reaches destination, train arrives,
 * train departs.
 * 
 * The program also keeps track of statistics: % of packages delivered by
 * drones, # of packages, # of drones, # of trucks, the train schedule, the
 * total trip time of each truck, the trucks' average trip time, the trucks'
 * total trip time, a drone's trip time, the drones' total trip time, the
 * overall time, and the time elapsed of the program itself.
 * 
 * Most optimal percentage of packages delivered by drones: 47% (2185.0 minutes)
 * 
 * @author Brayden Granger
 * @since 03/28/2024
 */
public class Project {
    private static ArrayList<Truck> trucks = new ArrayList<>(); // The trucks
    private static ArrayList<Event> events = new ArrayList<>(); // The events
    private static ArrayDeque<Double> trainArriveTimes = new ArrayDeque<>(); // The times when a train arrives
    private static ArrayDeque<Double> trainDepartTimes = new ArrayDeque<>(); // The times when a train departs
    private static double totalTruckTime = 0; // The total time it takes for all trucks to finish
    private static int numTrucks = 0; // The number of trucks
    public static Scanner file_sc; // A file scanner

    public static void main(String[] args) {
        final long START = System.nanoTime(); // The time when the program starts
        final int DAILY_PACKAGES = 1500; // The number of daily packages
        final double PERCENT_BY_DRONE = 47; // The percentage of packages delivered by drone
        final double DRONE_TIME = 30000 / 500; // The time it takes for a drone to complete a delivery

        // Calculates number of drones and trucks
        int numDrones = (int) (DAILY_PACKAGES * (PERCENT_BY_DRONE / 100));
        numTrucks = (DAILY_PACKAGES - numDrones) / 10;

        // Adds one extra truck if necessary
        if (numDrones + numTrucks * 10 < DAILY_PACKAGES) {
            numTrucks++;
        }

        // Calculates total drone trip time
        double totalDroneTime = 0;
        if (numDrones != 0) {
            totalDroneTime = DRONE_TIME + ((numDrones - 1) * 3);
        }

        // Initialization of trucks
        for (int i = 0; i < numTrucks; i++) {
            trucks.add(new Truck(i + 1));
        }

        readTrainData(new File("train_schedule.txt"));
        // Begin terminal output
        System.out.println("With " + PERCENT_BY_DRONE + "% drones and " + DAILY_PACKAGES + " packages,");
        System.out.println("There will be:");
        System.out.println("-" + numDrones + " drones");
        System.out.println("-" + numTrucks + " trucks\n");
        printTrainSchedule();
        eventTracking();
        printTruckStats();
        System.out.println("\nDRONE TRIP TIME: " + DRONE_TIME + " minutes");
        System.out.println("DRONE TOTAL TIME: " + totalDroneTime + " minutes\n");
        if (totalDroneTime > totalTruckTime) {
            System.out.println("TOTAL TIME: " + totalDroneTime + " minutes");
        } else {
            System.out.println("TOTAL TIME: " + totalTruckTime + " minutes");
        }
        System.out.println("BUILD SUCCESSFUL (total time: " + (System.nanoTime() - START) / 1000000 + " milliseconds)");
    }

    /**
     * Reads the start and end times of the trains from a data file
     * 
     * @param dataFile The data file
     */
    private static void readTrainData(File dataFile) {
        try {
            file_sc = new Scanner(dataFile);
            while (file_sc.hasNextInt()) {
                double tempTime = file_sc.nextInt();
                trainArriveTimes.offer(tempTime);
                trainDepartTimes.offer(tempTime + file_sc.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        file_sc.close();
    }

    /**
     * Prints the train schedule to the terminal
     */
    private static void printTrainSchedule() {
        ArrayDeque<Double> tempArriveTimes = trainArriveTimes.clone();
        ArrayDeque<Double> tempDepartTimes = trainDepartTimes.clone();
        int size = trainArriveTimes.size();

        System.out.println("TRAIN SCHEDULE");
        System.out.println("--------------");
        for (int i = 0; i < size; i++) {
            System.out.println(tempArriveTimes.poll().intValue() + "-" + tempDepartTimes.poll().intValue());
        }
        System.out.println();
    }

    /**
     * Calculates when a given truck reaches important milestones
     */
    private static void calculateTruckTimes() throws NullPointerException {
        final double TIME_TO_CROSSING = 3000 / 30;
        final double TIME_FROM_CROSSING = 27000 / 30;

        Queue<Truck> waitlist = new ArrayDeque<>();
        double truckStart = -15;

        for (Truck truck : trucks) {
            truckStart += 15;

            truck.setStart(truckStart);
            truck.setAtCrossing(truck.getStart() + TIME_TO_CROSSING);
            events.add(new Event(truck.getStart(), "TRUCK #" + truck.getIdentifier() + " begins journey"));

            // All trains have departed
            if (trainArriveTimes.isEmpty() && trainDepartTimes.isEmpty()) {
                truck.setCross(truck.getAtCrossing());
                truck.setEnd(truck.getCross() + TIME_FROM_CROSSING);
                events.add(new Event(truck.getCross(), "TRUCK #" + truck.getIdentifier() + " crosses crossing"));
                events.add(new Event(truck.getEnd(), "TRUCK #" + truck.getIdentifier() + " completes journey"));
                continue;
            }
            // Train at crossing
            if (truck.getAtCrossing() >= trainArriveTimes.peek() && truck.getAtCrossing() < trainDepartTimes.peek()) {
                waitlist.add(truck);
                events.add(new Event(truck.getAtCrossing(), "TRUCK #" + truck.getIdentifier() + " waits at crossing"));
            }
            // No train at crossing
            else {
                // Waitlist is empty
                if (waitlist.size() == 0) {
                    truck.setCross(truck.getAtCrossing());
                    truck.setEnd(truck.getCross() + TIME_FROM_CROSSING);
                    events.add(new Event(truck.getCross(), "TRUCK #" + truck.getIdentifier() + " crosses crossing"));
                    events.add(new Event(truck.getEnd(), "TRUCK #" + truck.getIdentifier() + " completes journey"));
                }
                // Waitlist is not empty
                else {
                    waitlist.add(truck);
                    Event tempEvent = new Event(truck.getAtCrossing(),
                            "TRUCK #" + truck.getIdentifier() + " waits at crossing");
                    events.add(tempEvent);
                    int i = 0;
                    double tempCross = 0;
                    for (Truck wait : waitlist) {
                        wait.setCross(trainDepartTimes.peek() + ++i);
                        wait.setEnd(wait.getCross() + TIME_FROM_CROSSING);
                        events.add(new Event(wait.getCross(), "TRUCK #" + wait.getIdentifier() + " crosses crossing"));
                        events.add(new Event(wait.getEnd(), "TRUCK #" + wait.getIdentifier() + " completes journey"));
                        tempCross = wait.getCross();
                    }
                    // Checks if the truck is trying to wait after it has crossed
                    if (truck.getAtCrossing() >= tempCross) {
                        events.remove(tempEvent);
                    }
                    waitlist.clear();
                    events.add(new Event(trainArriveTimes.poll(), "TRAIN arrives at crossing"));
                    events.add(new Event(trainDepartTimes.poll(), "TRAIN leaves crossing"));
                }
            }
        }
        // Checks if there is still anything left in the waitlist at the end
        if (waitlist.size() != 0) {
            int i = 0;
            for (Truck wait : waitlist) {
                wait.setCross(trainDepartTimes.peek() + ++i);
                wait.setEnd(wait.getCross() + TIME_FROM_CROSSING);
                events.add(new Event(wait.getCross(), "TRUCK #" + wait.getIdentifier() + " crosses crossing"));
                events.add(new Event(wait.getEnd(), "TRUCK #" + wait.getIdentifier() + " completes journey"));
            }
            events.add(new Event(trainArriveTimes.poll(), "TRAIN arrives at crossing"));
            events.add(new Event(trainDepartTimes.poll(), "TRAIN leaves crossing"));
        }
        // Runs through the rest of the trains if there are any left
        while (trainArriveTimes.size() != 0) {
            events.add(new Event(trainArriveTimes.poll(), "TRAIN arrives at crossing"));
            events.add(new Event(trainDepartTimes.poll(), "TRAIN leaves crossing"));
        }
    }

    /**
     * Prints truck statistics to the terminal
     */
    private static void printTruckStats() {
        System.out.println("\nSTATS");
        System.out.println("-----");
        double allTotalTime = 0;
        for (Truck truck : trucks) {
            System.out
                    .println("TRUCK #" + truck.getIdentifier() + " total trip time: " + truck.totalTime() + " minutes");
            allTotalTime += truck.totalTime();
            if (truck.getEnd() > totalTruckTime) {
                totalTruckTime = truck.getEnd();
            }
        }
        System.out.printf("\nTRUCK AVG TRIP TIME: %.1f minutes\n", (allTotalTime / numTrucks));
        System.out.println("TRUCK TOTAL TIME: " + totalTruckTime + " minutes");
    }

    /**
     * Prints all important events to standard output
     */
    public static void eventTracking() {
        try {
            calculateTruckTimes();
        } catch (NullPointerException e) {
            // Does nothing
        }

        Collections.sort(events);
        for (Event event : events) {
            System.out.println(event);
        }
    }
}