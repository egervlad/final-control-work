package gb.animals;

import gb.commands.CatCommands;

import java.time.LocalDate;
import java.util.List;

public class Cat extends Animals implements CatCommands {

    public Cat(String name, List<String> commands, LocalDate birthDay) {
        super(name, commands, birthDay, TypesAnimals.PETS);
    }

    @Override
    public void sit() {

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

    }
}
