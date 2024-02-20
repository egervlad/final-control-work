package gb.commands;

import java.util.Arrays;
import java.util.List;

public interface DonkeyCommands {

    // Walk, Bray, Kick, Carry Load
    public void walk();
    public void bray();
    public void kick();
    public void carryLoad();

    List<String> possibleCommands = Arrays.asList("Walk", "Bray", "Kick", "Carry Load");

}
