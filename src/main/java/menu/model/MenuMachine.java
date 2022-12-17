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
        List<String> recommendedMenus = coach.getRecommendedMenus();

        recommendedMenus.add(selectEachMenus(category.get(recommendedMenus.size())));
//        coach.setRecommendedMenus(recommendedMenus);
    }

    private String selectEachMenus(int country) {
        Menus menus = new Menus();
        List<String> menu;
        while (true) {
//            System.out.println("나라" + country);
            menu = Randoms.shuffle(menus.giveCountryMenus(country));
//            System.out.println("리스트:" + menu);
            if (!isDuplicateMenu(menu.get(0)) && !isNotEatMenus(menu.get(0))) {
//                System.out.println("메뉴:" + menu);
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
