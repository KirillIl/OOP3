package transport;

import java.time.LocalDate;

public class Train extends Transport {

    private double tripPrice;
    private final int travelTime;
    private String departureStationName;
    private String endingStation;
    private int numberOfWagons;

    public Train(String brand, String model, int year, String country, String color, int maxSpeed,
                 double tripPrice, int travelTime, String departureStationName, String endingStation,
                 int numberOfWagons) {
        super(brand, model, year, country, null, maxSpeed);
        this.tripPrice = (tripPrice <= 50) ? 50 : tripPrice;
        this.travelTime = (travelTime <= 0) ? 1 : travelTime;
        this.departureStationName = validateString(departureStationName);
        this.endingStation = validateString(endingStation);
        this.numberOfWagons = (numberOfWagons <= 0) ? 1 : numberOfWagons;
    }

    public double getTripPrice() {
        return tripPrice;
    }

    public void setTripPrice(double tripPrice) {
        this.tripPrice = (tripPrice <= 50) ? 50 : tripPrice;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public String getDepartureStationName() {
        return departureStationName;
    }

    public void setDepartureStationName(String departureStationName) {
        this.departureStationName = validateString(departureStationName);
    }

    public String getEndingStation() {
        return endingStation;
    }

    public void setEndingStation(String endingStation) {
        this.endingStation = validateString(endingStation);
    }

    public int getNumberOfWagons() {
        return numberOfWagons;
    }

    public void setNumberOfWagons(int numberOfWagons) {
        this.numberOfWagons = (numberOfWagons <= 0) ? 1 : numberOfWagons;
    }

    @Override
    public String toString() {
        return "Поезд " + "\"" + getBrand() + "\", " +
                "модель " + getModel() + " "
                + getYear() + " год выпуска, "
                + getCountry() + ", скорость передвижения " + getMaxSpeed() + " км/ч" + ", отходит от "
                + departureStationName + " и следует до " + endingStation + ". Цена поездки-" + tripPrice
                + " рублей" +
                ", время следования " + travelTime + " часа" +
                ", количество вагонов " + numberOfWagons;
    }

    @Override
    public void refill(String petrol) {
        petrol.trim();
        if (petrol.equalsIgnoreCase("дизель")) {
            System.out.println(
                    "Заправляем поезд дизельным топливом..." + "\"" + getBrand() + " " + getModel() + "\"");
        } else if (petrol.equalsIgnoreCase("бензин")) {
            System.out.println("Поезда не ездят на бензине");
        } else {
            System.out.println(
                    "Выберите вид топлива для: " + "\"" + getBrand() + " " + getModel() + "\"");
        }
    }
}