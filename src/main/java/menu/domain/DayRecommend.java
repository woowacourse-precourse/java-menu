package menu.domain;

import java.util.Map;

public class DayRecommend {
    public static final String COUCH_FLAVOR_ERROR_MESSAGE = "[Error] 코치가 먹을 수 없는 음식을 메뉴로 선정할 수는 없습니다.";

    private final String dayName;
    private Map<Coach, Menu> recommendData;

    public Map<Coach, Menu> getRecommendData() {
        return recommendData;
    }

    public DayRecommend(String dayName) {
        this.dayName = dayName;
    }

    public void enrollCouchMenu(Coach coach, Menu menu) {
        checkCouchFlavor(coach, menu);
        recommendData.put(coach, menu);
    }

    public boolean isCoachMenu(Coach coach, Menu menu) {
        if (checkExitingCoach(coach)) {
            return getMenuOf(coach).isSame(menu);
        }
        return false;
    }

    public boolean is(String dayName) {
        return this.dayName.equals(dayName);
    }


    private void checkCouchFlavor(Coach coach, Menu menu) {
        if (!coach.canEat(menu)) {
            throw new IllegalArgumentException(COUCH_FLAVOR_ERROR_MESSAGE);
        }
    }

    private boolean checkExitingCoach(Coach coach) {
        return recommendData.keySet().stream()
                .anyMatch(anyCoach -> anyCoach.isSame(coach));
    }

    public Menu getMenuOf(Coach coach) {
        Coach target = recommendData.keySet().stream().filter(ch -> ch.isSame(coach)).findAny().get();
        return recommendData.get(target);
    }
}
