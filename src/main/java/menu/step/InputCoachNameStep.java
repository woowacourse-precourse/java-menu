package menu.step;

import menu.common.Logger;
import menu.controller.MenuRecommendController;
import menu.controller.mapper.CoachMapper;
import menu.domain.Coach;
import menu.view.InputView;

import java.util.List;

public class InputCoachNameStep extends MenuRecommendApplicationStep {

    public InputCoachNameStep(MenuRecommendController controller, Logger logger) {
        super(controller, logger);
    }

    @Override
    protected Step pureAction() {
        String names = InputView.inputCoachName();
        List<Coach> coaches = CoachMapper.toCoaches(names);

        return new InputInedibleMenuStep(coaches, controller, logger);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
