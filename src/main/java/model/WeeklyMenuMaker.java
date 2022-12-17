package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class WeeklyMenuMaker {
    
    private final WeeklyMenuMakerGenerator weeklyMenuMakerGenerator;
    
    public WeeklyMenuMaker(WeeklyMenuMakerGenerator weeklyMenuMakerGenerator) {
        this.weeklyMenuMakerGenerator = weeklyMenuMakerGenerator;
    }
    
    public String makeMenuRecommendation() {
        Category category = getCategory();
        return getMenu(category.getMenus());
    }
    
    private Category getCategory() {
        return Category.findByNumber(weeklyMenuMakerGenerator.generate());
    }
    
    private String getMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
