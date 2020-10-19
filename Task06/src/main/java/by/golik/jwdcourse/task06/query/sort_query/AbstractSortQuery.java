package by.golik.jwdcourse.task06.query.sort_query;

import by.golik.jwdcourse.task06.query.BookQuery;

public abstract class AbstractSortQuery implements BookQuery {

    private final boolean isDescending;

    public AbstractSortQuery() {
        this.isDescending = false;
    }

    public AbstractSortQuery(boolean isDescending) {
        this.isDescending = isDescending;
    }

    public boolean isDescending() {
        return isDescending;
    }
}
