package gb.animals;

import gb.commands.HorseCommands;

import java.time.LocalDate;
import java.util.List;

public class Horse extends PackAnimals implements HorseCommands {
    public Horse(String name, LocalDate birthDay) {
        super(name, birthDay);
    }

    public List<String> getPossibleCommands() {
        return possibleCommands;
    }

    @Override
    public void trot() {

    }

    @Override
    public void canter() {

    }

    @Override
    public void gallop() {
        if (getCommands().contains("Gallop")) {
            System.out.println("Лошадь скачет галлопом");
        } else {
            System.out.println("Животное этой команде не обучено");
        }
    }

    @Override
    public void jump() {
        if (getCommands().contains("Jump")) {
            System.out.println("Лошадь прыгает");
        } else {
            System.out.println("Животное этой команде не обучено");
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s, birthday: %s, команды: %s", "Лошадь", name, birthDay.toString(), String.join(", ", commands));
    }
}
