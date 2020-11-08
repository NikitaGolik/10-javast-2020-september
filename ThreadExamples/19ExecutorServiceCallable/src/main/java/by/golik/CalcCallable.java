package by.golik;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author Nikita Golik
 */
public class CalcCallable implements Callable<Number> {

    @Override
    public Number call() throws Exception {
        Number res = new Random().nextGaussian(); // имитация вычислений
        return res;
    }
}
