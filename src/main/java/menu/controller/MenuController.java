package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
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



    private Categories suggestLunch(Coaches coaches, FoodMenu foodMenu) {
        Categories categories = new Categories();
        //요일별로 도는 동안
        for (int i = 0; i < 5; i++) {
            Category category = pickRandomCategory(); // 랜덤으로 카테고리 하나 고르고,
            categories.add(category);
            pickRandomMenu(coaches, foodMenu, category); // 각 코치가 월요일에 먹을 메뉴를 추천한다.
        }
        return categories;
    }

    private void pickRandomMenu(Coaches coaches, FoodMenu foodMenu, Category category) {
        List<Coach> coachNames = coaches.getCoaches();

        for (Coach coach : coachNames) {
            String food = foodMenu.getRandomMenuWithoutHates(category, coach,lunchSuggestion);
            lunchSuggestion.addSuggestion(coach, food);
        }
    }

    private Category pickRandomCategory() {
        int categoryNumber = Randoms.pickNumberInRange(1, 5);

        String category = null;

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

        return Category.findBy(category);
    }

    private void readUnEatable(Coaches coaches) {
        readUnEatableWithMessage(coaches);
    }

    private void readUnEatableWithMessage(Coaches coaches) {
        List<Coach> coachNames = coaches.getCoaches();

        for (Coach coach : coachNames) {
            String name = coach.getName();
            outputView.print(Messages.COACH_UNEATABLE, name);
            coach.addUnEatable(inputView.inputBasicLine()); // 에러 다시 입력
        }
    }

//    private Coaches readCoaches() {
//        outputView.print(Messages.INPUT_COACH_NAME);
//        return new Coaches(inputView.inputBasicLine());
//    }

    private Coaches readCoaches() {
        return inputView.readCoaches();
    }

    private void showLunchSuggestionWith(Categories categories) {
        outputView.print(Messages.LUNCH_SUGGEST_RESULT);
        outputView.print(Messages.DAYS);
        outputView.printCategories(categories);
        outputView.printLunchSuggestion(lunchSuggestion);
        outputView.print(Messages.SUGGESTION_FINISHED);
    }
}

