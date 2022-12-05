package animals.amphibians;

import animals.Animals;

public class Amphibians extends Animals {

    private String livingEnvironment;

    public Amphibians(String name, int age, String livingEnvironment) {
        super(name, age);
        this.livingEnvironment = validateString(livingEnvironment);
    }

    public final void hunt() {
        System.out.println(getName() + " охотится");
    }


    public final String getLivingEnvironment() {
        return livingEnvironment;
    }

    public final void setLivingEnvironment(String livingEnvironment) {
        this.livingEnvironment = validateString(livingEnvironment);
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
    public String toString() {
        return String.format(
                "Животные, земноводные: %s, возраст %d год(а), среда обитания: %s"
                , getName(), getAge(), getLivingEnvironment());
    }
}