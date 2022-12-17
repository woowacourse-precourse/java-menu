package menu.controller;

import menu.controller.system.AbstractController;
import menu.controller.system.ControllerHolder;
import menu.controller.system.ControllerName;
import menu.domain.Coach;
import menu.domain.CoachRepository;

import java.util.List;
import java.util.Map;

public class SavingBannedMenuController extends AbstractController {
    @Override
    public void doProcess(Map<String, Object> model) {
        List<Coach> coaches = CoachRepository.findAll();
        for (Coach coach : coaches) {
            model.put("coach", coach);
            ControllerHolder.get(ControllerName.SAVING_BANNED_MENU_PER_COACH).process(model);
        }
    }
}
