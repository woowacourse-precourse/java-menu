package menu.domain;

import java.util.List;

public class Coach {

    private String coachName;
    private List<String> disLiekMenus;

    Coach(String coachName, List<String> disLiekMenus) {
        this.coachName = coachName;
        this.disLiekMenus = disLiekMenus;
    }
}
