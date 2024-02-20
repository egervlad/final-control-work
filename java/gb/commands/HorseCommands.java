package gb.commands;

import java.util.Arrays;
import java.util.List;

public interface HorseCommands {

    // Trot, Canter, Gallop, Jump
    public void trot ();
    public void canter ();
    public void gallop ();
    public void jump ();

    List<String> possibleCommands = Arrays.asList("Trot", "Canter", "Gallop", "Jump");

}
