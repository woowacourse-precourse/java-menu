package menu.controller;

import menu.domain.Coach;
import menu.repository.CoachRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedList;
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

        // 코치들별로 못먹는 음식 입력받기 & repository에 저장
        List<Coach> coaches = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            OutputView.printCoachForbiddenFoodComment(name);
            // 해당 코치의 못먹는 음식 리스트 입력받음
            List<String> foods = InputView.readForbiddenFoods();

            coaches.add(new Coach(name, foods));
        }


    }

    private List<String> inputCoachNames() {
        OutputView.printCoachNameComment();
        List<String> names = InputView.readNames();

        return names;
    }
}
