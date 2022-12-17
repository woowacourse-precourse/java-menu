package menu.dto;

import menu.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuggestMenuResultDto {

    private List<Category> categories;
    private Map<String, List<String>> coachWeeklyMenu = new HashMap<>();


    public SuggestMenuResultDto(List<Category> categories) {
        this.categories = categories;
    }

    public void addCoachMenuList(String coachName, List<String> menuList){
        coachWeeklyMenu.put(coachName, new ArrayList<>(menuList));
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Map<String, List<String>> getCoachWeeklyMenu() {
        return coachWeeklyMenu;
    }
}
