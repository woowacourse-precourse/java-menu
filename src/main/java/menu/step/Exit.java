package menu.step;

import menu.common.Logger;
import menu.controller.MenuRecommendController;

public class Exit extends MenuRecommendApplicationStep {

    public Exit(MenuRecommendController controller, Logger logger) {
        super(controller, logger);
    }

    @Override
    protected Step pureAction() {
        return null;
    }

    @Override
    public boolean executable() {
        return false;
    }
}
