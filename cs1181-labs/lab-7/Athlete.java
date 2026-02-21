/**
 * Class Athlete - Holds the information of an athlete
 * 
 * @author Brayden Granger
 * @sine 03/05/2024
 */
public class Athlete<T extends Comparable<T>> implements Comparable<Athlete> {
    private String name;
    private String sport;
    private T ranking;

    /**
     * An athlete constructor taking a name, sport, and raking as parameters
     * 
     * @param name    The athlete's name
     * @param sport   The athlete's sport
     * @param ranking The athlete's ranking
     */
    public Athlete(String name, String sport, T ranking) {
        this.name = name;
        this.sport = sport;
        this.ranking = ranking;
    }

    /**
     * Gets the athlete's name
     * 
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the athlete's sport
     * 
     * @return The sport
     */
    public String getSport() {
        return sport;
    }

    /**
     * Gets the athlete's ranking
     * 
     * @return The ranking
     */
    public T getRanking() {
        return ranking;
    }

    /**
     * Converts an athlete's information to a string
     * 
     * @return The information in the form "[name] ([sport] - [ranking])"
     */
    @Override
    public String toString() {
        return getName() + " (" + getSport() + " - " + getRanking() + ")";
    }

    /**
     * Compares two athletes based on sport and name
     * 
     * @param a The other athlete
     * @return The compared value
     */
    @Override
    public int compareTo(Athlete a) {
        // First sort by sport
        if (sport.compareToIgnoreCase(a.getSport()) != 0) {
            return sport.compareToIgnoreCase(a.getSport());
        }
        // Then sort by name
        else if (name.compareToIgnoreCase(a.getName()) != 0) {
            return name.compareToIgnoreCase(a.getName());
        }
        // If same sport and same name
        else {
            return 0;
        }
    }
}
