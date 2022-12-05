package transport;

import java.time.LocalDate;

public class Car extends Transport {

    public static class Insurance {

        private final LocalDate period;
        private final double cost;
        private final String number;

        public Insurance(LocalDate period, double cost, String number) {
            if (period == null) {
                this.period = LocalDate.now().plusDays(365);
            } else {
                this.period = period;
            }
            if (cost > 0) {
                this.cost = cost;
            } else {
                this.cost = 4000;
            }
            if (number != null && !number.isEmpty() && !number.isBlank()) {
                this.number = number;
            } else {
                this.number = "ААА000000";
            }
        }

        public Insurance() {
            this(LocalDate.now().plusDays(365), 4000, "ААА000000");
        }

        public LocalDate getPeriod() {
            return period;
        }

        public double getCost() {
            return cost;
        }

        public String getNumber() {
            return number;
        }

        public void checkInsurancePeriod() {
            if (period.isBefore(LocalDate.now()) || period.isEqual(LocalDate.now())) {
                System.out.println("Cрочно ехать, оформлять новую страховку");
            }
        }

        public void checkInsuranceNumber() {
            if (number.length() != 9) {
                System.out.println("Номер страховки некорректный! " + getNumber());
            }
        }
    }

    public static class Key {

        private final String startKeyDistance;
        private final String startKeyPush;

        public Key(String startKeyDistance, String startKeyPush) {
            this.startKeyDistance =
                    (startKeyDistance != null && !startKeyDistance.isEmpty() && !startKeyDistance.isBlank())
                            ? startKeyDistance : "";
            this.startKeyPush =
                    (startKeyPush != null && !startKeyPush.isEmpty() && !startKeyPush.isBlank())
                            ? startKeyPush : "";
        }

        public String getStartKeyDistance() {
            return startKeyDistance;
        }

        public String getStartKeyPush() {
            return startKeyPush;
        }
    }

    private float engineVolume;
    private String transmission;
    private final String bodyType;
    private String registrationNumber;
    private final int numberOfSeats;
    private boolean summerTires;
    private Key key;
    private Insurance insurance;

    public Car(String brand, String model, int year, String country, String color, float engineVolume,
               String transmission, String bodyType, String registrationNumber, int numberOfSeats,
               boolean summerTires, Key key,
               Insurance insurance) {
        super(brand, model, year, country, color, 10);
        this.engineVolume = (engineVolume <= 0) ? 1.5f : engineVolume;
        this.transmission = validateTransmission(transmission);
        this.bodyType = validateBodyType(bodyType);
        this.registrationNumber = validateRegNumber(registrationNumber);
        this.numberOfSeats = Math.max(numberOfSeats, 5);
        this.summerTires = summerTires;
        if (key == null) {
            this.key = new Key(null, null);
        } else {
            this.key = key;
        }
        if (insurance != null) {
            this.insurance = insurance;
        } else {
            this.insurance = new Insurance();
        }
    }

    public Car(String brand, String model, int year, String country, String color,
               float engineVolume) {
        this(brand, model, year, country, color, engineVolume, "МКПП", "седан", "х000хх000",
                5, true,
                new Key(null, null), new Insurance());
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    private String validateTransmission(String t) {
        return t != null && !t.isEmpty() && !t.isBlank() ? t : "МКПП";
    }

    private String validateBodyType(String bt) {
        return (bt != null && !bt.isEmpty() && !bt.isBlank()) ? bt : "седан";
    }

    private String validateRegNumber(String rn) {
        return rn != null && !rn.isEmpty() && !rn.isBlank() ? rn : "х000хх000";
    }

    public boolean isSummerTires() {
        return summerTires;
    }

    public void setEngineVolume(float engineVolume) {
        if (engineVolume <= 0) {
            this.engineVolume = 1.5f;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public void setTransmission(String transmission) {
        this.transmission = validateTransmission(transmission);
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber != null && !registrationNumber.isEmpty()
                && !registrationNumber.isBlank()) {
            this.registrationNumber = registrationNumber;
        } else {
            this.registrationNumber = "х000хх000";
        }
    }

    public void setSummerTires(boolean summerTires) {
        this.summerTires = summerTires;
    }

    public void changeSummerTires() {
        summerTires = !summerTires;
    }

    public boolean checkRegistrationNumber() {
        char[] chars = registrationNumber.toCharArray();
        if (registrationNumber.length() != 9) {
            return false;
        }
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4])
                || !Character.isAlphabetic(chars[5])) {
            return false;
        }
        return Character.isDigit(chars[1]) && Character.isDigit(chars[2]) && Character.isDigit(
                chars[3])
                && Character.isDigit(chars[6]) && Character.isDigit(chars[7]) && Character.isDigit(
                chars[8]);
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        if (key == null) {
            this.key = new Key(null, null);
        } else {
            this.key = key;
        }
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        if (insurance != null) {
            this.insurance = insurance;
        } else {
            this.insurance = new Insurance();
        }
    }

    @Override
    public void refill(String petrol) {
        petrol.trim();
        if (petrol.equalsIgnoreCase("дизель")) {
            System.out.println(
                    "Заправляю автомобиль дизельным топливом..." + "\"" + getBrand() + " " + getModel()
                            + "\"");
        } else if (petrol.equalsIgnoreCase("бензин")) {
            System.out.println(
                    "Заправляю автомобиль бензином..." + "\"" + getBrand() + " " + getModel() + "\"");
        } else if (petrol.equalsIgnoreCase("зарядка")) {
            System.out.println("Заряжаю электрокар..." + getBrand() + " " + getModel() + "\"");
        } else {
            System.out.println(
                    "Выберите вид топлива для: " + "\"" + getBrand() + " " + getModel() + "\"");
        }
    }

    @Override
    public String toString() {
        return String.format(
                "%s %s, %d год выпуска, сборка %s, цвет %s, max скорость %d, объем двигателя %.1f л. Трансмиссия %s, кузов %s, регистрационный номер %s, "
                        + "количество мест %d, %s резина, номер страховки %s, %s, цена %.2f рублей, запуск двигателя: %s %s.",
                getBrand(), getModel(), getYear(), getCountry(), getColor(), getMaxSpeed(), engineVolume,
                transmission,
                bodyType, registrationNumber,
                numberOfSeats, isSummerTires() ? "летняя" : "зимняя", getInsurance().getNumber(),
                getInsurance().getPeriod(), getInsurance().getCost(), getKey().getStartKeyPush(),
                getKey().getStartKeyDistance());
    }
}