package by.golik.jwdcourse.task06.query.sort_query;

import by.golik.jwdcourse.task06.query.BookSpecification;

public abstract class AbstractSortSpecification implements BookSpecification {

    private final boolean isDescending;

    public AbstractSortSpecification() {
        this.isDescending = false;
    }

    public AbstractSortSpecification(boolean isDescending) {
        this.isDescending = isDescending;
    }

    public boolean isDescending() {
        return isDescending;
    }
}
