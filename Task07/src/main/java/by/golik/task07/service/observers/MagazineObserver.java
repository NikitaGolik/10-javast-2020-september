package by.golik.task07.service.observers;

/**
 * @author Nikita Golik
 */
public class MagazineObserver implements Observer {

    private int countMagazines;

    public int getCountMagazines() {
        return countMagazines;
    }
    @Override
    public void update(int countOfMagazines) {
        countMagazines = countOfMagazines;
    }
}
