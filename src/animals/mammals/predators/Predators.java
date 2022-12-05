package animals.mammals.predators;

import animals.mammals.Mammals;
import java.util.Objects;

public class Predators extends Mammals {

    private final String eat;

    public Predators(String name, int age, String livingEnvironment, int speedMove, String eat) {
        super(name, age, livingEnvironment, speedMove);
        this.eat = validateString(eat);
    }

    public String getEat() {
        return eat;
    }

    public final void hunt() {
        System.out.println(getName()+" охотится");
    }

    @Override
    public String toString() {
        return String.format(
                "Животные, млекопитающие, хищники: %s, возраст %d год(а), среда обитания: %s, максимальная скорость передвижения %d км/ч, основная еда: %s"
                , getName(), getAge(), getLivingEnvironment(), getSpeedMove(), getEat());
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
        Predators predators = (Predators) o;
        return Objects.equals(eat, predators.eat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eat);
    }
}