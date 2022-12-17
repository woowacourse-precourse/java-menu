package menu.domain;

import java.util.List;

public class Coach {

    private String coachName;
    private List<String> disLikeMenus;

    public Coach(String coachName, List<String> disLikeMenus) {
        this.coachName = coachName;
        this.disLikeMenus = disLikeMenus;
        System.out.println("이건 코치"+ this.coachName+ this.disLikeMenus);
    }
}
