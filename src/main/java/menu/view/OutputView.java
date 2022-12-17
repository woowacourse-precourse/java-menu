package menu.view;

import menu.model.Coach;

import java.util.List;

public class OutputView {

    public void printMenuResult(List<String> categoryNames, List<Coach> coaches) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategoryName(categoryNames);
        printCoachMenus(coaches);
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

    private void printCategoryName(List<String> categoryNames) {
        System.out.print("[ 카테고리");
        for (String name : categoryNames) {
            System.out.printf(" | %s", name);
        }
        System.out.println(" ]");
    }

    private void printCoachMenus(List<Coach> coaches) {
        for (Coach coach : coaches) {
            System.out.printf("[ %s", coach.getName());

            for (String menu : coach.getMyMenu()) {
                System.out.printf(" | %s", menu);
            }
            System.out.println(" ]");
        }
    }
}
