package by.golik.task08threads.service;
import by.golik.task08threads.beans.Element;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikita Golik
 */
public class CollectionTransformer {

    public List<Element> transform(List<Integer> integers) throws Exception {
        List<Element> elementsList = new ArrayList<>();

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                elementsList.add(new Element(i, j, integers.get(j)));
            }
        }
            System.out.println("Size" + elementsList.size());
            return elementsList;
        }
}
