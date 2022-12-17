package menu.step;

import menu.common.log.Logger;
import menu.controller.MenuRecommendController;

public abstract class MenuRecommendApplicationStep implements Step {

    protected final MenuRecommendController controller;
    protected final Logger logger;

    public MenuRecommendApplicationStep(final MenuRecommendController controller,
                                        final Logger logger) {
        this.controller = controller;
        this.logger = logger;
    }

    @Override
    public Step execute() {
        while (true) {
            try {
                return pureAction();
            } catch (IllegalArgumentException e) {
                logger.error(e.getMessage());
            }
        }
    }

    protected abstract Step pureAction();
}
