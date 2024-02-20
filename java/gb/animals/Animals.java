package gb.animals;

import java.time.LocalDate;
import java.util.List;

public abstract class Animals {

    private String name;
    private List<String> commands;
    private LocalDate birthDay;
    private TypesAnimals typeAnimals;

    public Animals(String name, List<String> commands, LocalDate birthDay,TypesAnimals typeAnimals) {
        this.name = name;
        this.commands = commands;
        this.birthDay = birthDay;
        this.typeAnimals = typeAnimals;
    }

}
