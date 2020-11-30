package by.golik.builder;

import by.golik.entity.Acanthus;
import by.golik.entity.Cactus;
import by.golik.entity.Flower;
import by.golik.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author Nikita Golik
 */
public class FlowerDOMBuilder extends AbstractFlowerBuilder {

    private Logger logger = LogManager.getLogger(FlowerDOMBuilder.class);

    private final String ID = FLowerTag.FLOWERS_ID.toString().toLowerCase();
    private final String NAME = FLowerTag.NAME.toString().toLowerCase();
    private final String ORIGIN = FLowerTag.ORIGIN.toString().toLowerCase();
    private final String CACTUS = FLowerTag.CACTUS.toString().toLowerCase();
    private final String ACANTHUS = FLowerTag.ACANTHUS.toString().toLowerCase();
    private final String LEAF_COLOR = FLowerTag.LEAF_COLOR.toString().toLowerCase();
    private final String STEM_COLOR = FLowerTag.STEM_COLOR.toString().toLowerCase();
    private final String TEMPERATURE = FLowerTag.TEMPERATURE.toString().toLowerCase();
    private final String SOIL = FLowerTag.SOIL.toString().toLowerCase();
    private final String AVERAGE_PLANT_SIZE = FLowerTag.AVERAGE_PLANT_SIZE.toString().toLowerCase();
    private final String WATERING = FLowerTag.WATERING.toString().toLowerCase();
    private final String MULTIPLYING = FLowerTag.MULTIPLYING.toString().toLowerCase();
    private final String LIGHT_REQUIRING = FLowerTag.LIGHT_REQUIRING.toString().toLowerCase();


    /**
     *
     * @param fileName
     * @throws ParserException
     */
    @Override
    public void buildFlowerList(String fileName) throws ParserException {

        logger.info("Start DOM Parser");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;

        try {
            documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(fileName);
            document.getDocumentElement().normalize();

            NodeList acanthusList = document.getElementsByTagName(ACANTHUS);
            for (int i = 0; i < acanthusList.getLength(); i++) {
                Flower acanthus = new Acanthus();
                buildFlower(acanthusList, i, acanthus);
            }
            NodeList cactusList = document.getElementsByTagName(CACTUS);
            for (int i = 0; i < cactusList.getLength(); i++) {
                Flower cactus = new Cactus();
                buildFlower(cactusList, i, cactus);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new ParserException("fail in domBuilder", e);
        }
    }

    /**
     *
     * @param flowerList
     * @param i
     * @param flower
     */
    public void buildFlower(NodeList flowerList, int i, Flower flower) {
        Node node = flowerList.item(i);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element flowerElement = (Element) node;

            flower.setAverage_plant_size(Integer.parseInt(flowerElement.getElementsByTagName(AVERAGE_PLANT_SIZE).
                    item(0).getTextContent()));
            flower.setLeaf_color(flowerElement.getElementsByTagName(LEAF_COLOR).item(0).getTextContent());
            flower.setStem_color(flowerElement.getElementsByTagName(STEM_COLOR).item(0).getTextContent());
            flower.setSoil(flowerElement.getElementsByTagName(SOIL).item(0).getTextContent());
            flower.setTemperature(Integer.parseInt(flowerElement.getElementsByTagName(TEMPERATURE).item(0).getTextContent()));
            flower.setWatering(Integer.parseInt(flowerElement.getElementsByTagName(WATERING).item(0).getTextContent()));
            flower.setLight_requiring(Boolean.parseBoolean(flowerElement.getElementsByTagName(LIGHT_REQUIRING).item(0).getTextContent()));
            flower.setMultiplying(flowerElement.getElementsByTagName(MULTIPLYING).item(0).getTextContent());

            if (node.hasAttributes()) {
                NamedNodeMap nodeMap = node.getAttributes();
                for (int j = 0; j < nodeMap.getLength(); j++) {
                    Node currentNode = nodeMap.item(j);
                    if (currentNode.getNodeName().equals(ID)) {
                        flower.setId(currentNode.getNodeValue());
                    } else {
                        if (currentNode.getNodeName().equals(NAME)) {
                            flower.setName(currentNode.getNodeValue());
                        } else {
                            if (currentNode.getNodeName().equals(ORIGIN)) {
                                flower.setOrigin(currentNode.getNodeValue());
                            }
                        }

                    }
                }
            }
        } flowerHashSet.add(flower);
        logger.info(getFlowerSet());
    }
}

