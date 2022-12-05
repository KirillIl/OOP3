package animals.birds.flightlessBirds;

import animals.birds.Birds;
import java.util.Objects;

public class FlightlessBirds extends Birds {

    private final String movement;

    public FlightlessBirds(String name, int age, String livingEnvironment, String movement) {
        super(name, age, livingEnvironment);
        this.movement = validateString(movement);
    }

    public String getMovement() {
        return movement;
    }

    public final void walk() {
        System.out.println(getName() + " гуляет");
    }

    @Override
    public String toString() {
        return String.format(
                "Животные, нелетающие птицы: %s, возраст %d год(а), среда обитания: %s, способ передвижения: %s"
                , getName(), getAge(), getLivingEnvironment(), getMovement());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        FlightlessBirds that = (FlightlessBirds) o;
        return Objects.equals(movement, that.movement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), movement);
    }
}