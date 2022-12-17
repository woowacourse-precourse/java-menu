package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuDecideService {
    public Coaches makeCoaches(String names) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : names.split(",")) {
            coaches.add(makeCoach(name));
        }
        return new Coaches(coaches);
    }

    private Coach makeCoach(String name) {
        return new Coach(name);
    }
}
