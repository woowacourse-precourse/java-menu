package menu.ui.view;

import menu.domain.results.RecommendResult;

public class OutputView {

    private OutputView() {
    }

    public static OutputView getInstance() {
        return new OutputView();
    }

    public void onBoardingPage() {
        System.out.println(ViewMessage.ON_BOARDING_MESSAGE); // TODO 매직넘버 정리 필요
        lineBreak();
    }

    public void resultView(RecommendResult recommendResult) {
        prefixPage();
        System.out.println(recommendResult.categoryFormat());
        System.out.println(recommendResult.coachMenusFormat());
        suffixPage();
    }

    private static void prefixPage() {
        System.out.println(ViewMessage.RESULT_PREFIX_MESSAGE);
        System.out.println(ViewMessage.WEEK_HEAD_COLUMN_MESSAGE);
    }

    private void suffixPage() {
        lineBreak();
        System.out.println(ViewMessage.RESULT_SUFFIX_MESSAGE);
    }

    private void lineBreak() {
        System.out.println();
    }
}
