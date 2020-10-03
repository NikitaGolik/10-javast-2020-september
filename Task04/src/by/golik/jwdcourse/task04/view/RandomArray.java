package by.golik.jwdcourse.task04.view;
import by.golik.jwdcourse.task04.view.impl.Reader;
import java.io.FileNotFoundException;

public class RandomArray implements Reader {

    /**
     * This method fills the array with random numbers.
     *
     * @return
     */
    public int[] fillByRandom() {
        int [] arrayRandom = new int[10];
        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i] = ((int) (Math.random() * 31) - 15);
            System.out.println(arrayRandom[i]);
        }
        return arrayRandom;
    }


    @Override
    public int[] fillFromConsole() {
        return new int[0];
    }

    @Override
    public int[] fillFromFile() throws FileNotFoundException {
        return new int[0];
    }
}
