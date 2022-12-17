package menu.domain.category;

import static menu.util.Constants.INIT_RECOMMENDED_COUNT_VALUE;

public class Category {
    private String name;
    private int recommendedCount;


    public Category(String name) {
        this.name = name;
        this.recommendedCount = INIT_RECOMMENDED_COUNT_VALUE;
    }

    public String getName() {
        return name;
    }

    public boolean isAlreadyRecommendedOver(int count) { // 네이밍 이상
        return recommendedCount >= count;
    }

    public void updateRecommendedCount() {
        this.recommendedCount++;
    }
}
