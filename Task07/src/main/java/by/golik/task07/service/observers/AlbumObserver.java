package by.golik.task07.service.observers;

/**
 * @author Nikita Golik
 */
public class AlbumObserver implements Observer {

    private int countAlbums;

    public int getCountAlbums() {
        return countAlbums;
    }

    @Override
    public void update(int countOfAlbums) {
        countAlbums = countOfAlbums;
    }
}
