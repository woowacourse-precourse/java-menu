package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FoodRecommendMachine {
    public static final int MAX_CATEGORY_NUM = 2;
    public static final int MENU_DONT_RECOMMENDED = 0;

    private FoodPeerCoaches coaches;
    private Map<DayRecommend, MenuBoard> foodRecommends = new HashMap<>();

    public FoodRecommendMachine(FoodPeerCoaches foodPeerCoaches) {
        this.coaches = foodPeerCoaches;
    }

    public Map<DayRecommend, MenuBoard> getFoodRecommends() {
        return foodRecommends;
    }

    public void makeRecommend() {
        makeRecommendOf("월요일");
        makeRecommendOf("화요일");
        makeRecommendOf("수요일");
        makeRecommendOf("목요일");
        makeRecommendOf("금요일");
    }

    private void makeRecommendOf(String dayName) {
        DayRecommend dayRecommend = new DayRecommend(dayName);
        MenuBoard menuBoard = selectCategory();
        makeTodayRecommend(dayRecommend, menuBoard);
        this.foodRecommends.put(dayRecommend, menuBoard);
    }

    private MenuBoard selectCategory() {
        MenuBoard randomCategory = MenuBoard.of(Randoms.pickNumberInRange(1, 5));
        while (!checkCategoryValid(randomCategory)) {
            randomCategory = MenuBoard.of(Randoms.pickNumberInRange(1, 5));
        }
        return randomCategory;
    }

    private boolean checkCategoryValid(MenuBoard menuBoard) {
        if (Collections.frequency(foodRecommends.values(), menuBoard) > MAX_CATEGORY_NUM) {
            return false;
        }
        return true;
    }

    private void makeTodayRecommend(DayRecommend dayRecommend, MenuBoard menuBoard) {
        List<Coach> coachesList = coaches.getCoaches();
        for (Coach coach : coachesList) {
            dayRecommend.enrollCouchMenu(coach, makeTodayMenuOf(coach, menuBoard));
        }
    }

    private Menu makeTodayMenuOf(Coach coach, MenuBoard menuBoard) {
        Menu randomMenu = getRandomMenuOf(menuBoard);
        while (!coach.canEat(randomMenu)) {
            randomMenu = getRandomMenuOf(menuBoard);
        }
        while (!checkMenuDuplication(coach, randomMenu)) {
            randomMenu = getRandomMenuOf(menuBoard);
        }
        return randomMenu;
    }

    private Menu getRandomMenuOf(MenuBoard category) {
        return MenuBoard.getMenuOf(Randoms.shuffle(makeMenuListToString(category.getMenus())).get(0));
    }

    private boolean checkMenuDuplication(Coach coach, Menu menu) {
        long count = foodRecommends.keySet().stream()
                .filter(dayRecommend -> dayRecommend.isCoachMenu(coach, menu))
                .count();
        if (count == MENU_DONT_RECOMMENDED) {
            return true;
        }
        return false;
    }

    private List<String> makeMenuListToString(List<Menu> data) {
        return data.stream().map(menu -> menu.getMenuName())
                .collect(Collectors.toList());
    }
}
