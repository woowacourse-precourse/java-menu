package menu.view;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;

public class OutputView {

    public static void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printEndMessage() {
        System.out.println("추천을 완료했습니다.");
    }

    public static void printRecommendedResult(List<Category> recommendedCategories, Coaches coaches) {
        System.out.println("메뉴 추천 결과입니다.\n"
                + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        List<String> categories = new ArrayList<>();
        categories.add("카테고리");
        recommendedCategories.stream().forEach(category -> categories.add(category.getName()));
        coaches.getCoaches().stream().forEach(OutputView::printCoachResult);
    }

    private static void printCoachResult(Coach coach) {
        List<String> menus = new ArrayList<>();
        menus.add(coach.getName());
        menus.addAll(coach.getEatMenu());
        System.out.println("[ ");
        System.out.println(String.join(" | ", menus));
        System.out.println(" ]");
    }
}
