package by.golik.jwdcourse.task03.beans;
import java.util.ArrayList;

/**
 * The class is used to store vault object .
 * <b>baskets</b>
 */
public class Vault {

    private ArrayList<Basket> baskets;

    /**
     * constructor that creates an object Value.
     */
    public Vault() {
        this.baskets = new ArrayList<>();
    }

    /**
     * getting baskets that located in vault.
     * @return list of baskets in value.
     */
    public ArrayList<Basket> getBaskets() {
        return baskets;
    }

    /**
     * define list balls in vault
     * @param baskets list of baskets ib vault.
     */
    public void setBaskets(ArrayList<Basket> baskets) {
        this.baskets = baskets;
    }
    //TODO TOSTRING
}
