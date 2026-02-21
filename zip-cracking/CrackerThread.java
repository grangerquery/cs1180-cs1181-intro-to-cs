import java.io.File;
import java.util.ArrayList;
import net.lingala.zip4j.core.*;
import net.lingala.zip4j.exception.*;

/**
 * Class CrackerThread - a thread which is utilized to crack a
 * five-character-long password
 * 
 * @author Brayden Granger
 * @since 04/16/2024
 */
public class CrackerThread extends Thread {
    private ArrayList<String> passwords; // The passwords
    private String folder = ""; // The folder where zip contents will be extracted
    private static volatile boolean cracked = false; // Whether the correct password has been found
    private static volatile String correctPassword = ""; // The correct password

    /**
     * A CrackerThread constructor which takes in the passwords as a parameter
     * 
     * @param passwords The passwords
     */
    public CrackerThread(ArrayList<String> passwords) {
        this.passwords = passwords;
    }

    /**
     * Sets a CrackerThread's folder
     * 
     * @param folder The folder
     */
    public void setFolder(String folder) {
        this.folder = folder;
    }

    /**
     * Gets the correct password
     * 
     * This should only be called in Project.java
     * 
     * @return The correct password
     */
    public String getCorrectPassword() {
        return correctPassword;
    }

    /**
     * Recursively deletes the contents of a directory and then the directory itself
     * 
     * @param source The directory
     * @see https://www.baeldung.com/java-delete-directory Used to understand that
     *      the contents of a directory must be deleted before the directory itself
     *      can be deleted.
     */
    public void deleteDirectory(File source) {
        File[] files = source.listFiles();
        if (files != null) {
            for (File file : files) {
                deleteDirectory(file);
            }
        }
        source.delete();
    }

    /**
     * The instructions to be provided to run()
     * 
     * The purpose of having a separate method is so that I can create the zipfile
     * separately, which cuts down time. Using the zip4j library, I am unable to
     * declare a zipfile without passing in parameters, so this is my roundabout
     * solution.
     * 
     * @throws Exception
     */
    public void doWork() throws Exception {
        String thisCheck = "";
        ZipFile zipfile = new ZipFile("protected5.zip");
        for (String password : passwords) {
            // Once a password is found, all threads should terminate
            if (cracked) {
                deleteDirectory(new File(folder));
                break;
            }
            try {
                zipfile.setPassword(password);
                zipfile.extractAll(folder);
                correctPassword = password;
                cracked = true;
                new File(folder).renameTo(new File("protected5-contents"));
            } catch (ZipException ze) {
                // Incorrect password - do nothing
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        try {
            doWork();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
