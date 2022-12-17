package menu.domain;

import java.util.List;
import java.util.Map;

public class DayRecommend {
    public static final String COUCH_FLAVOR_ERROR_MESSAGE = "[Error] 코치가 먹을 수 없는 음식을 메뉴로 선정할 수는 없습니다.";

    private final String dayName;
    private Map<Couch, Menu> recommendData;

    public DayRecommend(String dayName) {
        this.dayName = dayName;
    }

    public void enrollCouchMenu(Couch couch, Menu menu) {
        checkCouchFlavor(couch, menu);
        recommendData.put(couch, menu);
    }

    private void checkCouchFlavor(Couch couch, Menu menu) {
        if(!couch.canEat(menu)){
            throw new IllegalArgumentException(COUCH_FLAVOR_ERROR_MESSAGE);
        }
    }
}
