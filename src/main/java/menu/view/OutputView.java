package menu.view;

import java.util.List;
import menu.dto.RecommendCouchMenu;
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

    public void printResultCategories(List<String> categories) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.printf("[ 카테고리 | %s ]%n",String.join(" | ", categories));
    }

    public void printResultMessage(List<RecommendCouchMenu> responses) {
        for (RecommendCouchMenu response : responses) {
            System.out.println(response);
        }
        System.out.println("추천을 완료했습니다.");
    }
}
