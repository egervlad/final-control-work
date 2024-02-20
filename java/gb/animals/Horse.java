package gb.animals;

import gb.commands.HorseCommands;

import java.time.LocalDate;
import java.util.List;

public class Horse extends Animals implements HorseCommands {
    public Horse(String name, List<String> commands, LocalDate birthDay) {
        super(name, commands, birthDay, TypesAnimals.PACK_ANIMALS);
    }

    @Override
    public void trot() {

    }

    @Override
    public void canter() {

    }

    @Override
    public void gallop() {

    }

    @Override
    public void jump() {

    }
}
