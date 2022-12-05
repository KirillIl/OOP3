package animals;

import java.util.Objects;

public abstract class Animals {

    private final String name;
    private int age;

    public Animals(String name, int age) {
        this.name = validateString(name);
        this.age = Math.max(age, 0);
    }

    public abstract void eat();

    public abstract void sleep();

    public abstract void move();

    public final String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = Math.max(age, 0);
    }
    public final String validateString(String n){
        return (n !=null && !n.isEmpty() && !n.isBlank())? n: "...default...";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Animals animals = (Animals) o;
        return age == animals.age && Objects.equals(name, animals.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}