package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;
import menu.domain.exceptions.WrongCoachNumberException;
import menu.utils.Constants;

public class Coaches {

    private final List<Coach> coaches;

    public Coaches(String coaches) {
        this.coaches = new ArrayList<>();
        splitCoaches(coaches);
    }

    private void splitCoaches(String coaches) {
        String[] names = coaches.split(",");
        validation(names);
        for (String name : names) {
            this.coaches.add(new Coach(name));
        }
    }

    private void validation(String[] names) {
        if (names.length < Constants.MIN_COACH_NUMBER || names.length >  Constants.MAX_COACH_NUMBER) {
            throw new WrongCoachNumberException();
        }
    }

    public static Coaches from(final String input) {
        return new Coaches(input);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

}
