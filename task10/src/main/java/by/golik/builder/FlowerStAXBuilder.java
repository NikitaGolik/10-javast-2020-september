package by.golik.builder;

import by.golik.entity.Acanthus;
import by.golik.entity.Cactus;
import by.golik.entity.Flower;
import by.golik.exception.ParserException;

import javax.swing.text.Element;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Nikita Golik
 */
public class FlowerStAXBuilder extends AbstractFlowerBuilder {

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

    private static final String DEFAULT_ORIGIN = "Unknown";


    @Override
    public void buildFlowerList(String fileName) throws ParserException {
        Flower flower = null;
        FileInputStream inputStream = null;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try {
            inputStream = new FileInputStream(new File(fileName));

            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(inputStream);


            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();

                    if(startElement.getName().getLocalPart().equals(ACANTHUS)) {
                        flower = new Acanthus();
                        attributeParsing(flower, startElement);
                    }
                    if(startElement.getName().getLocalPart().equals(CACTUS)) {
                        flower = new Cactus();
                        attributeParsing(flower, startElement);
                    }
                    else {
                        if(startElement.getName().getLocalPart().equals(LEAF_COLOR)) {
                            xmlEvent = xmlEventReader.nextEvent();
                            flower.setLeaf_color(xmlEvent.asCharacters().getData());
                        } else {
                            if(startElement.getName().getLocalPart().equals(STEM_COLOR)) {
                                xmlEvent = xmlEventReader.nextEvent();
                                flower.setStem_color(xmlEvent.asCharacters().getData());
                            } else {
                                if(startElement.getName().getLocalPart().equals(TEMPERATURE)) {
                                    xmlEvent = xmlEventReader.nextEvent();
                                    flower.setTemperature(Integer.parseInt(xmlEvent.asCharacters().getData()));
                                } else {
                                    if (startElement.getName().getLocalPart().equals(SOIL)) {
                                        xmlEvent = xmlEventReader.nextEvent();
                                        flower.setSoil(xmlEvent.asCharacters().getData());
                                    } else {
                                        if(startElement.getName().getLocalPart().equals(AVERAGE_PLANT_SIZE)) {
                                            xmlEvent = xmlEventReader.nextEvent();
                                            flower.setAverage_plant_size(Integer.parseInt(xmlEvent.asCharacters().getData()));
                                        } else {
                                            if(startElement.getName().getLocalPart().equals(WATERING)) {
                                                xmlEvent = xmlEventReader.nextEvent();
                                                flower.setWatering(Integer.parseInt(xmlEvent.asCharacters().getData()));
                                            } else {
                                                if(startElement.getName().getLocalPart().equals(MULTIPLYING)) {
                                                    xmlEvent = xmlEventReader.nextEvent();
                                                    flower.setMultiplying(xmlEvent.asCharacters().getData());
                                                } else {
                                                    if(startElement.getName().getLocalPart().equals(LIGHT_REQUIRING)) {
                                                        xmlEvent = xmlEventReader.nextEvent();
                                                        flower.setLight_requiring(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if(xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if(endElement.getName().getLocalPart().equals(ACANTHUS) ||
                    endElement.getName().getLocalPart().equals(CACTUS)) {
                        firstFlowerList.add(flower);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            throw new ParserException("fail in staxbuilder", e);
        }
    }
    private void attributeParsing(Flower flower, StartElement startElement) {
        String flowerId = startElement.getAttributeByName(new QName(ID)).getValue();
        if(flowerId != null) {
            flower.setId(flowerId);
        }
        String flowerName = startElement.getAttributeByName(new QName(NAME)).getValue();
        if(flowerName != null) {
            flower.setName(flowerName);
        }
        if (startElement.getAttributeByName(new QName(ORIGIN)) == null) {
            flower.setOrigin(DEFAULT_ORIGIN);
        } else {
            String flowerOrigin = startElement.getAttributeByName(new QName(ORIGIN)).getValue();
            if(flowerOrigin != null) {
                flower.setOrigin(flowerOrigin);
            }
        }
    }
}
