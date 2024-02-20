package gb.animals;

import gb.commands.DogCommands;

import java.time.LocalDate;
import java.util.List;

public class Dog extends Animals implements DogCommands {

    public Dog(String name, List<String> commands, LocalDate birthDay) {
        super(name, commands, birthDay, TypesAnimals.PETS);
    }

    @Override
    public void sit() {

    }

    @Override
    public void stay() {

    }

    @Override
    public void fetch() {

    }

    @Override
    public void paw() {

    }

    @Override
    public void bark() {

    }

    @Override
    public void roll() {

    }
}
