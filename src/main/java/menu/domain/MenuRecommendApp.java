package menu.domain;

import java.util.*;
import java.util.stream.Collectors;

public class MenuRecommendApp {

    List<Category> categories;
    int[] checkCategoryAppearNumber;
    List<Coach> coaches;
    List<String> categoryByDayOfTheWeek;

    public MenuRecommendApp() {
        this.categories = new ArrayList<>();
        this.checkCategoryAppearNumber = new int[6];
        this.coaches = new ArrayList<>();
        this.categoryByDayOfTheWeek = new ArrayList<>();
    }

    public void initializeCoach(String coachNameWithComma) {
        String[] coachNames = coachNameWithComma.split(",");
        for (String coachName : coachNames) {
            coaches.add(new Coach(coachName));
        }
    }

    public void initializeCategory(){
        for (CategoryEnum category : CategoryEnum.values()) {
            categories.add(new Category(category.name() , category.getNum() , Arrays.stream(category.getMenus().split(",")).collect(Collectors.toList())));
        }
    }

    public void addCategoryByDayOfTheWeek(String categoryName){
        categoryByDayOfTheWeek.add(categoryName);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<String> getCategoryByDayOfTheWeek() {
        return categoryByDayOfTheWeek;
    }
}
