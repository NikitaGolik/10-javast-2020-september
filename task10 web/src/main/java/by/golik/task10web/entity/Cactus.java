package by.golik.task10web.entity;

import java.util.Objects;

/**
 * @author Nikita Golik
 */
public class Cactus extends Flower {
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
        if (!(o instanceof Cactus)) return false;
        Cactus cactus = (Cactus) o;

        return Objects.equals(getName(), cactus.getName()) &&
                Objects.equals(getOrigin(), cactus.getOrigin()) &&
                Objects.equals(getId(), cactus.getId()) &&
                Objects.equals(getSoil(), cactus.getSoil()) &&
                Objects.equals(getStem_color(), cactus.getStem_color()) &&
                Objects.equals(getLeaf_color(), cactus.getLeaf_color()) &&
                Objects.equals(getAverage_plant_size(), cactus.getAverage_plant_size()) &&
                Objects.equals(getTemperature(), cactus.getTemperature()) &&
                Objects.equals(getWatering(), cactus.getWatering()) &&
                Objects.equals(getMultiplying(), cactus.getMultiplying());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getOrigin(), getId(), getSoil(), getStem_color(), getLeaf_color(),
                getAverage_plant_size(), getTemperature(), getWatering(), getMultiplying());
    }

    @Override
    public String toString() {
        return "Cactus{" +
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
