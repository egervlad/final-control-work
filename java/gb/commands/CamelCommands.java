package gb.commands;

import java.util.Arrays;
import java.util.List;

public interface CamelCommands {

    // Walk, Carry Load, Sit, Run
    public void walk();
    public void carryLoad();
    public void sit();
    public void run();

    List<String> possibleCommands = Arrays.asList("Walk", "Carry Load", "Sit", "Run");
}
