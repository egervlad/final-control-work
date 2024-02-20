package gb.options;

import gb.animals.Animals;

import java.util.Comparator;

public class AnimalBirthdayComparator implements Comparator<Animals> {

    @Override
    public int compare(Animals o1, Animals o2) {
        if (o1.getBirthDay().isBefore(o2.getBirthDay())) {
            return -1;
        } else if (o1.getBirthDay().isAfter(o2.getBirthDay())) {
            return 1;
        } else if (o1.getBirthDay().isEqual(o2.getBirthDay())) {
            return 0;
        }
        return 0;
    }

}
