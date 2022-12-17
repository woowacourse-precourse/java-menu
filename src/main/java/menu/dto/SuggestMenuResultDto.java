package menu.dto;

import menu.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class SuggestMenuResultDto {

    private List<Category> categories;
//    private Map<String, List<String>> coachWeeklyMenu = new HashMap<>();
    private List<String> coachNames = new ArrayList<>();
    private List<List<String>> coachWeeklyMenu = new ArrayList<>();

    public SuggestMenuResultDto(List<Category> categories) {
        this.categories = categories;
    }

    public void addResult(String coachName, List<String> menuList){
        this.coachNames.add(coachName);
        this.coachWeeklyMenu.add(new ArrayList<>(menuList));
    }

    public List<Category> getCategories() {
        return categories;
    }

//    public Map<String, List<String>> getCoachWeeklyMenu() {
//        return coachWeeklyMenu;
//    }

    public List<String> getCoachNames() {
        return coachNames;
    }

    public List<List<String>> getCoachWeeklyMenu() {
        return coachWeeklyMenu;
    }
}
