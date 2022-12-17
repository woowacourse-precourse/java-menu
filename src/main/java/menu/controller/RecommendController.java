package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Menu;
import menu.model.MenuRepository;
import menu.view.Inputview;
import menu.view.Outputview;

public class RecommendController {
    private static final int DAYS = 5;
    private static final int NUMBER_OF_MAX_CATEGORY_DUPLICATE = 2;
    private final MenuRepository menuRepository;
    private final List<Coach> coaches;
    private final Inputview inputview;
    private final Outputview outputview;

    public RecommendController() {
        this.menuRepository = new MenuRepository();
        this.coaches = new ArrayList<>();
        this.menuRepository.readMenu();
        this.inputview = new Inputview();
        this.outputview = new Outputview();
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

    public void recommendMenuEachCoach(Coach coach, Category category) {
        Menu recommendMenu;
        do {
            recommendMenu = recommendMenuByCategory(category);
        } while (coach.getCanNotEats().contains(recommendMenu) || coach.isRecommended(recommendMenu));
        coach.addRecommendMenu(recommendMenu);
    }

    public Menu recommendMenuByCategory(Category category) {
        List<Menu> menuByThisCategory = menuRepository.getMenusByCategory(category);
        List<String> menuNamesByThisCategory = menuByThisCategory.stream()
                .map(Menu::getName)
                .collect(Collectors.toList());
        String menu = Randoms.shuffle(menuNamesByThisCategory).get(0);
        return menuRepository.getMenuByName(menu);
    }

    public List<Category> getFiveCategories() {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < DAYS; ) {
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
        if (frequency > NUMBER_OF_MAX_CATEGORY_DUPLICATE) {
            return true;
        }
        return false;
    }
}
