package menu.recommendation;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Category;
import menu.model.Menu;

public class MenuGenerator {
    public List<String> RecommendMenuInWeek(List<Category> categories, List<String> dontEatMenus){
        List<String> recommendMenus = new ArrayList<>();
        for (Category todayCategory: categories){
            String menu = validation(recommendMenus, dontEatMenus, todayCategory);
            recommendMenus.add(menu);
        }
        return recommendMenus;
    }

    public String validation(List<String> recommended, List<String> dontEat, Category todayCategory){
        System.out.println(Menu.getInstance(todayCategory));
        String menu = null;
        while(true){
            menu = Randoms.shuffle(Menu.getInstance(todayCategory)).get(0);
            if(!(recommended.contains(menu) || dontEat.contains(menu))){
                break;
            }
        }
        return menu;
    }
}
