package menu.model;

import java.util.List;

public class Coach {
    public String coachName;
    public List<String> impossibleMenus;

    public Coach(String coachName, List<String> impossibleMenus) {
        this.coachName = coachName;
        this.impossibleMenus = impossibleMenus;
    }

    public String getCoachName() {
        return coachName;
    }

    public List<String> getImpossibleMenus() {
        return impossibleMenus;
    }
}
