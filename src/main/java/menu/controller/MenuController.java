package menu.controller;

import menu.model.Coach;
import menu.utls.Validator;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private static final String DELIMITER = ",";

    private final OutputView outputView;
    private final InputView inputView;
    private final Validator validator;

    public MenuController() {
        outputView = new OutputView();
        inputView = new InputView();
        validator = new Validator();
    }

    public void run() {
        outputView.outputStartNotice();
        List<Coach> coaches = getCoaches();
        for (int index = 0; index < coaches.size(); index++) {
            //못 먹는 메뉴 입력
            inputView.inputAllegeMenu(coaches.get(index).getName())
        }
    }

    private List<Coach> getCoaches() {
        String input = inputCoachNames();
        String[] coachNames = input.split(DELIMITER);
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            coaches.add(new Coach(coachName, new ArrayList<>()));
        }
        return coaches;
    }

    private String inputCoachNames() {
        try {
            String input = inputView.inputCoachNames();
            validator.validateCoachNames(input);
            return input;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputCoachNames();
        }
    }
}
