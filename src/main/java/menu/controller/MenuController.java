package menu.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import menu.domain.InedibleFoods;
import menu.domain.Categories;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.util.CategoryGenerator;
import menu.util.FoodsFiller;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final static int START_NUM = 0;
    private final static int END_NUM = 5;
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final CategoryGenerator categoryGenerator = new CategoryGenerator();
    private final FoodsFiller foodsFiller = new FoodsFiller();
    private InedibleFoods inedible = new InedibleFoods();
    private Categories categories = new Categories();
    private Coaches coaches;

    public void run() {
        outputView.printStart();
        coaches = makeCoaches();
        fillInedibleFoods();
        fillMenus();
        outputView.printResult(categories, coaches);
    }

    private Coaches makeCoaches() {
        Coaches coachesTemp = new Coaches(getCoaches());
        return coachesTemp;
    }

    private void fillMenus() {
        for (int i = START_NUM; i < END_NUM; i++) {
            fillCategory();
            fillFoods(categories.getCategories().get(i));
        }
    }

    private void fillCategory() {
        categoryGenerator.generateCategories(categories);
    }

    private void fillFoods(String category) {
        for (Coach coach : coaches.getCoaches()) {
            foodsFiller.fillFoods(coach, category, inedible.getEdibleFoods());
        }
    }

    private void fillInedibleFoods() {
        int coachSize = coaches.getCoaches().size();
        fillInedible(coachSize);
    }

    private void fillInedible(int coachSize) {
        for (int i = 0; i < coachSize; i++) {
            Coach coach = coaches.getCoaches().get(i);
            outputView.requestInedibleFoods(coach.getName());
            String foods = inputView.readBannedFoods();
            Arrays.stream(foods.split(","))
                    .forEach(name -> inedible.addEdibleFood(name));
        }
    }

    private List<Coach> getCoaches() {
        outputView.requestCoachesName();
        String coachesName = inputView.readCoachName();
        return Arrays.stream(coachesName.split(","))
                .map(name -> new Coach(name))
                .collect(Collectors.toList());
    }
}
