package week10.task4_songs;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Song> playlist = new ArrayList<>();
        playlist.add(new Song("Song 1", "Artist A", "Rock"));
        playlist.add(new Song("Song 2", "Artist B", "Pop"));
        playlist.add(new Song("Song 3", "Artist C", "Jazz"));
        playlist.add(new Song("Song 4", "Artist A", "Rock"));
        playlist.add(new Song("Song 5", "Artist D", "Pop"));

        // Create an instance of GenreFilterIterator for "Rock"
        GenreFilterIterator rockIterator = new GenreFilterIterator(playlist, "Rock");

        // Print details of songs with the genre "Rock"
        System.out.println("Songs with genre 'Rock':");
        while (rockIterator.hasNext()) {
            System.out.println(rockIterator.next());
        }
    }
}
