package transport;

import java.util.Objects;

public class Bus extends Transport {

    private int place;
    private String departureStationName;
    private String endingStation;
    private double tripPrice;

    public Bus(String brand, String model, int year, String country, String color, int maxSpeed,
               int place, String departureStationName, String endingStation, double tripPrice) {
        super(brand, model, year, country, null, maxSpeed);
        this.place = (place <= 0) ? 10 : place;
        this.departureStationName = validateString(departureStationName);
        this.endingStation = validateString(endingStation);
        this.tripPrice = (tripPrice <= 0) ? 50 : tripPrice;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = (place <= 0) ? 10 : place;
    }

    public String getDepartureStationName() {
        return departureStationName;
    }

    public void setDepartureStationName(String departureStationName) {
        this.departureStationName = departureStationName;
    }

    public String getEndingStation() {
        return endingStation;
    }

    public void setEndingStation(String endingStation) {
        this.endingStation = endingStation;
    }

    public double getTripPrice() {
        return tripPrice;
    }

    public void setTripPrice(double tripPrice) {
        this.tripPrice = (tripPrice <= 0) ? 50 : tripPrice;
    }

    @Override
    public String toString() {
        return String.format(
                "Автобус %s, модель %s, год выпуска %d, страна %s, скорость передвижения %d км/ч, отходит от %s и следует до %s, цена поездки - %.2f рублей, количество мест %d",
                getBrand(), getModel(), getYear(), getCountry(), getMaxSpeed(), getDepartureStationName(),
                getEndingStation(), getTripPrice(), getPlace());
    }

    @Override
    public void refill(String petrol) {
        petrol.trim();
        if (petrol.equalsIgnoreCase("дизель")) {
            System.out.println(
                    "Заправляю автобус дизельным топливом..." + "\"" + getBrand() + " " + getModel() + "\"");
        } else if (petrol.equalsIgnoreCase("бензин")) {
            System.out.println("Автобусы не ездят на бензине");
        } else {
            System.out.println(
                    "Выберите вид топлива для: " + "\"" + getBrand() + " " + getModel() + "\"");
        }
    }
}