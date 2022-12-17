package menu.model;

import java.util.List;

public class Coach {
    private String name;
    private static List<Integer> category;
    private List<String> notEatMenus;
    private List<String> recommendedMenus;

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getCategory() {
        return category;
    }

    public void setCategory(List<Integer> category) {
        this.category = category;
    }

    public List<String> getNotEatMenus() {
        return notEatMenus;
    }

    public void setNotEatMenus(List<String> notEatMenus) {
        this.notEatMenus = notEatMenus;
    }

    public List<String> getRecommendedMenus() {
        return recommendedMenus;
    }

    public void setRecommendedMenus(List<String> recommendedMenus) {
        this.recommendedMenus = recommendedMenus;
    }
}
