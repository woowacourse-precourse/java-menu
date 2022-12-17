package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private String coachName;
    private List<String> disLikeMenus;
    private List<String> recommendMenus;

    public Coach(String coachName, List<String> disLikeMenus) {
        this.coachName = coachName;
        this.disLikeMenus = disLikeMenus;
    }

    public void setRecommendMenus(List<String> recommendMenus) {
        this.recommendMenus = recommendMenus;
    }

    public List<String> getRecommendMenus() {
        return this.recommendMenus;
    }
}
