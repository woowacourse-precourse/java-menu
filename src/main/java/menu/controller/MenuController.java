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
import menu.utils.Validator;
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
        List<Category> categories = getCategories();
        setCategoryForEachWeek(weeks, categories);
        getUnEatableMenuOfCoaches(coaches, inputView);
        setRecommendMenus(weeks, coaches);
        outputView.programResult(coaches, weeks);
    }
    private List<Coach> getCoaches() {
        while (true) {
            try {
                inputView.coachNames();
                String inputCoachNames = Console.readLine();
                String[] coachNames = inputCoachNames.split(",");
                Validator.checkCoachesCount(coachNames);
                return Arrays.stream(inputCoachNames.split(","))
                        .map(Coach::new)
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<Category>();
        while (categories.size() < 5) {
            Category category = RandomCategory.getRandomCategory();
            if (Collections.frequency(categories, category) < 2) {
                categories.add(category);
            }
        }
        return categories;
    }



    private void setCategoryForEachWeek(List<Week> weeks, List<Category> categories) {
        for (int i = 0; i < 5; i++) {
            weeks.get(i).setCategory(categories.get(i));
        }
    }
    private void getUnEatableMenuOfCoaches(List<Coach> coaches, InputView inputView) {
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
    }

    private void setRecommendMenus(List<Week> weeks, List<Coach> coaches) {
        for (Week week : weeks) {
            for (Coach coach : coaches) {
                coach.setRecommendMenus(week);
            }
        }
    }




}
