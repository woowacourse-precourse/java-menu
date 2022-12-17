package menu.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class RecommendMenusResponse {
    private List<String> categories;
    private LinkedHashMap<String, List<String>> menus;

    public RecommendMenusResponse(List<String> categories, LinkedHashMap<String, List<String>> menus) {
        this.categories = categories;
        this.menus = menus;
    }

    public static RecommendMenusResponse of(List<RecommendMenu> recommendMenus) {
        List<String> categories = recommendMenus.stream()
                .map(RecommendMenu::getCategory)
                .collect(Collectors.toList());
        LinkedHashMap<String, List<String>> menus = initMenus(recommendMenus);
        for (RecommendMenu recommendMenu : recommendMenus) {
            addRecommendMenu(menus, recommendMenu);
        }

        return new RecommendMenusResponse(categories, menus);
    }

    private static void addRecommendMenu(LinkedHashMap<String, List<String>> menus, RecommendMenu recommendMenu) {
        List<CouchMenu> couchMenus = recommendMenu.getCouchMenus();
        for (CouchMenu couchMenu : couchMenus) {
            String couchName = couchMenu.getCouchName();
            List<String> recommendMenus = menus.get(couchName);
            recommendMenus.add(couchMenu.getMenuName());
        }
    }

    private static LinkedHashMap<String, List<String>> initMenus(List<RecommendMenu> recommendMenus) {
        LinkedHashMap<String, List<String>> menus = new LinkedHashMap<>();
        List<CouchMenu> couchMenus = recommendMenus.get(0).getCouchMenus();
        for (CouchMenu couchMenu : couchMenus) {
            menus.put(couchMenu.getCouchName(), new ArrayList<>());
        }
        return menus;
    }

    public List<String> getCategories() {
        return categories;
    }

    public LinkedHashMap<String, List<String>> getMenus() {
        return menus;
    }
}
