package menu;

import menu.domain.food.Category;
import menu.util.InputView;
import menu.util.OutputView;

import java.util.List;

public class CategoryView {
    private CategoryController categoryController = new CategoryController();

    public void run() {
        boolean flag = true;

        while (flag) {
            try {
                recommend();
                flag = false;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public void recommend() {
        List<String> coachNames = getCoachNames();

        saveCoaches(coachNames);

        List<Category> categories = categoryController.makeRecommendMenu();
        printResult(coachNames, categories);
    }

    private static List<String> getCoachNames() {
        OutputView.printStart();

        while (true) {
            try {
                List<String> coachNames = InputView.readCoachNames();
                return coachNames;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private void saveCoaches(List<String> coachNames) {
        for (String name : coachNames) {
            boolean flag = true;
            while (flag) {
                try {
                    List<String> hateFoods = InputView.readHateFoods(name);
                    categoryController.makeCoach(name, hateFoods);
                    flag = false;
                } catch (IllegalArgumentException e) {
                    OutputView.printError(e.getMessage());
                }
            }
        }
    }

    private void printResult(List<String> coachNames, List<Category> categories) {
        OutputView.printWeek();
        List<String> categoryNames = categoryController.getCategoryNames(categories);
        OutputView.printCategories(categoryNames);

        for (String name : coachNames) {
            List<String> recommendMenus = categoryController.getRecommendMenus(name);
            OutputView.printRecommend(name, recommendMenus);
        }

        OutputView.printEnd();
    }
}
