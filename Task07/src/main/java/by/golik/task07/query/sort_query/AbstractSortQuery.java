package by.golik.task07.query.sort_query;

import by.golik.task07.query.BookQuery;

public abstract class AbstractSortQuery implements BookQuery {

    private final boolean isDescending;

    public AbstractSortQuery() {
        this.isDescending = false;
    }

    public boolean isDescending() {
        return isDescending;
    }
}
