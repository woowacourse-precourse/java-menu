package menu;

import menu.input.InputView;
import menu.model.Category;
import menu.model.CategoryMachine;
import menu.model.Coach;
import menu.model.MenuMachine;
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
        selectCategories();
        selectMenus();
        printResult();
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

    private void selectCategories() {
        CategoryMachine categoryMachine = new CategoryMachine();
        categoryMachine.selectCategory(coach.get(0));
    }

    private void selectMenus() {
        MenuMachine menuMachine = new MenuMachine();
        for(int cnt = 0; cnt < 5; cnt++) {
            for(Coach eachCoach : coach) {
                menuMachine.setCoach(eachCoach);
                menuMachine.selectMenus();
            }
        }
    }

    private void printResult() {
        OutputView.printResult(coach);
    }

}
