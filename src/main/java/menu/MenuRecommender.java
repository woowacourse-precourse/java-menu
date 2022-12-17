package menu;

import camp.nextstep.edu.missionutils.Randoms;
import constant.Category;
import constant.Week;
import repository.MenuForWeekRepository;

import java.util.List;

public class MenuRecommender {
    // TODO : 컨트롤러로 카테고리를 반환하고, 메뉴를 반환하도록 해서 컨트롤러에서 레포지토리 등록하도록 변경해보기
    public static void addRecommendMenus(List<Coach> coaches) {
        for (Week weekday : Week.values()) {
            Category category = getRecommendCategory();
            MenuForWeekRepository.addCategory(weekday, category);
            getRecommendMenu(coaches, weekday, category); // 코치별 메뉴 생성 -> result repository 등록
        }
    }

    private static void getRecommendMenu(List<Coach> coaches, Week weekday, Category category) {
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
        // 만약 코치가 먹은 메뉴 중 중복된 메뉴가 있거나 못먹는 메뉴이면 true를 반환한다.
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
