package menu.domain.menu.view;

import java.util.List;
import menu.domain.menu.dto.MenuRecommendResponse;
import menu.domain.menu.model.Food;

public class OutputView {

    public static void printStartComment() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public static void printRecommendResult(List<MenuRecommendResponse> recommendResponses) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategory(recommendResponses);
        for (MenuRecommendResponse recommendResponse : recommendResponses) {
            System.out.println(recommendResponse);
        }
        System.out.println();
    }

    private static void printCategory(List<MenuRecommendResponse> recommendResponses) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ 카테고리");
        for (Food food : recommendResponses.get(0).getFoods()) {
            sb.append(" | ").append(food.getCategory().getName());
        }
        sb.append(" ]");
        System.out.println(sb);
    }

    public static void printEndComment() {
        System.out.println("추천을 완료했습니다.");
    }
}
