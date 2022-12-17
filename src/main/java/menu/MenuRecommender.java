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
