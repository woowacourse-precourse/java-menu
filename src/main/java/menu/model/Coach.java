package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<String> hateFoods;
    private List<String> choicedMenu;

    public Coach(String name, List<String> hateFoods) {
        this.name = name;
        this.hateFoods = hateFoods;
        this.choicedMenu = new ArrayList<>();
        CoachRepository.addCoach(this);
    }

    public String getName() {
        return this.name;
    }

    public List<String> getHateFoods() {
        return this.hateFoods;
    }

    public List<String> getChoicedMenu() {
        return this.choicedMenu;
    }
}
