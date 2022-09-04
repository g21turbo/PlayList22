import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    //Album variables
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    //Constructor
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }


    //Add a song to an album, pass title and duration
    //Using the findSong methods passed title,
    //If that title equals null, add the new song's title and duration to the album
    public boolean addSong(String title, double duration){


        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    //Pass a song title, create checkedSong object
    //Checked song takes the value of th ordered list items
    //If checkedSong's title equals the passed title return that specified item from the list
    private Song findSong(String title) {
        for (Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }

    //Add song to playlist by track number
    //int index variable equals track number minus 1 because elements start at zero, not 1
    //If index is greater than or equal to 0, and it's less than or equal to arrayList size
    //add the song to the specified playList
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.songs.size())){
            playList.add(this.songs.get(index));
            return true;
        }
        //If the song is not on the album, this message will display
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    //Add song to playList by title
    //Checked song object equals title passed in findSong method
    //If checkedSong is not equal to null, add song to specified playList
    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        //If the song is not on the album, this message will display
        System.out.println("The song " + title + " is not in this album");
        return false;
    }



}
