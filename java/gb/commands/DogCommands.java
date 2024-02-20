package gb.commands;

import java.util.Arrays;
import java.util.List;

public interface DogCommands {

    // Sit, Stay, Fetch, Paw, Bark, Roll

    public void  sit();
    public void  stay();
    public void  fetch();
    public void  paw();
    public void  bark();
    public void  roll();

    List<String> possibleCommands = Arrays.asList("Sit", "Stay", "Fetch", "Paw", "Bark", "Roll");
}
