package menu.View;

import menu.Model.Coach;
import menu.Model.Coaches;
import menu.Model.DayMenu;
import menu.Model.WeekMenu;

public class OutputView {
    public static void printRecommendStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printRecommendResult(WeekMenu weekMenu, Coaches coaches) {
        String categoryOutput = "";
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        for (int i = 0; i < 5; i++) {
            categoryOutput += " | " + weekMenu.getDayMenu(i).getCategory();
        }
        System.out.println("[ 카테고리" + categoryOutput + " ]");
        for (Coach coach : coaches.getCoaches()) {
            System.out.println("[ " + coach.getName() + " | " + coach.getRecommendedMenus().get(0) + " | " +
                    coach.getRecommendedMenus().get(1) + " | " + coach.getRecommendedMenus().get(2) + " | " +
                    coach.getRecommendedMenus().get(3) + " | " + coach.getRecommendedMenus().get(4) + " ]");
        }
        System.out.println("추천을 완료했습니다.");
    }
}
