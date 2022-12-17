package menu.step;

import menu.common.Logger;
import menu.controller.MenuRecommendController;
import menu.controller.mapper.MenuMapper;
import menu.domain.Coach;
import menu.domain.Food;
import menu.view.InputView;

import java.util.List;

public class InputInedibleMenuStep extends MenuRecommendApplicationStep {

    private final List<Coach> coaches;
    
    public InputInedibleMenuStep(List<Coach> coaches,
                                 MenuRecommendController controller,
                                 Logger logger) {
        super(controller, logger);
        this.coaches = coaches;    
    }

    @Override
    protected Step pureAction() {
        for (Coach coach : coaches) {
            String s = InputView.inputInedibleFoodForCoach(coach);
            List<Food> foods = MenuMapper.toMenus(s);
            coach.addInedibleFoods(foods);
        }
        return new MenuRecommendStep(coaches, controller, logger);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
