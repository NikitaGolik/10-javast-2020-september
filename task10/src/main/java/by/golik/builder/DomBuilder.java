package by.golik.builder;

import by.golik.entity.Acanthus;
import by.golik.entity.Cactus;
import by.golik.entity.Flower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Nikita Golik
 */
public class DomBuilder {

    static final Logger logger = LogManager.getLogger(DomBuilder.class);
    private Set<Flower> flowers = new HashSet<>();
    private DocumentBuilder docBuilder;


    public DomBuilder () {


        // создание DOM-анализатора
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }


    public void buildSetFlowers(String fileName) {
        Document doc = null;
        try {
            // parsing XML-документа и создание древовидной структуры
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            // получение списка дочерних элементов <student>
            buildSetByTagName("acanthus", root);
            buildSetByTagName("cactus", root);

        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }

    private Flower buildFlower(Element flowerElement) {
        Flower flower = null;
        // заполнение объекта film

        switch (flowerElement.getTagName()) {
            case "acanthus" :
                flower = new Acanthus();
                ((Acanthus) flower).setName(getElementTextContent(flowerElement, "name"));
                ((Acanthus) flower).setOrigin(getElementTextContent(flowerElement, "origin"));
                break;
            case "cactus" :
                flower = new Cactus();
                ((Cactus) flower).setName(getElementTextContent(flowerElement, "name"));
                ((Cactus) flower).setOrigin(getElementTextContent(flowerElement, "origin"));
                break;
        }

        return flower;
    }

    private void buildSetByTagName(String tagName, Element root) {

        logger.debug((root.getElementsByTagName(tagName)).getLength());

        NodeList flowersList = root.getElementsByTagName(tagName);

        for (int i = 0; i < flowersList.getLength(); i++) {
                Element flowerElement = (Element) flowersList.item(i);
                Flower flower = buildFlower(flowerElement);
                flowers.add(flower);

        }
    }
    // получение текстового содержимого тега
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
