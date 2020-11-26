package by.golik;

import java.net.URISyntaxException;


/**
 * @author Nikita Golik
 */
public class Main {

    public static void main(String[] args) throws URISyntaxException {

        FilmsDOMBuilder domBuilder = new FilmsDOMBuilder();
        domBuilder.buildSetFilms("src/main/resources/data/films.xml");
        System.out.println(domBuilder.getFilms().toString());
    }
}
