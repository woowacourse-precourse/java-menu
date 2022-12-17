package menu.View;

import menu.Coach;

import java.util.List;

public class OutputView {
    public void printResult(List<String> choosedCategories, List<Coach> coaches) {
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategories(choosedCategories);
        for (int i = 0; i < coaches.size(); i++) {
            Coach coach = coaches.get(i);
            printMenus(coach.getName(), coach.getWeekMenu());
        }
        System.out.println("\n추천을 완료했습니다.");
    }

    private void printCategories(List<String> choosedCategories) {
        String categories = String.join(" | ", choosedCategories);
        System.out.println("[ 카테고리 | " + categories + " ]");
    }

    private void printMenus(String name, List<String> weekMenu) {
        String menus = String.join(" | ", weekMenu);
        System.out.println("[ " + name + " | " + menus + " ]");
    }
}
