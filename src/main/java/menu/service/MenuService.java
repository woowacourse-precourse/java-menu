package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.*;
import menu.util.Parser;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

    private final static int DAYS = 5;
    private final static int MAX_DUPLICATED_CATEGORY = 2;
    private final static int CATEGORY_INDEX_MIN = 1;
    private final static int CATEGORY_INDEX_MAX = 5;
    private final static String JAPANESE = "일식";
    private final static int JAPANESE_INDEX = 1;
    private final static String KOREAN = "한식";
    private final static int KOREAN_INDEX = 2;
    private final static String CHINESE = "중식";
    private final static int CHINESE_INDEX = 3;
    private final static String ASIAN = "아시안";
    private final static int ASIAN_INDEX = 4;
    private final static String WESTERN = "양식";
    private final static int WESTERN_INDEX = 5;


    private CategoryResult categoryResult;
    private int categoryPool[] = new int[DAYS + 1];
    public static MenuService instance = new MenuService();
    List<String> categoryResultList = new ArrayList<>();

    private MenuService() {
        for (int i = 1; i <= DAYS; i++) {
            categoryPool[i] = MAX_DUPLICATED_CATEGORY;
        }
    }

    public static MenuService getInstance() {
        return instance;
    }

    public RecommendResult recommend(List<Coach> coachList) {

        List<MenuResult> menuResultList = new ArrayList<>();
        for (int i = 0; i < DAYS; i++) {
            String category = recommendCategory();
            categoryResultList.add(category);
            for (Coach coach : coachList) {
                coach.getMenuList().add(recommendMenu(coach, category));
            }
        }
        categoryResult = new CategoryResult(categoryResultList);
        for (Coach coach : coachList) {
            menuResultList.add(new MenuResult(coach.getCoachName(), coach.getMenuList()));
        }
        return new RecommendResult(categoryResult, menuResultList);
    }

    public String recommendCategory() {

        while (true) {
            int i = Randoms.pickNumberInRange(CATEGORY_INDEX_MIN, CATEGORY_INDEX_MAX);
            if (categoryPool[i] > 0) {
                categoryPool[i]--;
                return convertCategoryNumberToString(i);
            }
        }
    }

    public Menu recommendMenu(Coach coach, String category) {
        List<String> impossibleMenus = coach.getImpossibleMenus();
        List<String> recommendMenuList = new ArrayList<>();
        List<String> alreadyRecommended = new ArrayList<>();
        String menus = Category.valueOf(category).getMenus();
        List<String> menuList = Parser.parse(menus);

        String selectedMenu = Randoms.shuffle(menuList).get(0);
        do {
            if (canRecommend(selectedMenu, impossibleMenus, alreadyRecommended)) {
                break;
            }
            selectedMenu = Randoms.shuffle(menuList).get(0);
        } while (true);
        alreadyRecommended.add(selectedMenu);
        recommendMenuList.add(selectedMenu);
        return new Menu(selectedMenu);

    }

    private boolean canRecommend(String selectedMenu, List<String> impossibleMenus, List<String> alreadyRecommended) {
        if (impossibleMenus.contains(selectedMenu) || alreadyRecommended.contains(selectedMenu))
            return false;
        return true;
    }

    public String convertCategoryNumberToString(int index) {
        if (index == JAPANESE_INDEX) {
            return JAPANESE;
        } else if (index == KOREAN_INDEX) {
            return KOREAN;
        } else if (index == CHINESE_INDEX) {
            return CHINESE;
        } else if (index == ASIAN_INDEX) {
            return ASIAN;
        } else if (index == WESTERN_INDEX) {
            return WESTERN;
        }
        return "error";
    }
}
