package gb.animals;

import gb.commands.DonkeyCommands;

import java.time.LocalDate;
import java.util.List;

public class Donkey extends Animals implements DonkeyCommands {
    public Donkey(String name, List<String> commands, LocalDate birthDay) {
        super(name, commands, birthDay, TypesAnimals.PACK_ANIMALS);
    }

    @Override
    public void walk() {

    }

    @Override
    public void bray() {

    }

    @Override
    public void kick() {

    }

    @Override
    public void carryLoad() {

    }
}
