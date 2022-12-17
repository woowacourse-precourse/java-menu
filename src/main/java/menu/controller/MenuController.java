package menu.controller;

import menu.domain.Coach;
import menu.repository.CoachRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private CoachRepository coachRepository;
    public MenuController() {
        coachRepository = new CoachRepository();
    }
    public void start() {
        OutputView.printStartComment();
        // 코치들 입력받음
        List<String> names = inputCoachNames();
        List<Coach> coaches = nameToCoaches(names);
        coachRepository.setCoaches(coaches);
    }

    private List<String> inputCoachNames() {
        OutputView.printCoachNameComment();
        List<String> names = InputView.readNames();

        return names;
    }

    private List<Coach> nameToCoaches(List<String> names) {
        List<Coach> coaches = new ArrayList<>();
        for(String name : names) {
            coaches.add(new Coach(name));
        }
        return coaches;
    }
}
