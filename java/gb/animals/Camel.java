package gb.animals;

import gb.commands.CamelCommands;

import java.time.LocalDate;
import java.util.List;

public class Camel extends Animals implements CamelCommands {
    public Camel(String name, List<String> commands, LocalDate birthDay) {
        super(name, commands, birthDay, TypesAnimals.PACK_ANIMALS);
    }

    @Override
    public void walk() {

    }

    @Override
    public void carryLoad() {

    }

    @Override
    public void sit() {

    }

    @Override
    public void run() {

    }
}
