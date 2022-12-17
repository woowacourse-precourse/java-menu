package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.*;
import menu.util.Parser;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

    private CategoryResult categoryResult;
    private int categoryPool[] = new int[6];
    public static MenuService instance = new MenuService();
    List<String> categoryResultList = new ArrayList<>();

    private MenuService() {
        for (int i = 1; i <= 5; i++) {
            categoryPool[i] = 2;
        }
    }

    public static MenuService getInstance() {
        return instance;
    }

    public RecommendResult recommend(List<Coach> coachList) {

        List<MenuResult> menuResultList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String category = recommendCategory();
            categoryResultList.add(category);
            for (Coach coach : coachList) {
                coach.getMenuList().add(recommendMenu(coach, category));
            }
        }
        categoryResult = new CategoryResult(categoryResultList);
        for (Coach coach : coachList) {
            menuResultList.add(new MenuResult(coach.getCoachName(), coach.getMenuList()));
        }
        return new RecommendResult(categoryResult, menuResultList);
    }

    public String recommendCategory() {

        while (true) {
            int i = Randoms.pickNumberInRange(1, 5);
            if (categoryPool[i] > 0) {
                categoryPool[i]--;
                return convertCategoryNumberToString(i);
            }
        }
    }

    public Menu recommendMenu(Coach coach, String category) {
        List<String> impossibleMenus = coach.getImpossibleMenus();
        List<String> recommendMenuList = new ArrayList<>();
        List<String> alreadyRecommended = new ArrayList<>();
        String menus = Category.valueOf(category).getMenus();
        List<String> menuList = Parser.parse(menus);

        for (String menu : menuList) {
            //System.out.print(" " + menu + " ");
        }
        String selectedMenu = Randoms.shuffle(menuList).get(0);
        do {
            //System.out.println("뽑아본 메뉴는 다음과 같아요 : " + selectedMenu);
            if (canRecommend(selectedMenu, impossibleMenus, alreadyRecommended)) {
                break;
            }
            selectedMenu = Randoms.shuffle(menuList).get(0);
        } while (true);
        alreadyRecommended.add(selectedMenu);
        recommendMenuList.add(selectedMenu);
        //System.out.println("뽑힌 메뉴는 다음과 같아요 : " + selectedMenu);
        return new Menu(selectedMenu);

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
