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
        System.out.println("이건 코치"+ this.coachName+ this.disLikeMenus);
    }

    public void setRecommendMenus(String currentMenu) {
        List<String> temp = new ArrayList<>();
        temp.add(currentMenu);
        recommendMenus = temp;
        for(String s: recommendMenus)
            System.out.print("이거?"+s);
    }
}
