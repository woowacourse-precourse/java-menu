package menu.controller;

import menu.enums.MenuOption;
import menu.model.ChoiceMachine;
import menu.model.Coach;
import menu.model.CoachRepository;
import menu.view.OutputView;

import java.util.List;

public class MainController {

    private static final int ZERO = 0;
    private static final int DAY_COUNT = 5;

    private final InputController inputController;
    private final ChoiceMachine choiceMachine = new ChoiceMachine();
    private final OutputView outputView = new OutputView();

    public MainController() {
        inputController = new InputController(outputView);
        outputView.printStart();
    }

    public void start() {
        List<String> coachesName = inputController.inputCoachesName();

        for (String coachName : coachesName) {
            List<String> hateFoods = inputController.inputHateFoods(coachName);
            new Coach(coachName, hateFoods);
        }

        choiceCategory();
    }

    public void choiceCategory() {
        for (int day = ZERO; day < DAY_COUNT; day++) {
            MenuOption category = choiceMachine.choiceCategory();
            choiceMenu(category);
        }

        end();
    }

    public void choiceMenu(MenuOption category) {
        for (Coach coach : CoachRepository.coaches()) {
            choiceMachine.choiceMenu(coach, category);
        }
    }

    public void end() {
        outputView.printEnd();
    }
}
