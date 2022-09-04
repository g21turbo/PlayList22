import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("AC/DC", "Back in Black");
        album.addSong("Hell's Bells", 5.10);
        album.addSong("Shoot To Thrill", 5.17);
        album.addSong("What Do You Do For Money Honey", 3.36);
        album.addSong("Given The Dog A Bone", 3.31);
        album.addSong("Let Me Put My Love Into You", 4.12);
        album.addSong("Back In Black", 4.17);
        album.addSong("You Shook Me All Night Long", 3.29);
        album.addSong("Have A Drink On Me", 4.01);
        album.addSong("Shake A Leg", 4.04);
        album.addSong("Rock And Roll Ain't Noise Pollution", 4.12);
        albums.add(album);

        album = new Album("Zac Brown Band", "Home Grown");
        album.addSong("Every Little Bit", 4.03);
        album.addSong("Whatever It Is", 3.09);
        album.addSong("Chicken Fried", 3.39);
        album.addSong("On This Train", 3.22);
        album.addSong("Better Day", 3.59);
        album.addSong("Valentines", 4.09);
        album.addSong("Curse Me", 3.44);
        album.addSong("Heather", 5.16);
        album.addSong("Junkyard", 4.00);
        album.addSong("These Days", 5.52);
        album.addSong("Tax Man Shoes", 2.58);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("Shoot To Thrill", playList);
        albums.get(0).addToPlayList("Back In Black", playList);
        albums.get(0).addToPlayList("You Shook Me All Night Long", playList);
        albums.get(0).addToPlayList("Have A Drink On Me", playList);
        albums.get(1).addToPlayList(7, playList);
        albums.get(1).addToPlayList(1, playList);
        albums.get(1).addToPlayList(4, playList);
        albums.get(1).addToPlayList(2, playList);

        play(playList);


    }


    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist.");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else{
                        System.out.println("We are at the start of the playlist.");
                        forward = true;
                    }

                    break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else  {
                            System.out.println("We have reached the end of the list.");
                        }
                    }
                    break;
                case 4:
                   printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play the next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("===============================");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("===============================");
    }
}
