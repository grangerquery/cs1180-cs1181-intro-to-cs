/**
 * This program reads a 2D character array consisting of many '-' and one '+',
 * then prints the row and column of the '+' to the terminal.
 * 
 * @author Brayden Granger
 */
public class TreasureMap {

    /**
     * Prints the row and column of the '+' sign given a 2D character array
     * 
     * @see <a href=
     *      "https://www.w3docs.com/snippets/java/getting-the-array-length-of-a-2d-array-in-java.html">
     *      Referenced to understand how to find length of a 2D array</a>
     * 
     * @param map a 2D character array
     */
    public static void getCoordinates(char[][] map) {
        for (int i = 0; i < map.length; i++) { // i = row
            for (int j = 0; j < map[0].length; j++) { // j = column
                if (map[i][j] == '+') { // Checks if '+' has been found
                    System.out.println("Start digging in row " + i + ", column " + j);
                }
            }
        }
    }

    /**
     * The main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        char[][] map = { // 9 rows (0-8), 10 columns (0-9)
                { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                { '-', '-', '-', '-', '-', '-', '-', '-', '+', '-' },
                { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' }
        };

        getCoordinates(map);
    }
}