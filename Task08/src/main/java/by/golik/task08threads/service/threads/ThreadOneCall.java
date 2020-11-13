package by.golik.task08threads.service.threads;

import by.golik.task08threads.beans.Matrix;
import by.golik.task08threads.service.MatrixCreator;
import com.sun.tools.javac.Main;

import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nikita Golik
 */
public class ThreadOneCall  {
    public static final int NUMBER_ONE = 111;

//    MatrixCreator matrixCreator = new MatrixCreator();
//    Semaphore sem;
//    String name;


//    public ThreadOneCall(MatrixCreator matrixCreator, Semaphore sem, String name) {
//        this.matrixCreator = matrixCreator;
//        this.sem = sem;
//        this.name = name;
//    }

//    public ThreadOneCall(Matrix matrix, String name) {
//        this.name = name;
//
//    }

//    public Matrix call() throws Exception {
//
//        try {
//            System.out.println(name + " ожидает разрешение");
//
//
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
//        }
//        System.out.println(name + " освобождает разрешение");
//
//
//    }
}
