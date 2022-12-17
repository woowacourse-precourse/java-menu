package menu.view;

import menu.domain.dto.RecommendResultDto;

import java.util.List;

public class OutputView {

    private static final String MENU_COMMEND_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    private OutputView() {
    }

    public static void printStartMenuComment() {
        System.out.println(MENU_COMMEND_MESSAGE);
    }

    public static void printMenuCommendResult(List<List<RecommendResultDto>> recommendResultDtos) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println("[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]");

        for (List<RecommendResultDto> recommendResult : recommendResultDtos) {

        }

        System.out.println("추천을 완료했습니다.");
    }
}
