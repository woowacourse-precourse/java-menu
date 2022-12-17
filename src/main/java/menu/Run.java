package menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import menu.View.InputView;
import menu.View.OutputView;

public class Run {
    private List<Coach> coaches = new ArrayList<>();
    private List<String> coachesName = new ArrayList<>();
    private List<String> choosedCategories = new ArrayList<>();
    private Map<String, List> menu;


    public Run() {
        coachesName = getCoachesName();
        coaches = makeCoaches(coachesName);
        new OutputView().printResult(choosedCategories, coaches);
    }

    private List<String> getCoachesName() {
        while(true) {
            try {
                return new InputView().getCoachesName();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> getHateFood(String name) {
        while(true) {
            try {
                return new InputView().getHateFood(name);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private List<Coach> makeCoaches(List<String> coachesName) {
        for (int i = 0; i < coachesName.size(); i++) {
            String name = coachesName.get(i);
            Coach coach = new Coach();
            coach.setName(name);
            List<String> hateFood = getHateFood(name);
            coach.setHateFood(hateFood);
            coaches.add(coach);
        }
        return coaches;
    }
}
