package by.golik.task07.repository;

import by.golik.task07.entity.*;
import by.golik.task07.entity.BookType;

/**
 * @author Nikita Golik
 */
public class BookFactory {
    public Edition getEdition(BookType type) {
        Edition toReturn = null;

        switch (type) {
            case ALBUM:
                toReturn = new Album();
                break;
            case MAGAZINE:
                toReturn = new Magazine();
                break;
            case NEWSPAPER:
                toReturn = new Newspaper();
                break;
            default:
                throw new IllegalArgumentException("Wrong edition type" + type);
        }
        return toReturn;
    }
}
