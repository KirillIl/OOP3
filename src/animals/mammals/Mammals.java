package animals.mammals;

import animals.Animals;
import java.util.Objects;

public class Mammals extends Animals {

    private String livingEnvironment;
    private int speedMove;

    public Mammals(String name, int age, String livingEnvironment, int speedMove) {
        super(name, age);
        this.livingEnvironment = validateString(livingEnvironment);
        this.speedMove = Math.max(speedMove, 0);
    }

    public String getLivingEnvironment() {
        return livingEnvironment;
    }

    public final void setLivingEnvironment(String livingEnvironment) {
        this.livingEnvironment = validateString(livingEnvironment);
    }

    public int getSpeedMove() {
        return speedMove;
    }

    public void setSpeedMove(int speedMove) {
        this.speedMove = Math.max(speedMove, 0);
    }

    public void walk() {
        System.out.println(getName() + " гуляет");
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
        Mammals mammals = (Mammals) o;
        return speedMove == mammals.speedMove && Objects.equals(livingEnvironment,
                mammals.livingEnvironment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), livingEnvironment, speedMove);
    }
}