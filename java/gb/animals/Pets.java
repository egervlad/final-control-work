package gb.animals;

import java.time.LocalDate;

public abstract class Pets extends Animals{
    public Pets(String name, LocalDate birthDay, TypesAnimals typeAnimals) {
        super(name, birthDay, typeAnimals);
    }

}
