package by.golik.jwdcourse.task03.beans;

import java.util.ArrayList;

/**
 *
 */
public class Vault {
    private ArrayList<Basket> baskets;

    /**
     *
     */
    public Vault() {
        this.baskets = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public ArrayList<Basket> getBaskets() {
        return baskets;
    }

    /**
     *
     * @param baskets
     */
    public void setBaskets(ArrayList<Basket> baskets) {
        this.baskets = baskets;
    }


    public void add(Basket newBasket)
    {
        this.baskets.add(newBasket);
    }

}
