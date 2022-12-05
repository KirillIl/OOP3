package animals.birds.flying;

import animals.birds.Birds;
import java.util.Objects;

public class FlyingBirds extends Birds {

    private final String movement;

    public FlyingBirds(String name, int age, String livingEnvironment, String movement) {
        super(name, age, livingEnvironment);
        this.movement = validateString(movement);
    }

    public final void fly() {
        System.out.println(getName() + " летает");
    }

    public String getMovement() {
        return movement;
    }

    @Override
    public String toString() {
        return String.format(
                "Животные, летающие птицы: %s, возраст %d год(а), среда обитания: %s, способ передвижения: %s"
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
        FlyingBirds that = (FlyingBirds) o;
        return Objects.equals(movement, that.movement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), movement);
    }
}