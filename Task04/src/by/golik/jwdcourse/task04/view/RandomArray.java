package by.golik.jwdcourse.task04.view;

import by.golik.jwdcourse.task04.view.impl.Reader;

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
    public int[] getReader() {
        return fillByRandom();
    }
}
