package menu.repository;

import menu.domain.Coach;

import java.util.*;

public class MenuRecommendRepository {
    private static final MenuRecommendRepository instance = new MenuRecommendRepository();

    private static final Map<Coach, List<String>> recommendation = new LinkedHashMap<>();

    private MenuRecommendRepository() {
    }

    public static MenuRecommendRepository getInstance() {
        return instance;
    }
    public static Map<Coach, List<String>> getRecommendation(){
        return recommendation;
    }
}
