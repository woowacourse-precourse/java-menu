package menu.controller;

import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final OutputView outputView;
    private final InputView inputView;

    public MenuController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        outputView.guideStart();
        readCoaches();
    }

    private void readCoaches() {
        try {
            outputView.guideInputCoachNames();

            for (String coach : inputView.readCoachNames()) {
                CoachRepository.addCoaches(new Coach(coach.trim()));
            }
            CoachRepository.validate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readCoaches();
        }
    }

}
