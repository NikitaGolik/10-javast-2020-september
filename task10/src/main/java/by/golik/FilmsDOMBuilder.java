package by.golik;

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
public class FilmsDOMBuilder {
    private Set<Film> films;
    private DocumentBuilder docBuilder;
    public FilmsDOMBuilder() {
        this.films = new HashSet<Film>();
        // создание DOM-анализатора
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }
    public Set<Film> getFilms() {
        return films;
    }
    public void buildSetFilms(String fileName) {
        Document doc = null;
        try {
// parsing XML-документа и создание древовидной структуры
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            // получение списка дочерних элементов <student>
            NodeList filmsList = root.getElementsByTagName("film");
            for (int i = 0; i < filmsList.getLength(); i++) {
                Element filmElement = (Element) filmsList.item(i);
                Film film = buildFilm(filmElement);
                films.add(film);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }
    private Film buildFilm(Element filmElement) {
        Film film = new Film();
        // заполнение объекта film

        film.setName(getElementTextContent(filmElement, "title"));
        film.setProducer(getElementTextContent(filmElement, "producer"));
        film.setCountry(getElementTextContent(filmElement,"country"));
        film.setRating(Float.parseFloat(getElementTextContent(filmElement, "rating")));
        film.setGenre(getElementTextContent(filmElement, "genre"));
        film.setBudget(Integer.parseInt(getElementTextContent(filmElement, "budget")));
        film.setFees_in_the_world(Integer.parseInt(getElementTextContent(filmElement, "fees_in_the_world")));
        film.setProduction_year(Integer.parseInt(getElementTextContent(filmElement, "production_year")));

        return film;
    }
    // получение текстового содержимого тега
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
