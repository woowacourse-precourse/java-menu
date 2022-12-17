package menu.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Week;
import menu.utils.RandomCategory;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private InputView inputView;
    private OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void init() {
        outputView.startProgram();
        List<Coach> coaches = getCoaches();
        List<Week> weeks = Week.getWeeks();
        List<Category> categories = new ArrayList<Category>();

        while (categories.size() < 5) {
            Category category = RandomCategory.getRandomCategory();
            if (Collections.frequency(categories, category) < 2) {
                categories.add(category);
            }
        }
        for (int i = 0; i < 5; i++) {
            weeks.get(i).setCategory(categories.get(i));
        }

        for (Coach coach : coaches) {
            inputView.cantEat(coach);
            while (true) {
                try {
                    coach.setProhibitionMenus(Console.readLine());
                    break;
                } catch (IllegalArgumentException errorState) {
                    System.out.println(errorState);
                }
            }
        }

        for(Coach coach : coaches) {
            while(coach.isMenuDuplicated()) {
                coach.setRecommendMenus(weeks);
            }
        }

        outputView.programResult(coaches);
    }

    private List<Coach> getCoaches() {
        while (true) {
            try {
                inputView.coachNames();
                String inputCoachNames = Console.readLine();
                String[] coachNames = inputCoachNames.split(",");
                if (!(2 <= coachNames.length && coachNames.length <= 5)) {
                    throw new IllegalArgumentException("코치는 2명에서 5명까지 입력이 가능합니다.");
                }
                List<Coach> coachs = Arrays.stream(inputCoachNames.split(","))
                        .map(Coach::new)
                        .collect(Collectors.toList());
                return coachs;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }
}
