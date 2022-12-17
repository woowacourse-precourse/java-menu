package menu.view.front;

import menu.view.DefaultOutputView;

public class FrontOutputView extends DefaultOutputView {

    private static final String START_APPLICATION_GUIDE_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String END_APPLICATION_GUIDE_MESSAGE = "추천을 완료했습니다.";

    private FrontOutputView() {
    }

    private static class FrontOutputViewSingletonHelper {
        private static final FrontOutputView FRONT_OUTPUT_VIEW = new FrontOutputView();
    }

    public static FrontOutputView getInstance() {
        return FrontOutputViewSingletonHelper.FRONT_OUTPUT_VIEW;
    }

    public void printStartGuideMessage() {
        System.out.println(START_APPLICATION_GUIDE_MESSAGE);
    }

    public void printEndGuideMessage() {
        System.out.println(END_APPLICATION_GUIDE_MESSAGE);
    }
}
