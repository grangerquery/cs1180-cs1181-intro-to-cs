import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * Contains all the information of the game of Minesweeper
 * 
 * @author Brayden Granger
 * @since 03/08/2024
 */
public class Minesweeper extends JFrame {
    private JPanel content = new JPanel(); // The main content pane
    private JPanel center = new JPanel(); // The center panel
    private JPanel east = new JPanel(); // The east panel
    private JPanel south = new JPanel(); // The south panel
    private ArrayList<Space> spaces = new ArrayList<>(); // The spaces contained in the game
    private boolean hardMode; // Whether the game is on hard mode
    private boolean gameOver; // Whether the game is over
    private int numMines; // The number of mines
    private int numRevealed; // The number of revealed spaces
    private long start; // The starting time
    private long finish; // The ending time
    private JCheckBox flagButton; // The flag button
    private File easyFile = new File("src\\Scores\\EasyScores.txt"); // The easy scores file
    private File hardFile = new File("src\\Scores\\HardScores.txt"); // The hard scores file
    private JTextField userName; // The user's name

    /**
     * The constructor for the game of Minesweeper
     */
    public Minesweeper() {
        super("Minesweeper");
        content.setLayout(new BorderLayout());
        setContentPane(content);

        // Center panel: Main game, grid layout
        createCenter();

        // East panel: Leaderboards, setting name
        createEast();

        // South panel: Control bar
        createSouth();
    }

    /**
     * Displays the help menu
     * This should only be called at the beginning of the game
     */
    public void displayHelp() {
        JOptionPane.showMessageDialog(center,
                "The objective of the game is to clear the board without"
                        + " setting off any mines.\n\nThe number on a space indicates"
                        + " how many mines surround it in a 3x3 grid.\nIf you think a"
                        + " space is a mine, you can mark it by entering Flag Mode."
                        + " \n\nUse the control bar at the bottom to reset, enter Flag"
                        + " Mode, or change difficulty.\nTo save your time, enter your"
                        + " name in the top right.");
    }

    /**
     * Reveals a given space
     * This should only be called within setBehavior and revealConnectedSpace
     * 
     * @param space The space
     */
    private void reveal(Space space) {
        numRevealed++;
        space.setRevealed(true);
        space.setSelected(true);
        space.setIcon(null);

        // Checks if the space is a mine
        if (space.isMine()) {
            if (hardMode) {
                space.setIcon(new ImageIcon("src\\Icons\\minesm.png"));
            } else {
                space.setIcon(new ImageIcon("src\\Icons\\mine.png"));
            }
        }
        // Else if the space has a number
        else {
            switch (space.getNumSurroundingMines()) {
                case 1:
                    if (hardMode) {
                        space.setIcon(new ImageIcon("src\\Icons\\1sm.png"));
                    } else {
                        space.setIcon(new ImageIcon("src\\Icons\\1.png"));
                    }
                    break;
                case 2:
                    if (hardMode) {
                        space.setIcon(new ImageIcon("src\\Icons\\2sm.png"));
                    } else {
                        space.setIcon(new ImageIcon("src\\Icons\\2.png"));
                    }
                    break;
                case 3:
                    if (hardMode) {
                        space.setIcon(new ImageIcon("src\\Icons\\3sm.png"));
                    } else {
                        space.setIcon(new ImageIcon("src\\Icons\\3.png"));
                    }
                    break;
                case 4:
                    if (hardMode) {
                        space.setIcon(new ImageIcon("src\\Icons\\4sm.png"));
                    } else {
                        space.setIcon(new ImageIcon("src\\Icons\\4.png"));
                    }
                    break;
                case 5:
                    if (hardMode) {
                        space.setIcon(new ImageIcon("src\\Icons\\5sm.png"));
                    } else {
                        space.setIcon(new ImageIcon("src\\Icons\\5.png"));
                    }
                    break;
                case 6:
                    if (hardMode) {
                        space.setIcon(new ImageIcon("src\\Icons\\6sm.png"));
                    } else {
                        space.setIcon(new ImageIcon("src\\Icons\\6.png"));
                    }
                    break;
                case 7:
                    if (hardMode) {
                        space.setIcon(new ImageIcon("src\\Icons\\7sm.png"));
                    } else {
                        space.setIcon(new ImageIcon("src\\Icons\\7.png"));
                    }
                    break;
                case 8:
                    if (hardMode) {
                        space.setIcon(new ImageIcon("src\\Icons\\8sm.png"));
                    } else {
                        space.setIcon(new ImageIcon("src\\Icons\\8.png"));
                    }
                    break;
            }
        }
    }

    /**
     * Reveals all connecting empty spaces recursively, stopping at numbers
     * This should only be called within setBehavior
     * 
     * @param space The space
     */
    private void revealConnectedSpaces(Space space) {
        ArrayList<Space> toReveal = new ArrayList<>();
        for (Space other : spaces) {
            // Left, up (x - 1, y - 1)
            if (other.getXPosition() == space.getXPosition() - 1 && other.getYPosition() == space.getYPosition() - 1) {
                toReveal.add(other);
            }
            // Up (x, y - 1)
            if (other.getXPosition() == space.getXPosition() && other.getYPosition() == space.getYPosition() - 1) {
                toReveal.add(other);
            }
            // Right, up (x + 1, y - 1)
            if (other.getXPosition() == space.getXPosition() + 1 && other.getYPosition() == space.getYPosition() - 1) {
                toReveal.add(other);
            }
            // Left (x - 1, y)
            if (other.getXPosition() == space.getXPosition() - 1 && other.getYPosition() == space.getYPosition()) {
                toReveal.add(other);
            }
            // Right (x + 1, y)
            if (other.getXPosition() == space.getXPosition() + 1 && other.getYPosition() == space.getYPosition()) {
                toReveal.add(other);
            }
            // Left, down (x - 1, y + 1)
            if (other.getXPosition() == space.getXPosition() - 1 && other.getYPosition() == space.getYPosition() + 1) {
                toReveal.add(other);
            }
            // Down (x, y + 1)
            if (other.getXPosition() == space.getXPosition() && other.getYPosition() == space.getYPosition() + 1) {
                toReveal.add(other);
            }
            // Right, down (x + 1, y + 1)
            if (other.getXPosition() == space.getXPosition() + 1 && other.getYPosition() == space.getYPosition() + 1) {
                toReveal.add(other);
            }
        }

        for (Space notRevealed : toReveal) {
            // Checks that the space hasn't been revealed yet
            if (!notRevealed.isRevealed()) {
                reveal(notRevealed);
                // Checks if the revealed space is a 0
                if (notRevealed.getNumSurroundingMines() == 0) {
                    revealConnectedSpaces(notRevealed);
                }
            }
        }
    }

    /**
     * Counts the number of mines surrounding a given space
     * This should only be called within setBehavior
     * 
     * @param space The space
     * @return The number of surrounding mines
     */
    private void countSurroundingMines(Space space) {
        space.setNumSurroundingMines(0);
        for (Space other : spaces) {
            if (other.isMine()) {
                // Left, up (x - 1, y - 1)
                if (other.getXPosition() == space.getXPosition() - 1
                        && other.getYPosition() == space.getYPosition() - 1) {
                    space.setNumSurroundingMines(space.getNumSurroundingMines() + 1);
                }
                // Up (x, y - 1)
                if (other.getXPosition() == space.getXPosition() && other.getYPosition() == space.getYPosition() - 1) {
                    space.setNumSurroundingMines(space.getNumSurroundingMines() + 1);
                }
                // Right, up (x + 1, y - 1)
                if (other.getXPosition() == space.getXPosition() + 1
                        && other.getYPosition() == space.getYPosition() - 1) {
                    space.setNumSurroundingMines(space.getNumSurroundingMines() + 1);
                }
                // Left (x - 1, y)
                if (other.getXPosition() == space.getXPosition() - 1 && other.getYPosition() == space.getYPosition()) {
                    space.setNumSurroundingMines(space.getNumSurroundingMines() + 1);
                }
                // Right (x + 1, y)
                if (other.getXPosition() == space.getXPosition() + 1 && other.getYPosition() == space.getYPosition()) {
                    space.setNumSurroundingMines(space.getNumSurroundingMines() + 1);
                }
                // Left, down (x - 1, y + 1)
                if (other.getXPosition() == space.getXPosition() - 1
                        && other.getYPosition() == space.getYPosition() + 1) {
                    space.setNumSurroundingMines(space.getNumSurroundingMines() + 1);
                }
                // Down (x, y + 1)
                if (other.getXPosition() == space.getXPosition() && other.getYPosition() == space.getYPosition() + 1) {
                    space.setNumSurroundingMines(space.getNumSurroundingMines() + 1);
                }
                // Right, down (x + 1, y + 1)
                if (other.getXPosition() == space.getXPosition() + 1
                        && other.getYPosition() == space.getYPosition() + 1) {
                    space.setNumSurroundingMines(space.getNumSurroundingMines() + 1);
                }
            }
        }
    }

    /**
     * Checks if the user has won the game
     * This should only be called within setBehabior
     * 
     * @return Whether the user won the game
     */
    private boolean checkWinStatus() {
        if (hardMode) {
            if (numRevealed == (14 * 14) - numMines) {
                return true;
            }
        } else {
            if (numRevealed == (9 * 9) - numMines) {
                return true;
            }
        }
        return false;
    }

    /**
     * Executes the end of the game
     * This should only be called within setBehavior
     * 
     * @param lostGame Whether the game was lost
     */
    private void endGame(boolean lostGame) {
        finish = System.currentTimeMillis();
        int totalTime = (int) (finish - start);
        gameOver = true;

        // Reveals all
        for (Space space : spaces) {
            if (!space.isRevealed()) {
                space.setEnabled(false);
                reveal(space);
                space.setSelected(false);
            }
        }

        // Lost game
        if (lostGame) {
            JOptionPane.showMessageDialog(center, "You lost.");
        }
        // Won game
        else {
            int timeSeconds = totalTime / 1000;
            int adjustedMinutes = timeSeconds / 60;
            int adjustedSeconds = timeSeconds % 60;

            if (adjustedMinutes > 99) {
                adjustedMinutes = 99;
                adjustedSeconds = 59;
            }

            if (userName.getText().equals("")) {
                JOptionPane.showMessageDialog(center, "You won! No time was taken.");
            } else {
                JOptionPane.showMessageDialog(center, "You won! Taking time.");

                String toAdd = userName.getText();
                PrintWriter pw;
                // Hard mode scores
                try {
                    if (hardMode) {
                        pw = new PrintWriter(new FileWriter(hardFile, true));
                        pw.printf("%02dm %02ds, " + toAdd + "\n", adjustedMinutes, adjustedSeconds);
                        pw.close();
                    }
                    // Easy mode scores
                    else {
                        pw = new PrintWriter(new FileWriter(easyFile, true));
                        pw.printf("%02dm %02ds, " + toAdd + "\n", adjustedMinutes, adjustedSeconds);
                        pw.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                east.removeAll();
                east.updateUI();
                createEast();
                userName.setText(toAdd);
            }
        }
    }

    /**
     * Sets the behavior of a space
     * This should only be called within createCenter
     * 
     * @param space The space
     */
    private void setBehavior(Space space) {
        countSurroundingMines(space);

        // When clicked...
        space.addActionListener(e -> {
            // Checks if Flag Mode is enabled
            if (flagButton.isSelected() && !space.isRevealed()) {
                space.setSelected(false);
                if (space.isFlag()) {
                    space.setIcon(null);
                    space.setFlag(false);
                } else if (hardMode) {
                    space.setIcon(new ImageIcon("src\\Icons\\flagsm.png"));
                    space.setFlag(true);
                } else {
                    space.setIcon(new ImageIcon("src\\Icons\\flag.png"));
                    space.setFlag(true);
                }
            } else {
                space.setSelected(true);
                // Checks if the game is over
                if (!gameOver && !space.isRevealed()) {
                    reveal(space);

                    // Checks if the space is a mine
                    if (space.isMine()) {
                        space.setBackground(Color.RED);
                        space.setSelected(false);
                        endGame(true);
                    }
                    // Checks if the space is empty
                    else if (space.getNumSurroundingMines() == 0) {
                        revealConnectedSpaces(space);
                    }
                }
            }
            // Checks if the user won the game
            if (checkWinStatus() && !gameOver) {
                endGame(false);
            }
        });
    }

    /**
     * Creates the center panel
     * This should only be called within the constructor
     * 
     * @see https://www.baeldung.com/java-measure-elapsed-time Referenced to
     *      understand how to keep track of time
     */
    private void createCenter() {
        numRevealed = 0;
        start = System.currentTimeMillis();
        gameOver = false;

        int xSize, ySize;
        if (!hardMode) {
            xSize = 9;
            ySize = 9;
        } else {
            xSize = 14;
            ySize = 14;
        }

        center.setLayout(new GridLayout(xSize, ySize));

        // Creates and adds spaces to center panel
        numMines = 0;
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                Space newSpace = new Space(j, i);
                if (newSpace.isMine()) {
                    numMines++;
                }
                center.add(newSpace);
                spaces.add(newSpace);
            }
        }
        content.add(center, BorderLayout.CENTER);

        // Sets behavior of spaces in center panel
        for (Space space : spaces) {
            setBehavior(space);
        }

        // Makes sure the number of mines isn't too small
        if (hardMode) {
            if (numMines < (14/(14*14))) {
                reloadCenter();
            }
        } else {
            if (numMines < (9/(9*9))) {
                reloadCenter();
            }
        }
    }

    /**
     * Displays a leaderboard
     * This should only be called within createEast
     * 
     * @param difficulty The file whose data is being displayed
     */
    private void displayLeaderboard(File file) {
        ArrayList<String> scores = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                scores.add(sc.nextLine());
            }

            // Get top 10
            Collections.sort(scores);
            for (int i = 0; i < 9; i++) {
                String[] splitted = scores.get(i).split(", ", 2);
                String labelText = splitted[0] + ": " + splitted[1];
                east.add(new JLabel(labelText));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the east panel
     * This should only be called within the constructor
     * 
     * @param content The content pane (border layout)
     */
    private void createEast() {
        east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));

        // 1px border right
        east.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 1));

        // Initialization of elements
        JLabel easyLead = new JLabel("Easy leaderboard:");
        JLabel hardLead = new JLabel("Hard leaderboard:");
        easyLead.setForeground(Color.BLUE);
        hardLead.setForeground(Color.RED);
        userName = new JTextField();

        // Adding elements
        east.add(new JLabel("Enter your name to save your times."));
        east.add(userName);
        east.add(new JLabel(" "));
        east.add(easyLead);
        displayLeaderboard(easyFile);
        east.add(new JLabel(" "));
        east.add(hardLead);
        displayLeaderboard(hardFile);
        east.add(new JLabel(" "));

        // Empty labels for better looking east panel
        for (int i = 0; i < 8; i++) {
            east.add(new JLabel(" "));
        }

        east.setPreferredSize(new Dimension(210, east.getHeight()));

        content.add(east, BorderLayout.EAST);
    }

    /**
     * Reloads the center panel
     * This should only be called within createSouth
     */
    private void reloadCenter() {
        spaces.clear();
        center.removeAll();
        center.updateUI();
        createCenter();
    }

    /**
     * Creates the south panel
     * This should only be called within the constructor
     */
    private void createSouth() {
        south.setLayout(new BoxLayout(south, BoxLayout.LINE_AXIS));

        // 1px border left, 2px border below
        south.setBorder(BorderFactory.createEmptyBorder(0, 1, 2, 0));

        // Initialization of elements
        flagButton = new JCheckBox("Flag mode");
        JButton reloadButton = new JButton("⟳");
        reloadButton.addActionListener(e -> {
            reloadCenter();
        });
        JButton easyButton = new JButton("Easy");
        easyButton.addActionListener(e -> {
            hardMode = false;
            reloadCenter();
        });
        JButton hardButton = new JButton("Hard");
        hardButton.addActionListener(e -> {
            hardMode = true;
            reloadCenter();
        });
        JButton helpButton = new JButton("?");
        helpButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(center,
                    "The objective of the game is to clear the board without"
                            + " setting off any mines.\n\nThe number on a space indicates"
                            + " how many mines surround it in a 3x3 grid.\nIf you think a"
                            + " space is a mine, you can mark it by entering Flag Mode."
                            + " \n\nUse the control bar at the bottom to reset, enter Flag"
                            + " Mode, or change difficulty.\nTo save your time, enter your"
                            + " name in the top right.");
        });

        // Adding elements
        south.add(reloadButton);
        south.add(flagButton);

        // Creating a large break between elements
        String breakText = "";
        for (int i = 0; i < 89; i++) {
            breakText = breakText + " ";
        }
        south.add(new JLabel(breakText));
        south.add(easyButton);
        south.add(hardButton);
        south.add(helpButton);

        content.add(south, BorderLayout.SOUTH);
    }
}