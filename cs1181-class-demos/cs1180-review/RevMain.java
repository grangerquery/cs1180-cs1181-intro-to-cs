public class RevMain {
    public static void main(String[] args) {
        String myString = new String("Hello");
        int length = myString.length();

        Song mySong = new Song("Happy Birthday");
        Song yourSong = new Song("The Alphabet Song");

        // Can't do this because title isn't public
        // mySong.title = "Aud Lang Syne";

        mySong.setTitle("Aud Lang Syne");
    }
}
