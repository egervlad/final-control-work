package gb.animals;

import gb.commands.DonkeyCommands;

import java.time.LocalDate;
import java.util.List;

public class Donkey extends PackAnimals implements DonkeyCommands {
    public Donkey(String name, LocalDate birthDay) {
        super(name, birthDay);
    }

    public List<String> getPossibleCommands() {
        return possibleCommands;
    }

    @Override
    public void walk() {
        if (getCommands().contains("Walk")) {
            System.out.println("Осел гуляет");
        } else {
            System.out.println("Животное этой команде не обучено");
        }
    }

    @Override
    public void bray() {

    }

    @Override
    public void kick() {
        if (getCommands().contains("Kick")) {
            System.out.println("Осёл лягается");
        } else {
            System.out.println("Животное этой команде не обучено");
        }
    }

    @Override
    public void carryLoad() {
        if (getCommands().contains("Сarry Load")) {
            System.out.println("Осёл несет груз");
        } else {
            System.out.println("Животное этой команде не обучено");
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s, birthday: %s, команды: %s", "Осёл", name, birthDay.toString(), String.join(", ", commands));
    }
}
