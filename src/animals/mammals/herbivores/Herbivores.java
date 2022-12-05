package animals.mammals.herbivores;

import animals.mammals.Mammals;
import java.util.Objects;

public class Herbivores extends Mammals {

    private final String eat;

    public Herbivores(String name, int age, String livingEnvironment, int speedMove, String eat) {
        super(name, age, livingEnvironment, speedMove);
        this.eat = validateString(eat);
    }

    public String getEat() {
        return eat;
    }

    public final void graze() {
        System.out.println(getName()+" пасется");
    }

    @Override
    public void eat() {
        System.out.println(getName()+" ест");
    }

    @Override
    public void sleep() {
        System.out.println(getName()+" спит");
    }

    @Override
    public void move() {
        System.out.println(getName()+" двигается");
    }

    @Override
    public void walk() {
        System.out.println(getName()+" гуляет");
    }

    @Override
    public String toString() {
        return String.format(
                "Животные, млекопитающие, травоядные: %s, возраст %d год(а), среда обитания: %s, максимальная скорость передвижения %d км/ч, основная еда: %s"
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
        Herbivores that = (Herbivores) o;
        return Objects.equals(eat, that.eat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eat);
    }
}