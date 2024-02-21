package gb.animals;

import java.time.LocalDate;

public abstract class Pets extends Animals{
    public Pets(String name, LocalDate birthDay) {
        super(name, birthDay, TypesAnimals.PETS);
    }

}
