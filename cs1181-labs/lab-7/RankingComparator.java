import java.util.Comparator;

/**
 * A comparator class used for comparing two athletes
 * 
 * @author Brayden Granger
 * @since 03/05/2024
 */
public class RankingComparator implements Comparator<Athlete> {
    /**
     * Compares two athletes based on sport and ranking
     */
    @Override
    public int compare(Athlete a1, Athlete a2) {
        // First sort by sport
        if (a1.getSport().compareToIgnoreCase(a2.getSport()) != 0) {
            return a1.getSport().compareToIgnoreCase(a2.getSport());
        }
        // Then sort by ranking
        else if (a1.getRanking().compareTo(a2.getRanking()) != 0) {
            return a1.getRanking().compareTo(a2.getRanking());
        }
        // If same sport and same ranking
        else {
            return 0;
        }
    }
}
