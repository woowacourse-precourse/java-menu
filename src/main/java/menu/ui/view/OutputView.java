package menu.ui.view;

import menu.domain.results.RecommendResult;

public class OutputView {

    private OutputView() {

    }
    public static OutputView getInstance() {
        return new OutputView();
    }

    public void onBoardingPage() {
        System.out.println("점심 메뉴 추천을 시작합니다."); // TODO 매직넘버 정리 필요
        lineBreak();
    }

    public void resultView(RecommendResult recommendResult) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(recommendResult.categoryFormat());
        System.out.println(recommendResult.coachMenusFormat());
        lineBreak();
        System.out.println("추천을 완료했습니다.");
    }

    private void lineBreak() {
        System.out.println();
    }
}
