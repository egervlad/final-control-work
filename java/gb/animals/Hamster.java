package gb.animals;

import gb.commands.HamsterCommands;

import java.time.LocalDate;
import java.util.List;

public class Hamster extends Animals implements HamsterCommands {
    public Hamster(String name, List<String> commands, LocalDate birthDay) {
        super(name, commands, birthDay, TypesAnimals.PETS);
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
}
