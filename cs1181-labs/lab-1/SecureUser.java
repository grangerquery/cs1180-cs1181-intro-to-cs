/**
 * SecureUser - A class which extends from User
 * 
 * @author Brayden Granger
 * @since 1/16/2024
 */
public class SecureUser extends User {
    private int numAuthentications; // An integer representing number of authentications the user has attempted

    /**
     * SecureUser - A constructor which uses the parent class User
     * 
     * @param username A string representing the username
     * @param password A string representing the password
     */
    public SecureUser(String username, String password) {
        super(username, password);
        this.numAuthentications = 0;
    }

    /**
     * Authenticate - A method which uses the parent class User
     * 
     * Checks if the input password is equal to the stored password (case sensitive)
     * then checks the number of consecutive authentication attempts from the user
     * 
     * @param inputPassword A string representing the input password
     * @return Whether the input password both patches the password and the user has
     *         less than 4 attempts
     */
    public boolean authenticate(String inputPassword) {
        this.numAuthentications++; // Increments number of authentications
        if (super.authenticate(inputPassword)) {
            if (numAuthentications <= 3) {
                this.numAuthentications = 0;
                return true; // true -- number authentications <= 3
            } else {
                return false; // false -- number authentications > 3
            }
        } else {
            return false; // false -- incorrect password
        }
    }
}