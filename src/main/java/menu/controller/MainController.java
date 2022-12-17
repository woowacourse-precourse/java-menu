package menu.controller;

import menu.enums.MenuOption;
import menu.model.ChoiceMachine;
import menu.model.Coach;
import menu.model.CoachRepository;
import menu.module.RepeatModule;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MainController extends RepeatModule {

    private static final int ZERO = 0;
    private static final int DAY_COUNT = 5;

    private final ChoiceMachine choiceMachine = new ChoiceMachine();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public MainController() {
        outputView.printStart();
    }

    public void start() {
        //TODO: 입력받아야 함
        //List<String> coachesName = repeat(inputView::readCoachesName);
        List<String> coachesName = List.of("종헌", "상현");

        for (String coachName : coachesName) {
            //TODO: 입력받아야 함, 입력 과정 수정
            //outputView.printMessage(coachName);
            //List<String> hateFoods = repeat(inputView::readHateFoods);
            List<String> hateFoods = List.of("김밥", "라면");
            new Coach(coachName, hateFoods);
        }

        choiceCategory();
    }

    public void choiceCategory() {
        for (int day = ZERO; day < DAY_COUNT; day++) {
            choiceMachine.choiceCategory();
        }

        //TODO: 삭제해야 함
        CoachRepository.print();
        System.out.println();

        choiceMenu();
    }

    public void choiceMenu() {
        for (Coach coach : CoachRepository.coaches()) {
            for (int day = ZERO; day < DAY_COUNT; day++) {
                choiceMachine.choiceMenu(coach);
            }
        }

        end();
    }

    public void end() {
        outputView.printEnd();
    }
}
