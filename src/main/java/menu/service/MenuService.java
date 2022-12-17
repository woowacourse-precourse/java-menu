package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.*;
import menu.util.Parser;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

    private CategoryResult categoryResult;

    public RecommendResult recommendMenu(List<Coach> coachList) {
        categoryResult = recommendCategory();
        List<MenuResult> menuResultList = new ArrayList<>();
        for (Coach coach : coachList) {
            MenuResult menuResult = recommendMenu(coach);
            menuResultList.add(menuResult);
        }
        return new RecommendResult(categoryResult, menuResultList);
    }

    public CategoryResult recommendCategory() {
        int categoryPool[] = new int[6];
        for (int i = 1; i <= 5; i++) {
            categoryPool[i] = 2;
        }
        int selected = 0;
        List<String> categoryResult = new ArrayList<>();
        while (selected != 5) {
            int i = Randoms.pickNumberInRange(1, 5);
            if (categoryPool[i] > 0) {
                selected++;
                categoryResult.add(convertCategoryNumberToString(i));
            }
        }
        return new CategoryResult(categoryResult);
    }

    public MenuResult recommendMenu(Coach coach) {
        String coachName = coach.getCoachName();
        List<String> impossibleMenus = coach.getImpossibleMenus();
        List<String> categoryResult = this.categoryResult.getCategoryResult();
        List<String> recommendMenuList = new ArrayList<>();
        List<String> alreadyRecommended = new ArrayList<>();
        for (int i = 0; i < categoryResult.size(); i++) {
            String menus = Category.valueOf(categoryResult.get(i)).getMenus();
            List<String> menuList = Parser.parse(menus);
            String selectedMenu = "";
            do {
                selectedMenu = Randoms.shuffle(menuList).get(0);
            } while (!canRecommend(selectedMenu, impossibleMenus, alreadyRecommended));
            alreadyRecommended.add(selectedMenu);
            recommendMenuList.add(selectedMenu);
        }
        return new MenuResult(coachName, recommendMenuList);
    }

    private boolean canRecommend(String selectedMenu, List<String> impossibleMenus, List<String> alreadyRecommended) {
        if (impossibleMenus.contains(selectedMenu) || alreadyRecommended.contains(selectedMenu))
            return false;
        return true;
    }

    public String convertCategoryNumberToString(int i) {
        if (i == 1) {
            return "일식";
        } else if (i == 2) {
            return "한식";
        } else if (i == 3) {
            return "중식";
        } else if (i == 4) {
            return "아시안";
        } else if (i == 5) {
            return "양식";
        }
        return "error";
    }

    public int convertCategoryStringToNumber(String str) {
        if (str.equals("일식")) {
            return 1;
        } else if (str.equals("한식")) {
            return 2;
        } else if (str.equals("중식")) {
            return 3;
        } else if (str.equals("아시안")) {
            return 4;
        } else if (str.equals("양식")) {
            return 5;
        }
        return 0;
    }
}
