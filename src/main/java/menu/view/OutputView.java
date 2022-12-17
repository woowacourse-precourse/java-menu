package menu.view;

import java.util.List;
import menu.dto.RecommendMenusResponse;

public class OutputView {

    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public void printException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        System.out.println();
    }

    public void printResultMessage(List<RecommendMenusResponse> responses) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println("[ 카테고리 | 한식 | 양식 | 일식 | 중식 | 아시안 ]");
        for (RecommendMenusResponse response : responses) {
            String menus = String.join(" | ", response.getMenus());
            System.out.printf("[%s | %s ]%n", response.getCouchName(), menus);
        }
        System.out.println("추천을 완료했습니다.");
    }
}
