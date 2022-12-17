package menu.domain;

import java.util.Map;

public class DayRecommend {
    public static final String COUCH_FLAVOR_ERROR_MESSAGE = "[Error] 코치가 먹을 수 없는 음식을 메뉴로 선정할 수는 없습니다.";

    private final String dayName;
    private Map<Coach, Menu> recommendData;

    public DayRecommend(String dayName) {
        this.dayName = dayName;
    }

    public void enrollCouchMenu(Coach coach, Menu menu) {
        checkCouchFlavor(coach, menu);
        recommendData.put(coach, menu);
    }

    private void checkCouchFlavor(Coach coach, Menu menu) {
        if(!coach.canEat(menu)){
            throw new IllegalArgumentException(COUCH_FLAVOR_ERROR_MESSAGE);
        }
    }
}
