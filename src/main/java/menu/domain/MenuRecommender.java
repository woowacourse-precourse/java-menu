package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import constant.Category;
import constant.Week;
import repository.MenuForWeekRepository;

import java.util.List;

public class MenuRecommender {
    public static void addRecommendMenus(List<Coach> coaches) {
        for (Week weekday : Week.values()) {
            Category category = getRecommendCategory();
            MenuForWeekRepository.addCategory(weekday, category);
            createRecommendMenu(coaches, category); // 코치별 메뉴 생성 -> result repository 등록
        }
    }

    private static void createRecommendMenu(List<Coach> coaches, Category category) {
        List<String> menus = category.getMenus();
        for (Coach coach : coaches) {
            String recommendMenu = getMenuByShuffle(coach, menus);
            MenuForWeekRepository.addMenu(coach, recommendMenu);
        }
    }

    private static String getMenuByShuffle(Coach coach, List<String> menus) {
        String recommendMenu;
        while (true) {
            recommendMenu = Randoms.shuffle(menus).get(0);
            if (isAvailableToEat(coach, recommendMenu)) {
                break;
            }
        }
        return recommendMenu;
    }

    private static boolean isAvailableToEat(Coach coach, String recommendMenu) {
        return !(coach.isHateFood(recommendMenu) || MenuForWeekRepository.didCoachEat(coach, recommendMenu));
    }

    private static Category getRecommendCategory() {
        Category recommendCategory;
        while (true) {
            recommendCategory = Category.getCategoryByNumber(Randoms.pickNumberInRange(1, 5));
            if (MenuForWeekRepository.isCategoryAvailableToAdd(recommendCategory)) {
                break;
            }
        }
        return recommendCategory;
    }
}
