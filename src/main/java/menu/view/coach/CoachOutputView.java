package menu.view.coach;

import menu.view.DefaultOutputView;

public class CoachOutputView extends DefaultOutputView {

    private CoachOutputView() {
    }

    private static class CoachOutputViewSingletonHelper {
        private static final CoachOutputView SINGLETON = new CoachOutputView();
    }

    public static CoachOutputView getInstance() {
        return CoachOutputViewSingletonHelper.SINGLETON;
    }
}
