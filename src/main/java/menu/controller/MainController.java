package menu.controller;

import menu.model.Coach;
import menu.model.CoachRepository;
import menu.module.RepeatModule;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MainController extends RepeatModule {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public MainController() {
        outputView.printStart();
    }

    public void start() {
        setCoachInfo();
    }

    public void setCoachInfo() {
        //TODO: 입력받아야 함
        List<String> coachesName = List.of("종헌", "상현");

        for (String coachName : coachesName) {
            //TODO: 입력받아야 함
            List<String> hateFoods = List.of("김밥", "라면");
            new Coach(coachName, hateFoods);
        }

        CoachRepository.print();
    }
}
