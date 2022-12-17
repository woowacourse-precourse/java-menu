package menu.step;

import menu.common.Logger;
import menu.controller.MenuRecommendController;
import menu.domain.Group;
import menu.view.OutputView;

public class MenuRecommendStep extends MenuRecommendApplicationStep {

    private final Group group;

    public MenuRecommendStep(final Group group,
                             final MenuRecommendController controller,
                             final Logger logger) {
        super(controller, logger);
        this.group = group;
    }

    @Override
    protected Step pureAction() {
        controller.recommend(group);
        OutputView.printRecommendResult(group);
        return new Exit(controller, logger);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
