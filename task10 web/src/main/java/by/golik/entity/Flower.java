package by.golik.entity;


/**
 *
 * @author Nikita Golik
 */
public abstract class Flower {
    private String id;
    private String soil;
    private String stem_color;
    private String leaf_color;
    private int average_plant_size;
    private int temperature;
    private boolean light_requiring;
    private int watering;
    private String multiplying;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getStem_color() {
        return stem_color;
    }

    public void setStem_color(String stem_color) {
        this.stem_color = stem_color;
    }

    public String getLeaf_color() {
        return leaf_color;
    }

    public void setLeaf_color(String leaf_color) {
        this.leaf_color = leaf_color;
    }

    public int getAverage_plant_size() {
        return average_plant_size;
    }

    public void setAverage_plant_size(int average_plant_size) {
        this.average_plant_size = average_plant_size;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean isLight_requiring() {
        return light_requiring;
    }

    public void setLight_requiring(boolean light_requiring) {
        this.light_requiring = light_requiring;
    }

    public int getWatering() {
        return watering;
    }

    public void setWatering(int watering) {
        this.watering = watering;
    }

    public String getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(String multiplying) {
        this.multiplying = multiplying;
    }

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getOrigin();

    public abstract void setOrigin(String origin);
}
