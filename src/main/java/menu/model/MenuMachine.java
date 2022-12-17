package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import menu.data.Menus;

import java.util.ArrayList;
import java.util.List;

public class MenuMachine {
    private Coach coach;

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public void selectMenus() {
        List<Integer> category = coach.getCategory();
        List<String> recommendedMenus = new ArrayList<>();
        for (int index = 0; index < MenuConstant.DAY_SIZE; index++) {
            recommendedMenus.add(selectEachMenus(category.get(index)));
        }
        coach.setRecommendedMenus(recommendedMenus);
    }

    private String selectEachMenus(int country) {
        Menus menus = new Menus();
        List<String> menu;
        while (true) {
            menu = Randoms.shuffle(menus.giveCountryMenus(country));

            if (!isDuplicateMenu(menu.get(0)) && !isNotEatMenus(menu.get(0))) {
                break;
            }
        }
        return menu.get(0);
    }

    private boolean isDuplicateMenu(String menu) {
        if (coach.getRecommendedMenus().contains(menu)) {
            return true;
        }
        return false;
    }

    private boolean isNotEatMenus(String menu) {
        if (coach.getNotEatMenus().contains(menu)) {
            return true;
        }
        return false;
    }
}
