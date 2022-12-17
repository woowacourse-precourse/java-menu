package menu;

import menu.category.CategoryController;
import menu.coach.CoachController;
import menu.view.OutputView;

public class ProgramController {

    public enum Week {
        MONDAY("월요일"), TUESDAY("화요일"), WEDNESDAY("수요일"), THURSDAY("목요일"), FRIDAY("금요일");

        private String name;

        Week(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public void runProgram() {
        OutputView.printStartMessage();
        CoachController.setCoaches();
        CategoryController.recommendMenu();
        OutputView.printEndMessage();
    }

}
