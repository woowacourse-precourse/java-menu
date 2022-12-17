package menu.view;

import java.util.List;
import java.util.Map.Entry;
import menu.dto.response.CoachesWeeklyMenu;

public class OutputView {

    public void printAppRunMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printWeeklyRecommendMenu(CoachesWeeklyMenu coachesWeeklyMenu) {
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printWeeklyMenuCategories(coachesWeeklyMenu);
        coachesWeeklyMenu.getEachCoachesMenu()
                .entrySet()
                .forEach(this::printEachCoachesWeeklyMenu);
    }

    private void printWeeklyMenuCategories(CoachesWeeklyMenu coachesWeeklyMenu) {
        String categories = String.join(" | ", coachesWeeklyMenu.getCategoriesNames());
        System.out.println("[ 카테고리 | " + categories + " ]");
    }

    private void printEachCoachesWeeklyMenu(Entry<String, List<String>> entry) {
        String menus = String.join(" | ", entry.getValue());
        System.out.println("[ "+ entry.getKey() +" | " + menus + " ]");
    }
}
