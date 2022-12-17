package menu.controller;

import menu.domain.*;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {

    private final OutputView outputView;
    private final InputView inputView;

    public MenuController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        outputView.guideStart();
        readCoaches();
        readPickyAboutFood();
        recommend();
        print();
    }

    private void readCoaches() {
        try {
            outputView.guideInputCoachNames();

            for (String coach : inputView.readCoachNames()) {
                CoachRepository.addCoaches(new Coach(coach.trim()));
            }
            CoachRepository.validate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readCoaches();
        }
    }

    private void readPickyAboutFood() {

        for (Coach coach : CoachRepository.coaches()) {
            outputView.guideInputCantEat(coach.getName());

            for (String input : inputView.readPicky()) {
                coach.addCantEat(Food.isInFoodMenu(input));
            }
        }
    }

    private void recommend() {
        for (int day = 0; day < 5; day++) {
            MenuRecommendRepository.selectCategory();
            CoachRepository.selectMenu(MenuRecommendRepository.recommendedCategories().get(day));

        }
    }

    private void print() {
        outputView.guideShowResult();
        outputView.showResult(Day.getDays());
        List<String> form = new ArrayList<>();
        form.add("카테고리");
        form.addAll(MenuRecommendRepository.recommendedCategories());
        outputView.showResult(form);
        for (Coach coach : CoachRepository.coaches()) {
            outputView.showResult(coach.menus());
        }
        outputView.guideComplete();
    }

}
