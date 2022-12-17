package menu.controller;

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
            System.out.println(hateFoods);
            new Coach(coachName, hateFoods);
        }

        choiceCategory();
    }

    public void choiceCategory() {
        for (int day = ZERO; day < DAY_COUNT; day++) {
            choiceMachine.choiceCategory();
        }

        choiceMenu();
    }

    public void choiceMenu() {
        for (Coach coach : CoachRepository.coaches()) {
            for (int day = ZERO; day < DAY_COUNT; day++) {
                choiceMachine.choiceMenu(coach, day);
            }
        }

        end();
    }

    public void end() {
        outputView.printEnd();
    }
}
