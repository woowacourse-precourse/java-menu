package menu.model;

import java.util.List;

public class Coach {

    private final String name;
    private final List<String> hateFoods;

    public String getName() {
        return this.name;
    }

    public List<String> getHateFoods() {
        return this.hateFoods;
    }

    public Coach(String name, List<String> hateFoods) {
        this.name = name;
        this.hateFoods = hateFoods;
        CoachRepository.addCoach(this);
    }
}
