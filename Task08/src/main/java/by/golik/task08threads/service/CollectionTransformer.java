package by.golik.task08threads.service;
import by.golik.task08threads.beans.Element;
import by.golik.task08threads.beans.Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Nikita Golik
 */
public class CollectionTransformer {

    public List<Element> transform(List<Integer> integers) throws Exception {
        List<Element> elementsList = new ArrayList<>();
        Matrix matrix;
        MatrixCreator matrixCreator = new MatrixCreator();
        matrix = matrixCreator.fillFromFile();

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                elementsList.add(new Element(i, j, matrix.get(i,j)));
            }
        }
            System.out.println("Size" + elementsList.size());
            return elementsList;
        }
}
