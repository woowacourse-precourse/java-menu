package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MenuRecommender {

    private final CategoryDuplicationChecker categoryChecker;
    private final MenuDuplicatedChecker menuChecker;
    private final Coaches coaches;

    public MenuRecommender(CategoryDuplicationChecker categoryChecker, MenuDuplicatedChecker menuChecker, Coaches coaches) {
        this.categoryChecker = categoryChecker;
        this.menuChecker = menuChecker;
        this.coaches = coaches;
    }

    public Result generateRecommendResult() throws IOException {
        Map<DayOfWeek, DayCategoryMenu> results = new LinkedHashMap<>();

        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            DayCategoryMenu dayCategoryMenu = generateRecommendMenuOfDay();
            results.put(dayOfWeek, dayCategoryMenu);
            menuChecker.clear();
        }
        return new Result(results);
    }


    private DayCategoryMenu generateRecommendMenuOfDay() throws IOException {
        Category recommendedCategory = recommendRandomCategory();
        categoryChecker.increaseCategoryCount(recommendedCategory);

        List<Menu> recommendedMenus = new ArrayList<>();
        for (Coach coach : coaches.getCoachesName()) {
            Menu recommendedMenu = recommendRandomMenu(recommendedCategory, coach);
            recommendedMenus.add(recommendRandomMenu(recommendedCategory, coach));
            menuChecker.increaseMenuCount(recommendedMenu);
        }

        return new DayCategoryMenu(recommendedCategory, recommendedMenus);
    }

    private Category recommendRandomCategory() {
        List<Category> categories = Arrays.asList(Category.values());
        Category category = categories.get(Randoms.pickNumberInRange(0, 5));
        if (categoryChecker.isDuplicatedUpperTwice(category)) {
            return recommendRandomCategory();
        }
        return category;
    }

    private Menu recommendRandomMenu(Category recommendedCategory, Coach coach) throws IOException {
        List<Menu> menusName = MenuByCategoryData.getMenuByCategory(recommendedCategory);
        List<String> menus = menusName.stream()
                                        .map(s -> s.getName())
                                        .collect(Collectors.toList());
        Menu recommendedMenu = new Menu(Randoms.shuffle(menus)
                                               .get(0));
        if (coach.isContainHateMenu(recommendedMenu) || menuChecker.isDuplicated(recommendedMenu)) {
            return recommendRandomMenu(recommendedCategory, coach);
        }
        return recommendedMenu;
    }
}
