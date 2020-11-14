package by.golik.task08threads.service;
import by.golik.task08threads.beans.Element;
import by.golik.task08threads.beans.Matrix;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikita Golik
 */
public class CollectionTransformer {

    /**
     * methods transforms list of Integer value to list of elements
     * @param integers - list of int values of matrix elements
     * @return new list of elements
     */
    public List<Element> transform(List<Integer> integers) {
        List<Element> elementsList = new ArrayList<>();
        Matrix matrix;
        MatrixCreator matrixCreator = new MatrixCreator();
        matrix = matrixCreator.fillFromFile();

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                elementsList.add(new Element(i, j, matrix.get(i, j)));
            }
        }
        System.out.println("Size" + elementsList.size());
        return elementsList;
    }
    public Object[][] trans(List<Element> elements) {

        int elementArray = elements.size()/10;
        Object[][] newArray = new Object[elementArray][10];

        for(int i = 0; i < elementArray; i++) {
            for(int j = 0; j < 10; j++) {
                int y = 10 * i;
                newArray[i][j] = elements.get(y + j);
                System.out.println(newArray[i][j].toString());
            }
        } return newArray;
    }

}
