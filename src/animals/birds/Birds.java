package animals.birds;

import animals.Animals;
import java.util.Objects;

public class Birds extends Animals {

    private String livingEnvironment;

    public Birds(String name, int age, String livingEnvironment) {
        super(name, age);
        this.livingEnvironment = validateString(livingEnvironment);
    }

    public String getLivingEnvironment() {
        return livingEnvironment;
    }

    public final void setLivingEnvironment(String livingEnvironment) {
        this.livingEnvironment = validateString(livingEnvironment);
    }

    public final void hunt() {
        System.out.println(getName() + " охотится");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " ест");
    }

    @Override
    public void sleep() {
        System.out.println(getName() + " спит");
    }

    @Override
    public void move() {
        System.out.println(getName() + " двигается");
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
        Birds birds = (Birds) o;
        return Objects.equals(livingEnvironment, birds.livingEnvironment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), livingEnvironment);
    }
}