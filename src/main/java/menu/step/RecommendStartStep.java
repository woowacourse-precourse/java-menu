package menu.step;

import menu.common.log.Logger;
import menu.controller.MenuRecommendController;
import menu.view.OutputView;

public class RecommendStartStep extends MenuRecommendApplicationStep{

    public RecommendStartStep(final MenuRecommendController controller,
                              final Logger logger) {
        super(controller, logger);
    }

    @Override
    protected Step pureAction() {
        OutputView.printRecommendStart();
        return new InputCoachNameStep(controller, logger);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
