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

    private boolean validateMenuDuplication(String menu, Member member) {
        if (member.getRecommendedMeal().contains(menu)) {
            return false;
        }
        return true;
    }
    
}
