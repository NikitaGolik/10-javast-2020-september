package by.golik.task08threads.service;

import by.golik.task08threads.beans.Matrix;

import java.lang.reflect.Array;

/**
 * @author Nikita Golik
 */
public class MatrixModificator {

    public void modify(Matrix matrix) throws Exception {

        for(int i = 0; i < matrix.getVerticalSize(); i++) {
            for( int j = 0; j < matrix.getHorizontalSize(); j++) {
                if(i == j) {
                    matrix.setElement(i, j, 5);
                }
            }
        }
        System.out.println(matrix);
    }


}
