package menu.controller.subcontroller;

import java.util.List;
import menu.controller.subcontroller.Controllable;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.repository.CoachRepository;
import menu.domain.repository.MenuRepository;
import menu.domain.status.ApplicationStatus;
import menu.view.InputView;
import menu.view.OutputView;

public class CoachDataController implements Controllable {

    private final InputView inputView;
    private final OutputView outputView;

    public CoachDataController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public ApplicationStatus process() {
        outputView.printStart();
        inputView.readCoachNames().forEach(CoachRepository::add);
        System.out.println(MenuRepository.menus());
        for (Coach coach : CoachRepository.coaches()) {
            List<Menu> menuNotToEat = inputView.readMenuNotToEat(coach.getName());
            coach.addMenuNotToEat(menuNotToEat);
        }
        return ApplicationStatus.GIVE_RECOMMENDATION;
    }
}
