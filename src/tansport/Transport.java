package transport;

import java.util.Objects;

public abstract class Transport {

    private final String brand;
    private final String model;
    private final int year;
    private final String country;
    private String color;
    private int maxSpeed;

    public Transport(String brand, String model, int year, String country, String color,
                     int maxSpeed) {
        this.brand = validateString(brand);
        this.model = validateString(model);
        this.year = (year <= 0) ? 2000 : year;
        this.country = validateString(country);
        this.color = (color != null && !color.isEmpty() && !color.isBlank()) ? color : "...белый...";
        this.maxSpeed = (maxSpeed >= 0) ? maxSpeed : 10;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = validateString(color);
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = (maxSpeed <= 0) ? 10 : maxSpeed;
    }

    public String validateString(String s) {
        return s != null && !s.isEmpty() && !s.isBlank() ? s : "...default...";
    }

    public abstract void refill(String petrol);

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Transport)) {
            return false;
        }
        Transport transport = (Transport) o;
        return getYear() == transport.getYear() && getMaxSpeed() == transport.getMaxSpeed()
                && Objects.equals(getBrand(), transport.getBrand()) && Objects.equals(
                getModel(), transport.getModel()) && Objects.equals(getCountry(),
                transport.getCountry()) && Objects.equals(getColor(), transport.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModel(), getYear(), getCountry(), getColor(), getMaxSpeed());
    }
}