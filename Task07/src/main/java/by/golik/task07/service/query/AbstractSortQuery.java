package by.golik.task07.service.query;

/**
 * Specification with boolean result. To sort list of books Ascending
 */
public abstract class AbstractSortQuery implements BookQuery {

    private final boolean isDescending;

    public AbstractSortQuery() {
        this.isDescending = false;
    }

    public boolean isDescending() {
        return isDescending;
    }
}
