package menu;

import java.util.List;

public class Member {
    private String name;
    private List<String> pickyEatings;
    private List<String> recommendedMeal;

    public Member(String name, List<String> pickyEatings) {
        this.name = name;
        this.pickyEatings = pickyEatings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPickyEatings() {
        return pickyEatings;
    }

    public void setPickyEatings(List<String> pickyEatings) {
        this.pickyEatings = pickyEatings;
    }

    public List<String> getRecommendedMeal() {
        return recommendedMeal;
    }

    public void setRecommendedMeal(List<String> recommendedMeal) {
        this.recommendedMeal = recommendedMeal;
    }
}
