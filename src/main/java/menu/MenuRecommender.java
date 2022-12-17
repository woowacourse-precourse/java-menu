package menu;

import java.util.ArrayList;
import java.util.List;

public class MenuRecommender {
    private List<Member> members;
    private List<String> categories; //카테고리 이름으로 저장

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

    public void chooseCategory() {
        String category = MenuRandomGenerator.selectRandomCategory();
        while (!validateCategoryDuplication(category)) {
            category = MenuRandomGenerator.selectRandomCategory();
        }
        categories.add(category);
    }

    public void chooseMenu(String category, Member member) {
        String menu = MenuRandomGenerator.selectRandomMenu(category);

        //중복과 편식 둘 다 해당하지 않을 때 까지 반복
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
