package gb.animals;

import gb.commands.CatCommands;

import java.time.LocalDate;
import java.util.List;

public class Cat extends Pets implements CatCommands {

    public Cat(String name, LocalDate birthDay) {
        super(name, birthDay);
    }

    public List<String> getPossibleCommands() {
        return possibleCommands;
    }

    @Override
    public void sit() {
        if (getCommands().contains("Sit")) {
            System.out.println("Котик сидит");
        } else {
            System.out.println("Животное этой команде не обучено");
        }
    }

    @Override
    public void pounce() {

    }

    @Override
    public void scratch() {

    }

    @Override
    public void meow() {

    }

    @Override
    public void jump() {
        if (getCommands().contains("Jump")) {
            System.out.println("Котик прыгает");
        } else {
            System.out.println("Животное этой команде не обучено");
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s, birthday: %s, команды: %s", "Котик", getName(), getBirthDay().toString(), String.join(", ", getCommands()));
    }
}
