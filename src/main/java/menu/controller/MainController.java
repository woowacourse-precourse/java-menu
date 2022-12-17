package menu.controller;

import menu.model.ChoiceMachine;
import menu.model.Coach;
import menu.model.CoachRepository;
import menu.module.RepeatModule;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MainController extends RepeatModule {

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

        //TODO: 삭제해야 함
        CoachRepository.print();

        choiceCategory();
    }

    public void choiceCategory() {
        for (int day = 0; day < 5; day++) {
            choiceMachine.choiceCategory();
        }

        //TODO: 삭제해야 함
        CoachRepository.print();
    }
}
