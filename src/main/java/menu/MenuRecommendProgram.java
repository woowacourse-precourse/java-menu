package menu;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuRecommendProgram {

    private final InputView inputView;
    private final OutputView outputView;
    private Coaches coaches;

    public MenuRecommendProgram() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        coaches = new Coaches();
    }

    public void start() {
        outputView.printStartMessage();
        outputView.printInputCoachName();
        makeCoach(inputView.readCoachName());
    }

    private void makeCoach(String[] coachNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String coach: coachNames) {
            coaches.add(new Coach(coach));
        }

        this.coaches.setCoaches(coaches);
    }
}
