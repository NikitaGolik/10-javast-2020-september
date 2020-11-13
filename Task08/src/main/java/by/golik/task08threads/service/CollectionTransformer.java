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

        for (int i=0; i<integers.size(); i++){
                elementsList.add(new Element(i,i,integers.get(i)));
            }
        return elementsList;
    }
}
