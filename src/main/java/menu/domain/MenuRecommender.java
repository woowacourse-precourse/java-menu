package menu.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommender {
    //key - 코치, value = 요일별 메뉴들
    private final Map<Coach, List<String>> recommendation;

    public MenuRecommender() {
        this.recommendation = new HashMap<>();

    }
}
