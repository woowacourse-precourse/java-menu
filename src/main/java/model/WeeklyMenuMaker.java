package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class WeeklyMenuMaker {
    
    private final WeeklyRandomMenuMakerGenerator weeklyRandomMenuMakerGenerator;
    
    public WeeklyMenuMaker(WeeklyRandomMenuMakerGenerator weeklyRandomMenuMakerGenerator) {
        this.weeklyRandomMenuMakerGenerator = weeklyRandomMenuMakerGenerator;
    }
    
    public Category makeCategory() {
        return Category.findByNumber(weeklyRandomMenuMakerGenerator.generate());
    }
    
    public String makeMenuRecommendation(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
