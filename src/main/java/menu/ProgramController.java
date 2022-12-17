package menu;

import menu.category.CategoryController;
import menu.coach.CoachController;
import menu.view.OutputView;

public class ProgramController {

    public void runProgram() {
        OutputView.printStartMessage();
        CoachController.setCoaches();
        CategoryController.recommendMenu();
        OutputView.printEndMessage();
    }

}
