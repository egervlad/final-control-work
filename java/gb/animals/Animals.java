package gb.animals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Animals {

    private String name;
    private List<String> commands;
    private LocalDate birthDay;
    private TypesAnimals typeAnimals;

    private static int count;
    static {
        count = 0;
    }

    public static int getCount() {return count;}

    public Animals(String name, LocalDate birthDay,TypesAnimals typeAnimals) {
        this.name = name;
        this.birthDay = birthDay;
        this.typeAnimals = typeAnimals;
        this.commands = new ArrayList<>();
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public TypesAnimals getTypeAnimals() {
        return typeAnimals;
    }

    public abstract List<String> getPossibleCommands();

    @Override
    public String toString() {
        return String.format("%s: %s, birthday: %s", typeAnimals, name, birthDay.toString());
    }
}
