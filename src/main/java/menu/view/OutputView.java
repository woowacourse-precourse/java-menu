package menu.view;

import menu.dto.ResultDto;

import java.util.List;

public class OutputView {

    public static void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printRecommendMenuResult(List<ResultDto> result) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println();
    }


}
