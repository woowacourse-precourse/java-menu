package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static menu.constant.SystemConstant.*;

public class Coach {

    private final String coachName;
    private final List<Menu> dislikeMenus = new ArrayList<>();
    private final Map<Category, List<Menu>> recommendMenus = new HashMap<>();

    public Coach(String coachName) {
        validateNameLength(coachName);
        this.coachName = coachName;
    }

    public void addDislikeMenu(Menu menu) {
        dislikeMenus.add(menu);
    }

    public String getCoachName() {
        return coachName;
    }

    public void addRecommendMenu(Category category, Menu menu) {
        if (!recommendMenus.containsKey(category)) {
            recommendMenus.put(category, new ArrayList<>());
        }
        recommendMenus.get(category).add(menu);
    }

//    public List<Menu> getRecommendMenus() {
//        return recommendMenus;
//    }

    public boolean isRecommendFinish() {
        return getRecommendMenus().size() == DAY_COUNT;
    }

    public boolean checkTooManySameCategory(Category category) {
        if (recommendMenus.keySet().size() >= MAX_CATEGORY_COUNT) {
            return recommendMenus.containsKey(category);
        }
        return true;
    }

    public boolean checkValidMenu(Menu menu) {
        if (checkOverlappedMenu(menu)) {
            return false;
        }
        if (isDislikeMenu(menu)) {
            return false;
        }
        return true;
    }

    public List<Menu> getRecommendMenus() {
        List<Menu> recommends = new ArrayList<>();
        recommendMenus.keySet()
                .forEach(category -> recommends.addAll(recommendMenus.get(category)));
        return recommends;
    }

    private boolean checkOverlappedMenu(Menu menu) {
        return getRecommendMenus().stream()
                .anyMatch(recommendMenu -> recommendMenu.equals(menu));
    }

    private boolean isDislikeMenu(Menu menu) {
        return dislikeMenus.contains(menu);
    }

    private void validateNameLength(String coachName) {
        if (coachName.length() > COACH_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_PREFIX + "코치의 이름은 최대 " + COACH_NAME_MAX_LENGTH + "자 입니다.");
        }
        if (coachName.length() < COACH_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(ERROR_PREFIX + "코치의 이름은 최소 " + COACH_NAME_MIN_LENGTH + "자 입니다.");
        }
    }
}
