package by.golik.task10web.builder;

import by.golik.task10web.entity.Acanthus;
import by.golik.task10web.entity.Cactus;
import by.golik.task10web.entity.Flower;
import by.golik.task10web.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * @author Nikita Golik
 */
public class FlowerSAXBuilder extends AbstractFlowerBuilder {

    private Logger logger = LogManager.getLogger(FlowerSAXBuilder.class);

    private Handler handler = new Handler();

    public FlowerSAXBuilder() {

    }

    /**
     * realization of ContentHandler
     */

    private class Handler extends DefaultHandler {
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

        private boolean flagLeafColor = false;
        private boolean flagStemColor = false;
        private boolean flagTemperature = false;
        private boolean flagSoil = false;
        private boolean flagAveragePlantSize = false;
        private boolean flagWatering = false;
        private boolean flagMultiplying = false;
        private boolean flagLightRequiring = false;

        private Flower flower;

        /**
         * will be called when the analyzer has completely processed the content
         * opening tag
         * @param uri - unique name space
         * @param localName - name of element without prefix
         * @param qName - full name of element with prefix
         * @param attributes - list of attributes
         * @throws SAXException - exception during sax parser
         */
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals(ACANTHUS)) {
                flower = new Acanthus();
            } else if (qName.equals(CACTUS)) {
                flower = new Cactus();
            } else {
                if (qName.equals(LEAF_COLOR)) {
                    flagLeafColor = true;
                } else {
                    if (qName.equals(STEM_COLOR)) {
                        flagStemColor = true;
                    } else {
                        if (qName.equals(TEMPERATURE)) {
                            flagTemperature = true;
                        } else {
                            if (qName.equals(SOIL)) {
                                flagSoil = true;
                            } else {
                                if (qName.equals(AVERAGE_PLANT_SIZE)) {
                                    flagAveragePlantSize = true;
                                } else {
                                    if (qName.equals(WATERING)) {
                                        flagWatering = true;
                                    } else {
                                        if (qName.equals(MULTIPLYING)) {
                                            flagMultiplying = true;
                                        } else {
                                            if (qName.equals(LIGHT_REQUIRING)) {
                                                flagLightRequiring = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            /** get and display information about element attributes */
            for (int i = 0; i < attributes.getLength(); i++) {
                attributesCharacters(attributes.getLocalName(i), attributes.getValue(i));
            }
        }

        /**
         * method to fill attributes
         * @param attribute - attribute of flower
         * @param value value from xml file for concrete flower
         */
        public void attributesCharacters(String attribute, String value) {

            if (attribute.equals(ID)) {
                flower.setId(value);
            } else {
                if (attribute.equals(NAME)) {
                    flower.setName(value);
                } else {
                    if (attribute.equals(ORIGIN)) {
                        flower.setOrigin(value);
                    }
                }
            }
        }

        /**
         *
         * is called in the event that
         * if the parser encountered symbolic information inside an element (body tag)
         * @param ch - definition of tag
         * @param start start of tag element
         * @param length - length content of tag
         * @throws SAXException - exception during sax
         */
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if(flagLeafColor) {
                flower.setLeaf_color(new String(ch, start, length));
                flagLeafColor = false;
            } else {
                if(flagStemColor) {
                    flower.setStem_color(new String(ch, start, length));
                    flagStemColor = false;
                } else {
                    if (flagTemperature) {
                        flower.setTemperature(Integer.parseInt(new String(ch, start, length)));
                        flagTemperature = false;
                    } else {
                        if (flagSoil) {
                            flower.setSoil(new String(ch, start, length));
                            flagSoil = false;
                        } else {
                            if(flagAveragePlantSize) {
                                flower.setAverage_plant_size(Integer.parseInt(new String(ch, start, length)));
                                flagAveragePlantSize = false;
                            } else {
                                if (flagWatering) {
                                    flower.setWatering(Integer.parseInt(new String(ch, start, length)));
                                    flagWatering = false;
                                } else {
                                    if (flagMultiplying) {
                                        flower.setMultiplying(new String(ch, start, length));
                                        flagMultiplying = false;
                                    } else {
                                        if (flagLightRequiring) {
                                            flower.setLight_requiring(Boolean.parseBoolean(new String(ch, start, length)));
                                            flagLightRequiring = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        /**
         *
         * signals the end of an element
         * @param uri - unique name space
         * @param localName - name of element without prefix
         * @param qName - full name of element with prefix
         * @throws SAXException - exception during sax parsing
         */
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals(ACANTHUS) || (qName.equals(CACTUS))) {
                flowerHashSet.add(flower);
                logger.info(getFlowerSet().toString());
                logger.info("\nParsing ended");
            }
        }
    }


    /**
     * create list of flowers
     * @param fileName - name of xml file
     * @throws ParserException - exception during parser
     */
    @Override
    public void buildFlowerList(String fileName) throws ParserException {
        logger.info("Start SAX Parser");

        /** create SAX analizator */
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(fileName, handler);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new ParserException("Fail in SAXBuilder", e);
        }
    }
}
