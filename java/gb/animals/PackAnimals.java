package gb.animals;

import java.time.LocalDate;

public abstract class PackAnimals extends Animals {
    public PackAnimals(String name, LocalDate birthDay, TypesAnimals typeAnimals) {
        super(name, birthDay, typeAnimals);
    }

}
