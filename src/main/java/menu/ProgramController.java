package menu;

import menu.category.CategoryService;
import menu.coach.CoachService;
import menu.view.OutputView;

public class ProgramController {

    public void runProgram() {
        OutputView.printStartMessage();
        CoachService.setCoaches();
        CategoryService.recommendMenu();
        OutputView.printEndMessage();
    }

}
