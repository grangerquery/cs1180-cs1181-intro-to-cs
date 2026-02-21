import java.util.*;

/**
 * The game class, which controls everything about the Catacomb Crawler game and
 * includes the main driver
 * 
 * ADDITIONAL DELIVERABLE: The user has a 1/3 chance to find a gold coin in the
 * dungeon every time they move. Additionally, all monsters drop 3 gold. Gold is
 * displayed alongside the hero's name, health, and location.
 * 
 * @author Brayden Granger
 */
public class Game {

    /**
     * Waits a specified amount of time before executing more code
     * 
     * @param halfSeconds an integer representing how long to wait
     */
    public static void wait(int halfSeconds) {
        try {
            Thread.sleep(halfSeconds * 500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Clears the terminal
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Makes an actor that the user will control
     * 
     * @return an object representing the user-controlled actor
     */
    public static Actor makeActor() {
        Scanner sc = new Scanner(System.in);

        System.out.print("What is your name, heroic adventurer? ");
        String name = sc.nextLine();

        Actor hero = new Actor(name, 100, 10);
        return hero;
    }

    /**
     * Gets the size of the dungeon from the user
     * 
     * @return an integer representing the size of the dungeon
     */
    public static int getDungeonSize() {
        Scanner sc = new Scanner(System.in);
        int dungeonSize = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print("How wide of a dungeon do you want to face (5-10)? ");
                dungeonSize = sc.nextInt();
                if (dungeonSize < 5 || dungeonSize > 10) { // Dungeon must be 5-10 spaces wide
                    System.out.println("Invalid input");
                    valid = false;
                } else {
                    valid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                sc.next();
                valid = false;
            }
        }
        return dungeonSize;
    }

    /**
     * Creates an array list of monsters that populate the dungeon
     * 
     * @param dungeonSize an integer representing the size of the dungeon
     * @return an array list of actors representing the monsters
     */
    public static ArrayList<Actor> makeMonsters(int dungeonSize) {
        Random rnd = new Random();
        int rowNum = 0, colNum = 0;
        boolean valid = false;
        ArrayList<Actor> monsterList = new ArrayList<Actor>();

        int monsters = (dungeonSize * dungeonSize) / 6; // Calculates number of monsters

        for (int i = 0; i < monsters; i++) { // Creates and adds monsters to array list
            String name = "Monster " + (i + 1);
            monsterList.add(new Actor(name, 25, 5));

            while (!valid) { // Randomly sets monster location
                rowNum = rnd.nextInt(dungeonSize);
                colNum = rnd.nextInt(dungeonSize);

                if (rowNum == 0 && colNum == 0) { // Makes sure monster does not spawn on hero
                    valid = false;
                } else {
                    valid = true;
                }
            }
            // Sets row and column of monster
            monsterList.get(i).setRow(rowNum);
            monsterList.get(i).setCol(colNum);

            valid = false;
        }

        return monsterList;
    }

    /**
     * Causes the hero and a monster to fight until one dies
     * 
     * @param hero     an actor representing the hero
     * @param monsters an array list of actors representing the monsters
     */
    private static void fight(Actor hero, ArrayList<Actor> monsters) {
        for (Actor monster : monsters) { // Cycles through array list to find which monster the user ran into
            if (monster.getRow() == hero.getRow() && monster.getCol() == hero.getCol()) {
                do {
                    hero.exchangeBlows(monster);
                    wait(1);
                } while (hero.isAlive() && monster.isAlive()); // Keep exchanging blows until hero or monster is dead

                if (!monster.isAlive()) { // Removes monster from array list if dead and gives hero 3 gold
                    System.out.println(
                            "Monster " + (monsters.indexOf(monster) + 1) + " has been defeated\nYou got 3 gold!");
                    monsters.remove(monster);
                    hero.setGold(hero.getGold() + 3);
                    wait(5);
                    break;
                }
            }
        }
    }

    /**
     * Counts the number of monsters within one tile of the hero
     * 
     * @param hero     an actor representing the hero
     * @param monsters an array list of actors representing the monsters
     * @return the number of monsters near the hero
     */
    public static int countNearbyMonsters(Actor hero, ArrayList<Actor> monsters) {
        int count = 0;

        for (Actor monster : monsters) {
            if (hero.inAdjacentRoom(monster)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Checks if there is gold in a room
     * 
     * @return whether there is gold in a room
     */
    private static boolean foundGold() {
        Random rnd = new Random();
        int num = rnd.nextInt(3);

        if (num == 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Moves the hero in a specified direction
     * 
     * @param hero        an actor representing the hero
     * @param monsters    an array list of actors representing the monsters
     * @param dungeonSize an integer representing the size of the dungeon
     */
    public static void move(Actor hero, ArrayList<Actor> monsters, int dungeonSize) {
        Scanner sc = new Scanner(System.in);
        String direction = "";
        boolean valid = false;

        if (hero.getRow() != 0 && hero.getCol() != 0) {
            if (foundGold()) {
                System.out.println("You found 1 gold!");
                hero.setGold(hero.getGold() + 1);
            }
        }

        do {
            System.out.print("Which way do you want to go (north, east, south, west)? ");
            direction = sc.nextLine();

            if (!hero.canMove(direction, dungeonSize)) { // Makes sure the user can actually move in the direction
                System.out.println("You can\'t move that way!");
                valid = false;
            } else { // Hero takes 2 damage every time they move
                hero.setHealth(hero.getHealth() - 2);
                valid = true;
            }
        } while (!valid);

        switch (direction) {
            case "north":
                hero.setRow(hero.getRow() - 1);
                break;
            case "east":
                hero.setCol(hero.getCol() + 1);
                break;
            case "south":
                hero.setRow(hero.getRow() + 1);
                break;
            case "west":
                hero.setCol(hero.getCol() - 1);
                break;
            default:
                break;
        }

        for (Actor monster : monsters) { // Hero starts fighting if they run into a monster
            if (hero.getRow() == monster.getRow() && hero.getCol() == monster.getCol()) {
                fight(hero, monsters);
                break;
            }
        }
    }

    /**
     * The main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        clearScreen();
        System.out.println(
                "Welcome to catacomb crawlers. The goal of the game is to reach the exit before dying to the poisonous gas or a monster.");

        // Takes user input to set hero name and set dungeon size
        Actor hero = makeActor();
        int dungeonSize = getDungeonSize();

        // Spawns monsters
        ArrayList<Actor> monsters = makeMonsters(dungeonSize);

        // Gives user time to process the game is starting
        System.out.print("Game starting in 3 ");
        wait(2);
        System.out.print("2 ");
        wait(2);
        System.out.println("1 ");
        wait(2);

        do { // Game starts
            clearScreen();

            // Prints hero info and the number of monsters nearby to terminal
            System.out.println(hero.toString());
            System.out.println("You smell " + countNearbyMonsters(hero, monsters) + " monster(s) nearby");

            // Takes user input to move
            move(hero, monsters, dungeonSize);
        } while (hero.isAlive() && !hero.hasEscaped(dungeonSize)); // Game plays until hero dies or escapes

        if (!hero.isAlive()) { // Prints win/lose message to terminal
            System.out.println("GAME OVER : You have died.");
        } else if (hero.hasEscaped(dungeonSize)) {
            System.out.println("CONGRATULATIONS : You have escaped the dungeon! Your gold: " + hero.getGold());
        }
    }
}