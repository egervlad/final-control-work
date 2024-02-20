package gb.animals;

import gb.commands.HamsterCommands;

import java.time.LocalDate;
import java.util.List;

public class Hamster extends Pets implements HamsterCommands {
    public Hamster(String name, LocalDate birthDay) {
        super(name, birthDay, TypesAnimals.PETS);
    }

    public List<String> getPossibleCommands() {
        return possibleCommands;
    }

    @Override
    public void roll() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void spin() {

    }

    @Override
    public String toString() {
        return String.format("%s: %s, birthday: %s, команды: %s", "Хомяк", getName(), getBirthDay().toString(), String.join(", ", getCommands()));
    }
}
