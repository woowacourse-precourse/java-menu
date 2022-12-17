package menu.controller;

import static menu.ConstantBox.MAX_TRY_NUMBER;
import static menu.ConstantBox.ZERO;
import static menu.ExceptionHandler.input;
import static menu.domain.ForbiddenMenu.getForbiddenMenuInstance;
import static menu.domain.coach.CoachRepository.getCoachRepositoryInstance;

import java.util.List;
import menu.domain.CategoryDecider;
import menu.domain.MenuGiver;
import menu.domain.coach.Coach;
import menu.domain.coach.CoachGenerator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        makeCoach();
        setForbiddenMenu();
        setCategoryAndSelectMenu();
    }

    private void makeCoach() {
        inputView.printStartMessage();
        List<String> coaches = input(inputView::inputCoachName);
        CoachGenerator.makeCoaches(coaches);
    }

    private void setForbiddenMenu() {
        for (Coach coach : getCoachRepositoryInstance().getCoaches()) {
            inputView.setCoachName(coach.getName());
            List<String> forbiddenFoods = input(inputView::inputForbiddenFoods);
            getForbiddenMenuInstance().saveForbiddenMenu(forbiddenFoods);
        }
    }

    private void setCategoryAndSelectMenu() {
        CategoryDecider categoryDecider = new CategoryDecider();
        for (int number = ZERO; number < MAX_TRY_NUMBER; number++) {
            categoryDecider.setCategory();
            String category = categoryDecider.getDecidedCategory(number);
            List<String> menu = MenuGiver.giveMenu(category);
            List<String> removedMenu = getForbiddenMenuInstance().removeForbiddenMenusInMenu(menu);
            CoachController.selectMenuByCoach(removedMenu);
        }
        printResult(categoryDecider.makeResultMessage());
    }

    private void printResult(String categoryResult) {
        outputView.printResultMessage();
        outputView.printCategoryResult(categoryResult);
        for (Coach coach : getCoachRepositoryInstance().getCoaches()) {
            outputView.printSelectedMenuResult(coach.makeResultMessage());
        }
        outputView.printFinalMessage();
    }
}
