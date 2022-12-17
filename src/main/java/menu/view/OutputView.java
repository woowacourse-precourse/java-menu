package menu.view;

import java.util.List;
import menu.domain.Menu;
import menu.domain.RecommendMenus;

public class OutputView {

    public static void printGuideOfAppStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public static void printRecommendMenusResult(List<RecommendMenus> recommendMenus) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println("[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]");
        for (RecommendMenus menus: recommendMenus) {
            printRecommendMenuOfCoach(menus);
        }
    }

    private static void printRecommendMenuOfCoach(RecommendMenus menus) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        stringBuilder.append(menus.getCoach().getName());
        for (String menu : menus.getMenus()) {
            stringBuilder.append(" | ");
            stringBuilder.append(menu);
        }
        stringBuilder.append(" ]");
        System.out.println(stringBuilder);
    }
}
