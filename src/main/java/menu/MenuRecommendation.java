package menu;

import camp.nextstep.edu.missionutils.Randoms;

public class MenuRecommendation {
    
    public Category getRandomCategory() {
        int number = Randoms.pickNumberInRange(1, 5);
        Category[] categories = Category.values();

        return categories[number - 1];
    }
}
