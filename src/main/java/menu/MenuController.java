package menu;

import menu.input.InputView;
import menu.model.Coach;
import menu.output.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    List<Coach> coach;

    public MenuController() {
    }

    public void init() {
        start();
        progress();
    }

    private void start() {
        OutputView.printStartMessage();
    }

    private void progress() {
        readCoaches();
        readNotEatMenus();
        
    }
    private void readCoaches() {
        OutputView.printCoachNameMessage();
        try {
            List<String> coaches = InputView.readCoaches();
            makeCoach(coaches);
        } catch (IllegalArgumentException e) {
            readCoaches();
        }
    }

    private void makeCoach(List<String> coaches) {
        coach = new ArrayList<>();
        for (String coachName : coaches) {
            coach.add(new Coach(coachName));
        }
    }

    private void readNotEatMenus() {
        try {
            readEachCoachNotEatMenus();
        } catch (IllegalArgumentException e) {
            readNotEatMenus();
        }
    }

    private void readEachCoachNotEatMenus() {
        for (Coach eachCoach : coach) {
            OutputView.printEachCoachNotEatMenusMessage(eachCoach.getName());
            List<String> notEatMenus = InputView.readNotEatMenus();
            eachCoach.setNotEatMenus(new ArrayList<>(notEatMenus));
        }
    }
}
