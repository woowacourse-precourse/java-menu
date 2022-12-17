package menu.step;

import menu.common.log.Logger;
import menu.controller.MenuRecommendController;
import menu.controller.mapper.MenuMapper;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.Group;
import menu.view.InputView;

import java.util.List;

public class InputInedibleMenuStep extends MenuRecommendApplicationStep {

    private final Group group;
    
    public InputInedibleMenuStep(final Group group,
                                 final MenuRecommendController controller,
                                 final Logger logger) {
        super(controller, logger);
        this.group = group;
    }

    @Override
    protected Step pureAction() {
        for (Coach coach : group.coaches()) {
            String s = InputView.inputInedibleMenuForCoach(coach);
            List<Menu> menus = MenuMapper.toMenus(s);
            coach.addInedibleMenus(menus);
        }
        return new MenuRecommendStep(group, controller, logger);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
