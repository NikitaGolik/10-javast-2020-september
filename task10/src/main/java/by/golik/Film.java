package by.golik;

import java.math.BigDecimal;

/**
 *     <complexType name="Film">
 *         <sequence>
 *             <element name="name" type="string"/>
 *             <element name="producer" type="string"/>
 *             <element name="country" type="string"/>
 *             <element name="film_characteristic" type="tns:FilmCharacteristic"/>
 *             <element name="rating" type="float"/>
 *         </sequence>
 *
 *         <attribute name="id" type="positiveInteger" use="optional"/>
 *         <attribute name="group" type="string" use="optional"/>
 *     </complexType>
 *
 *     <complexType name="FilmCharacteristic">
 *         <all>
 *             <element name="genre" type="string"/>
 *             <element name="budget" type="decimal"/>
 *             <element name="fees_in_the_world" type="decimal"/>
 *             <element name="production_year" type="int"/>
 *         </all>
 *
 * @author Nikita Golik
 */
public class Film {
    private String name;
    private String producer;
    private String country;
    private float rating;
    private String genre;
    private int budget;
    private int fees_in_the_world;
    private int production_year;

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    public String getCountry() {
        return country;
    }

    public float getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }

    public int getBudget() {
        return budget;
    }

    public int getFees_in_the_world() {
        return fees_in_the_world;
    }

    public int getProduction_year() {
        return production_year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setFees_in_the_world(int fees_in_the_world) {
        this.fees_in_the_world = fees_in_the_world;
    }

    public void setProduction_year(int production_year) {
        this.production_year = production_year;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", country='" + country + '\'' +
                ", rating=" + rating +
                ", genre='" + genre + '\'' +
                ", budget=" + budget +
                ", fees_in_the_world=" + fees_in_the_world +
                ", production_year=" + production_year +
                '}';
    }
}
