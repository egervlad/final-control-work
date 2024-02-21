package gb.animals;

import gb.commands.CamelCommands;

import java.time.LocalDate;
import java.util.List;

public class Camel extends PackAnimals implements CamelCommands {
    public Camel(String name, LocalDate birthDay) {
        super(name, birthDay);
    }

    public List<String> getPossibleCommands() {
        return possibleCommands;
    }

    @Override
    public void walk() {
        if (getCommands().contains("Walk")) {
            System.out.println("Верблюд гуляет");
        } else {
            System.out.println("Животное этой команде не обучено");
        }
    }

    @Override
    public void carryLoad() {
        if (getCommands().contains("Сarry Load")) {
            System.out.println("Верблюд несет груз");
        } else {
            System.out.println("Животное этой команде не обучено");
        }
    }

    @Override
    public void sit() {
        if (getCommands().contains("Sit")) {
            System.out.println("Верблюд сидит");
        } else {
            System.out.println("Животное этой команде не обучено");
        }
    }

    @Override
    public void run() {
        if (getCommands().contains("Run")) {
            System.out.println("Верблюд бежит");
        } else {
            System.out.println("Животное этой команде не обучено");
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s, birthday: %s, команды: %s", "Верблюд", getName(), getBirthDay().toString(), String.join(", ", getCommands()));
    }
}
