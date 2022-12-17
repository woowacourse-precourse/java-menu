package menu;

import menu.coach.Coach;
import menu.input.InputView;
import menu.menu.Category;
import menu.output.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuRecommendProgram {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private HashMap<String, Integer> countOfCategorySelected;
    private List<Coach> coaches;
    private MenuRecommend menuRecommend;
    private List<String> selectedCategory;


    public MenuRecommendProgram() {
        countOfCategorySelected = new HashMap<>() {{
            for (Category category: Category.values()) {
                if (category.equals(Category.EMPTY)) {
                    continue;
                }
                String categoryName = category.getCategoryName();
                put(categoryName, 0);
            }
        }};
        coaches = new ArrayList<>();
        menuRecommend = new MenuRecommend();
        selectedCategory = new ArrayList<>();
    }

    public void run() {
        // start 부분
        start();

        for (int i = 0; i < 5; i++) {
            String category = selectCategory();
            selectMenus(category);
        }

        // 결과 출력
    }

    private void start() {
        printStartMessage();
        inputCoach();
        for (Coach coach: coaches) {
            inputMenus(coach);
        }
    }

    private void printStartMessage() {
        outputView.printStart();
    }

    private void inputCoach() {
        List<String> coachNames = inputView.readCoaches();
        for (String coachName: coachNames) {
            Coach coach = new Coach(coachName);
            coaches.add(coach);
        }
    }

    private void inputMenus(Coach coach) {
        List<String> menusNotEaten = inputView.readMenuNotEat();
        for (String menuNotEaten: menusNotEaten) {
            coach.addFoodNotEat(menuNotEaten);
        }
    }

    public void selectMenus(String category) {
        for (Coach coach: coaches) {
            selectMenu(coach, category);
        }
    }


    public String selectCategory() {
        String category;
        boolean isSelect;
        do {
            category = menuRecommend.selectCategory();
            isSelect = validateCategory(category);
        } while (!isSelect);
        Integer countOfSelect = countOfCategorySelected.get(category);
        countOfCategorySelected.put(category, countOfSelect+1);
        selectedCategory.add(category);
        return category;
    }

    private boolean validateCategory(String category) {
        return countOfCategorySelected.get(category) < 2;
    }

    public String selectMenu(Coach coach, String category) {
        String menu;
        List<String> menus = Category.getMenus(category);
        boolean isSelect;
        do {
            menu = menuRecommend.selectMenu(menus);
            isSelect = validateMenu(coach, menu);
        } while (!isSelect);
        coach.addfoodEaten(menu);
        return menu;
    }

    private boolean validateMenu(Coach coach, String menu) {
        boolean isEat = coach.isEat(menu);
        return isEat;
    }
}
