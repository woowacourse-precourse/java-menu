package menu.recommendation;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Category;
import menu.model.Menu;

public class MenuGenerator {
    Menu menus = new Menu();
    public String recommendMenu(List<String> recommendMenus, Category todayCategory, List<String> dontEatMenus){
        String recommendMenu = validation(recommendMenus, dontEatMenus, todayCategory);
        return recommendMenu;
    }

    public String validation(List<String> recommended, List<String> dontEat, Category todayCategory){
        String menu = null;
        while(true){
            menu = Randoms.shuffle(menus.getInstance(todayCategory.getValue())).get(0);
            if(!(recommended.contains(menu) || dontEat.contains(menu))){
                break;
            }
        }
        return menu;
    }
}
