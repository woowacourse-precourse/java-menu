package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommender {

    private static final String COACH_NAME_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 중복되는 코치의 이름이 입력되었습니다.";

    private static final int MIN_COACH_NUMBER = 2;
    private static final int MAX_COACH_NUMBER = 5;
    private static final int MAX_DUPLICATE_CATEGORY_COUNT = 2;

    private List<Coach> coaches;
    private Map<Day, Menu> weekCategoryLog;

    public MenuRecommender() {
        coaches = new ArrayList<>();
        weekCategoryLog = new HashMap<>();
    }

    public void addCoaches(List<String> coachNames) {
        for (String name : coachNames) {
            addCoach(name);
        }
    }

    public void addCoach(String coachName) {
        try {
            Coach coach = new Coach(coachName);
            validateCoach(coach);
            coaches.add(coach);
        } catch (IllegalArgumentException exception) {
            initCoaches();
            throw exception;
        }
    }

    private void validateCoach(Coach coach) {
        if (coaches.contains(coach)) {
            initCoaches();
            throw new IllegalArgumentException(COACH_NAME_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private void initCoaches() {
        coaches = new ArrayList<>();
    }

    public void selectRecommendedMenus() {
        for (Day day : Day.values()) {
            selectCategory(day);
            for (Coach coach : coaches) {
                selectMenu(day, coach);
            }
        }
    }

    private void selectCategory(Day day) {
        Menu selectedCategory;
        do {
            selectedCategory = Menu.findByCode(Randoms.pickNumberInRange(Menu.MIN_CODE, Menu.MAX_CODE));
        } while (!isAvailableCategory(selectedCategory));
        weekCategoryLog.put(day, selectedCategory);
    }

    private boolean isAvailableCategory(Menu menu) {
        int prevCount = (int) weekCategoryLog.values().stream()
                .filter(prevCategory -> prevCategory.equals(menu))
                .count();
        return prevCount < MAX_DUPLICATE_CATEGORY_COUNT;
    }

    private void selectMenu(Day day, Coach coach) {
        String menu;
        do {
            List<String> foods = weekCategoryLog.get(day).getFoods();
            menu = Randoms.shuffle(foods).get(0);
        } while (!isAvailableFood(coach, menu));

        coach.addFood(day, menu);
    }

    private boolean isAvailableFood(Coach coach, String menu) {
        return coach.isEatable(menu) && !coach.isEatBefore(menu);
    }

    public Menu getCategoryAt(Day day) {
        return weekCategoryLog.get(day);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public int getMinCoachNumber() {
        return MIN_COACH_NUMBER;
    }

    public int getMaxCoachNumber() {
        return MAX_COACH_NUMBER;
    }
}
