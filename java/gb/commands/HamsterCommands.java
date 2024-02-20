package gb.commands;

import java.util.Arrays;
import java.util.List;

public interface HamsterCommands {

    // Roll, Hide, Spin
    public void roll();
    public void hide();
    public void spin();

    List<String> possibleCommands = Arrays.asList("Roll", "Hide", "Spin");

}
