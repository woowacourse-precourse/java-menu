package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.model.enums.Category;
import menu.model.Coach;
import menu.model.enums.Days;
import menu.model.Menu;
import menu.model.MenuRepository;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendController {
    private static final int NUMBER_OF_MAX_CATEGORY_DUPLICATE = 2;
    private final MenuRepository menuRepository;
    private final List<Coach> coaches;
    private final InputView inputview;
    private final OutputView outputview;

    public RecommendController() {
        this.menuRepository = new MenuRepository();
        this.coaches = new ArrayList<>();
        this.menuRepository.readMenu();
        this.inputview = new InputView();
        this.outputview = new OutputView();
    }

    public void doRecommend() {
        outputview.printStart();
        addCoaches();
        addCannotEats();
        List<Category> categories = getFiveCategories();
        for (Category category : categories) {
            for (Coach coach : coaches) {
                recommendMenuEachCoach(coach, category);
            }
        }
        outputview.printResult(coaches, categories);
    }

    private void addCoaches() {
        List<String> coachNames = inputview.readCoachNames();
        coaches.addAll(coachNames.stream().map(Coach::new).collect(Collectors.toList()));
    }

    private void addCannotEats() {
        for (Coach coach : coaches) {
            coach.addCannotEats(inputview.readCantEats(coach.getName(), menuRepository));
        }
    }

    private List<Category> getFiveCategories() {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < Days.values().length; ) {
            Category tmpCategory = Category.byNumber(Randoms.pickNumberInRange(1, 5));
            if (isMoreThanTwo(categories, tmpCategory)) {
                continue;
            }
            categories.add(tmpCategory);
            i++;
        }
        return categories;
    }

    private boolean isMoreThanTwo(List<Category> categories, Category newCategory) {
        int frequency = Collections.frequency(categories, newCategory);
        return frequency >= NUMBER_OF_MAX_CATEGORY_DUPLICATE;
    }

    private Menu recommendMenu() {
        List<String> menus = menuRepository.getMenuNames();
        String menu = Randoms.shuffle(menus).get(0);
        return menuRepository.getMenuByName(menu);
    }

    private void recommendMenuEachCoach(Coach coach, Category category) {
        Menu recommendMenu;
        do {
            recommendMenu = recommendMenu();
        } while (!(recommendMenu.getCategory() == category) || coach.isCannotEat(recommendMenu)
                || coach.isRecommended(recommendMenu));
        coach.addRecommendMenu(recommendMenu);
    }
}
