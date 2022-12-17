package menu.step;

import menu.common.Logger;
import menu.controller.MenuRecommendController;
import menu.controller.mapper.CoachMapper;
import menu.domain.Group;
import menu.view.InputView;

public class InputCoachNameStep extends MenuRecommendApplicationStep {

    public InputCoachNameStep(final MenuRecommendController controller,
                              final Logger logger) {
        super(controller, logger);
    }

    @Override
    protected Step pureAction() {
        String names = InputView.inputCoachName();
        Group group = CoachMapper.toGroup(names);

        return new InputInedibleMenuStep(group, controller, logger);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
