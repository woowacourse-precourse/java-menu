package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.category.Categories;
import menu.domain.category.Category;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.service.FoodMenu;
import menu.service.LunchSuggestion;
import menu.view.InputView;
import menu.view.Messages;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LunchSuggestion lunchSuggestion;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lunchSuggestion = new LunchSuggestion();
    }

    public void run() {
        outputView.print(Messages.LUNCH_SUGGEST_START);
        FoodMenu foodMenu = new FoodMenu();
        foodMenu.setMenu();

        Coaches coaches = readCoaches();
        readUnEatable(coaches);

        Categories categories = suggestLunch(coaches, foodMenu);
        showLunchSuggestionWith(categories);
    }

    private Coaches readCoaches() {
        return inputView.readCoaches();
    }

    private void readUnEatable(Coaches coaches) {
        readUnEatableWithMessage(coaches);
    }

    private void readUnEatableWithMessage(Coaches coaches) {
        List<Coach> coachNames = coaches.getCoaches();

        for (Coach coach : coachNames) {
            String name = coach.getName();
            outputView.print(Messages.COACH_UNEATABLE, name);
            coach.addUnEatable(inputView.inputBasicLine());

//            try {
//                coach.addUnEatable(inputView.inputBasicLine()); // 에러 다시 입력
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//                return coach.addUnEatable(inputView.inputBasicLine());
//            }
//            coach.addUnEatable(readUnEatables()); // 에러 다시 입력
        }
    }

    private Categories suggestLunch(Coaches coaches, FoodMenu foodMenu) {
        Categories categories = new Categories();
        for (int i = 0; i < 5; i++) {
            Category category = pickRandomCategory();
            categories.add(category);
            pickRandomMenu(coaches, foodMenu, category);
        }
        return categories;
    }

    private Category pickRandomCategory() {
        int categoryNumber = Randoms.pickNumberInRange(1, 5);
        String category = null;
        category = categoryChooseByNumber(categoryNumber, category);
        return Category.findBy(category);
    }

    private static String categoryChooseByNumber(int categoryNumber, String category) {
        if (categoryNumber == 1) {
            category = "일식";
        }
        if (categoryNumber == 2) {
            category = "한식";
        }
        if (categoryNumber == 3) {
            category = "중식";
        }
        if (categoryNumber == 4) {
            category = "아시안";
        }
        if (categoryNumber == 5) {
            category = "양식";
        }
        return category;
    }

    private void pickRandomMenu(Coaches coaches, FoodMenu foodMenu, Category category) {
        List<Coach> coachNames = coaches.getCoaches();

        for (Coach coach : coachNames) {
            String food = foodMenu.getRandomMenuWithoutHates(category, coach, lunchSuggestion);
            lunchSuggestion.addSuggestion(coach, food);
        }
    }

    private String readUnEatables() {
        return inputView.inputBasicLine();
    }

//    private Coaches readCoaches() {
//        outputView.print(Messages.INPUT_COACH_NAME);
//        return new Coaches(inputView.inputBasicLine());
//    }


    private void showLunchSuggestionWith(Categories categories) {
        outputView.print(Messages.LUNCH_SUGGEST_RESULT);
        outputView.print(Messages.DAYS);
        outputView.printCategories(categories);
        outputView.printLunchSuggestion(lunchSuggestion);
        outputView.print(Messages.SUGGESTION_FINISHED);
    }
}

