package menu;

import java.util.ArrayList;
import java.util.List;

public class MenuRecommender {
    private List<Member> members;
    private List<String> categories;

    public MenuRecommender() {
        members = new ArrayList<>();
        categories = new ArrayList<>();
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public void makeRecommends() {
        for (int i = 0; i < 5; i++) {
            manageMealsDayOfTheWeek();
        }
    }

    private void manageMealsDayOfTheWeek() {
        String category = chooseCategory();
        for (Member memeber : members) {
            chooseMenu(category, memeber);
        }
    }

    private String chooseCategory() {
        String category = MenuRandomGenerator.selectRandomCategory();
        while (!validateCategoryDuplication(category)) {
            category = MenuRandomGenerator.selectRandomCategory();
        }
        categories.add(category);
        return category;
    }

    private void chooseMenu(String category, Member member) {
        String menu = MenuRandomGenerator.selectRandomMenu(category);

        while (!validateMenuDuplication(menu, member) || !validatePickyEating(menu, member)) {
            menu = MenuRandomGenerator.selectRandomMenu(category);
        }
        member.addRecommendedMeal(menu);
    }

    private boolean validateMenuDuplication(String menu, Member member) {
        if (member.getRecommendedMeal().contains(menu)) {
            return false;
        }
        return true;
    }

    private boolean validateCategoryDuplication(String newCategory) {
        int duplicationCounter = 0;
        for (String category : categories) {
            if (category.equals(newCategory)) {
                duplicationCounter++;
            }
        }
        if (duplicationCounter == 2) {
            return false;
        }
        return true;
    }
    private boolean validatePickyEating(String menu, Member member) {
        if (member.getPickyEatings().contains(menu)) {
            return false;
        }
        return true;
    }
}
