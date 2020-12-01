package by.golik.entity;

import java.util.Objects;

/**
 * @author Nikita Golik
 */
public class Acanthus extends Flower {
    private static final String DEFAULT_ORIGIN = "Unknown";

    private String name;
    private String origin;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getOrigin() {
        if(origin == null || origin.isEmpty()) {
            return DEFAULT_ORIGIN;
        } else {
            return origin;
        }
    }

    @Override
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Acanthus)) return false;
        Acanthus acanthus = (Acanthus) o;

        return Objects.equals(getName(), acanthus.getName()) &&
                Objects.equals(getOrigin(), acanthus.getOrigin()) &&
                Objects.equals(getId(), acanthus.getId()) &&
                Objects.equals(getSoil(), acanthus.getSoil()) &&
                Objects.equals(getStem_color(), acanthus.getStem_color()) &&
                Objects.equals(getLeaf_color(), acanthus.getLeaf_color()) &&
                Objects.equals(getAverage_plant_size(), acanthus.getAverage_plant_size()) &&
                Objects.equals(getTemperature(), acanthus.getTemperature()) &&
                Objects.equals(getWatering(), acanthus.getWatering()) &&
                Objects.equals(getMultiplying(), acanthus.getMultiplying());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getOrigin(), getId(), getSoil(), getStem_color(), getLeaf_color(),
                getAverage_plant_size(), getTemperature(), getWatering(), getMultiplying());
    }

    @Override
    public String toString() {
        return "Acanthus{" +
                "'name=" + getName() + '\'' +
                ", 'origin=" + getOrigin() + '\'' +
                ", 'id=" + getId() + '\'' +
                ", 'soil=" + getSoil() + '\'' +
                ", 'stem_color=" + getStem_color() + '\'' +
                ", 'leaf_color=" + getLeaf_color() + '\'' +
                ", 'average_size=" + getAverage_plant_size() + '\'' +
                ", 'temperature=" + getTemperature() + '\'' +
                ", 'watering=" + getWatering() + '\'' +
                ", 'multiplying=" + getMultiplying() + "}";
    }
}
