package gb.animals;

import gb.commands.DogCommands;

import java.time.LocalDate;
import java.util.List;

public class Dog extends Pets implements DogCommands {

    public Dog(String name, LocalDate birthDay) {
        super(name, birthDay);
    }

    public List<String> getPossibleCommands() {
        return possibleCommands;
    }

    @Override
    public void sit() {
        if (getCommands().contains("Sit")) {
            System.out.println("Собака сидит");
        } else {
            System.out.println("Животное этой команде не обучено");
        }
    }

    @Override
    public void stay() {

    }

    @Override
    public void fetch() {

    }

    @Override
    public void paw() {
        if (getCommands().contains("Paw")) {
            System.out.println("Собака дает лапу");
        } else {
            System.out.println("Животное этой команде не обучено");
        }
    }

    @Override
    public void bark() {

    }

    @Override
    public void roll() {

    }

    @Override
    public String toString() {
        return String.format("%s: %s, birthday: %s, команды: %s", "Собака", getName(), getBirthDay().toString(), String.join(", ", getCommands()));
    }
}
