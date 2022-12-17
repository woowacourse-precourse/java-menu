package menu.controller;

import menu.domain.*;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final OutputView outputView;
    private final InputView inputView;

    public MenuController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        outputView.guideStart();

        setCoaches();
        setPickyAboutFood();
        recommend();
        printResult();
    }

    private void setCoaches() {
        try {
            outputView.guideInputCoachNames();
            readCoaches();
            CoachRepository.validate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setCoaches();
        }
    }

    private void readCoaches() {
        CoachRepository.init();

        for (String coach : inputView.readCoachNames()) {
            CoachRepository.addCoaches(new Coach(coach.trim()));
        }
    }

    private void setPickyAboutFood() {

        for (Coach coach : CoachRepository.coaches()) {
            outputView.guideInputCantEat(coach.getName());
            readPickyAboutFood(coach);
        }
    }

    private void readPickyAboutFood(Coach coach) {
        try {
            for (String input : inputView.readPicky()) {
                Food.validateInMenu(input.trim());
                coach.addCantEat(input);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readPickyAboutFood(coach);
        }

    }

    private void recommend() {

        for (Day day : Day.values()) {

            if (day == Day.STANDARD) {
                continue;
            }
            RecommendService.selectCategory();
            RecommendService.selectMenu(RecommendRepository.recommendedCategories().get(day.getIndex()));
        }
    }

    private void printResult() {
        outputView.guideShowResult();
        outputView.showResult(Day.getDays());
        outputView.showResult(RecommendRepository.recommendedCategories());

        for (Coach coach : CoachRepository.coaches()) {
            outputView.showResult(coach.menus());
        }
        outputView.guideComplete();
    }

}
