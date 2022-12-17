package menu.step;

import menu.common.log.Logger;
import menu.controller.MenuRecommendController;

public class Exit extends MenuRecommendApplicationStep {

    public Exit(final MenuRecommendController controller,
                final Logger logger) {
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
