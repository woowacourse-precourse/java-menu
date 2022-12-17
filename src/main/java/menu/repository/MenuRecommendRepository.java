package menu.repository;

import menu.domain.Coach;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommendRepository {
    private static final MenuRecommendRepository instance = new MenuRecommendRepository();

    private static final Map<Coach, List<String>> recommendation = new HashMap<>();

    private MenuRecommendRepository() {
    }

    public static MenuRecommendRepository getInstance() {
        return instance;
    }
    public static Map<Coach, List<String>> getRecommendation(){
        return recommendation;
    }
}
