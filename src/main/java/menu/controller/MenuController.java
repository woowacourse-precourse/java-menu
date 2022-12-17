package menu.controller;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.CategoryForDay;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.service.MenuService;

public class MenuController {

    private final MenuService menuService;

    public MenuController() {
        this.menuService = new MenuService(new CategoryForDay());
    }

    public void recommendCategory() {
        menuService.selectCategoryForEachDay();
    }

    public String getRecommendCategoryWord() {
        return menuService.getRecommendCategoryWord();
    }

    public List<String> getRecommendCategory() {
        return menuService.getRecommendCategory();
    }

    public void recommendForCoach(Coach coach, List<String> categories) {
        List<String> names = coach.getNames();

        for (String category : categories) {
            for (Menu value : Menu.values()) {
                for (String name : names) {
                    setRecommendFoods(coach, name, value, category);
                }
            }
        }
    }

    private void setRecommendFoods(Coach coach, String name, Menu value, String category) {
        if (value.getCategory().equals(category)) {
            List<String> menus = value.getMenus();

            while (true) {
                String menu = Randoms.shuffle(menus).get(0);

                if (!coach.getCanNotEatFoods(name).contains(menu) && !coach.getRecommendFoods(name).contains(menu)) {
                    coach.setRecommendFoods(name, menu);
                    break;
                }
            }
        }
    }
}
