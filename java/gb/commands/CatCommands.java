package gb.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface CatCommands {

    //Sit, Pounce, Scratch, Meow, Jump
    public void sit();
    public void pounce();
    public void scratch();
    public void meow();
    public void jump();

    List<String> possibleCommands = Arrays.asList("Sit", "Pounce", "Scratch", "Meow", "Jump");
}
