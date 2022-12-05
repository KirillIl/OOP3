package transport;

import animals.Animals;
import animals.amphibians.Amphibians;
import animals.birds.Birds;
import animals.birds.flightlessBirds.FlightlessBirds;
import animals.birds.flying.FlyingBirds;
import animals.mammals.Mammals;
import animals.mammals.herbivores.Herbivores;
import animals.mammals.predators.Predators;
import java.time.LocalDate;
import transport.Car.Insurance;
import transport.Car.Key;

public class Main {

    public static void main(String[] args) {
        Car lada = new Car("Lada", "Granta", 2015, "Россия", "желтый", 1.7f);
        Car audi = new Car("Audi", "A8 50 L TDI quattro", 2020, "Германия", "черный", 3.0f);
        Car bmw = new Car("BMW", "Z8", 2021, "Германия", "черный", 3.0f, "", "родстер", "", 2, true,
                null, null);
        Car kia = new Car("Kia", "Sportage 4-го", 2018, "Южная Корея", "красный", 2.4f, "", "кроссовер",
                "", 5, true, null, null);
        Car hyundai = new Car("Hyundai", "Avante", 2016, "Южная Корея", "оранжевый", 1.6f);
        Car[] cars = new Car[]{lada, audi, bmw, kia, hyundai};
        printInfoAboutCar(cars);
        separator();
        bmw.setTransmission("АКПП");
        bmw.setRegistrationNumber("A777AA163");
        System.out.println(bmw);
        System.out.println(bmw.checkRegistrationNumber());
        bmw.changeSummerTires();
        System.out.println(bmw);
        separator();
        kia.setTransmission("АКПП");
        kia.setRegistrationNumber("В296ХР164");
        kia.setSummerTires(false);
        lada.setTransmission("Вариатор");
        printInfoAboutCar(cars);
        separator();
        bmw.setKey(new Key("Удаленный запуск", "Бесключевой запуск"));
        audi.setKey(new Key("Удаленный запуск", "Бесключевой запуск"));
        lada.setKey(new Key(null, "Ключевой запуск"));
        kia.setKey(new Key(null, "Бесключевой запуск"));
        hyundai.setKey(new Key(null, "Ключевой запуск"));
        printInfoAboutCar(cars);
        bmw.setInsurance(new Insurance(LocalDate.of(2023, 5, 24), 6524,
                "ВВВ4587964")); // ставится дата окончания страховки
        bmw.getInsurance().checkInsurancePeriod();
        bmw.getInsurance().checkInsuranceNumber();
        separator();
        bmw.setMaxSpeed(280);
        audi.setMaxSpeed(280);
        lada.setMaxSpeed(180);
        kia.setMaxSpeed(230);
        hyundai.setMaxSpeed(230);
        printInfoAboutCar(cars);
        separator();
        Train lastochka = new Train("Ласточка", "В-901", 2011, "Россия", null, 301, 3500, 3,
                "Белорусский вокзал", "Минск-Пассажирский", 11);
        Train leningrad = new Train("Ленинград", "D-125", 2019, "Россия", null, 270, 1700, 1,
                "Ленинградский вокзала", "Ленинград-Пассажирский", 8);
        System.out.println(lastochka);
        System.out.println(leningrad);
        separator();
        Bus mersedes = new Bus("Mercedes", "Benz Conecto G", 2017, "Germany", null, 140, 10, "Самара",
                "Киров", 2400);
        Bus iveco = new Bus("Iveco", "FBI 83 LR", 2018, "Italy", null, 140, 10, "Краснодар", "Сочи",
                3320);
        Bus daewoo = new Bus("Daewoo", "BC212MA", 2015, "Germany", null, 120, 10, "Киров", "Казань",
                4550);
        System.out.println(mersedes);
        System.out.println(iveco);
        System.out.println(daewoo);
        separator();
        bmw.refill("Бензин");
        iveco.refill("");
        lastochka.refill("Дизель");
        separator();
        FlightlessBirds birdDoDo = new FlightlessBirds("Птица До До", 4, "остров Маврикий", "ходьба");
        FlightlessBirds peacock = new FlightlessBirds("Павлин", 3, "Индия", "ходьба");
        Birds penguin = new FlightlessBirds("Пингвин", 4, "Антарктида", "ходьба");
        FlyingBirds albatross = new FlyingBirds("Альбатрос", 2, "Южные старны", "ходьба,полет");
        Birds falcon = new FlyingBirds("Сокол", 3, "Россия", "ходьба,полет");
        FlyingBirds gull = new FlyingBirds("Чайка", 2, "Россия", "ходьба,полет");
        Mammals gazelle = new Herbivores("Газель", 4, "Африка", 97, "трава");
        Herbivores giraffe = new Herbivores("Жираф", 4, "Африка", 60, "трава, листья деревьев");
        Herbivores horse = new Herbivores("Лошадь", 3, "Россия", 56, "трава");
        Animals frog = new Amphibians("Лягушка", 2, "Россия");
        Amphibians uzhFreshwater = new Amphibians("Уж пресноводный", 3, "Россия");
        Predators hyena = new Predators("Гиена", 3, "Африка", 64, "падаль");
        Mammals tiger = new Predators("Тигр", 4, "Россия", 65, "мелкие звери");
        Predators bear = new Predators("Медведь", 2, "Россия", 56, "сурки, суслики, бурундуки, рыба");
        hyena.hunt();
        tiger.eat();
        bear.sleep();
        frog.eat();
        uzhFreshwater.hunt();
        gazelle.eat();
        giraffe.sleep();
        horse.graze();
        birdDoDo.walk();
        peacock.eat();
        penguin.sleep();
        albatross.fly();
        falcon.hunt();
        gull.eat();
        separator();
        Animals[] animals = {frog, uzhFreshwater, birdDoDo, peacock, penguin, albatross, falcon, gull,
                gazelle, giraffe, horse, bear, hyena, tiger};
        for (Animals animal : animals) {
            System.out.println(animal);
        }
        System.out.println(gazelle.getName().equals(bear.getName()));
        System.out.println(frog.getName().equals(uzhFreshwater.getName()));
        System.out.println(uzhFreshwater.getName().equals(uzhFreshwater.getName()));
        for (Animals animal : animals) {
            if (animal instanceof Predators) {
                System.out.println(
                        animal.getName() + " хищник, питается: " + ((Predators) animal).getEat());
            }
            if (animal instanceof Herbivores) {
                System.out.println(animal.getName() + " ,травоядное, может развивать скорость до: "
                        + ((Herbivores) animal).getSpeedMove() + " км/ч");
            }
        }
        for (Animals animal : animals) {
            if (animal.getClass().equals(Amphibians.class)) {
                System.out.println(animal.getName() + ": амфибия");
            }
        }
    }

    public static void separator() {
        System.out.println(
                "==============================================================================================================================================================");
    }

    public static void printInfoAboutCar(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}