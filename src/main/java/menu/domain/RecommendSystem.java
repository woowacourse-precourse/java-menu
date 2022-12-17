package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RecommendSystem {

    private static final int RECOMMAND_MIN_NUM = 1;
    private static final int RECOMMAND_MAX_NUM = 5;
    private static final int CHECK_OVERLAP = 2;

    public void addCoachCategory(Coach coach) {
        List<String> categories = coach.getRecommendedCategory();
        while(!(categories.size() == RECOMMAND_MAX_NUM)) {
            int num = randomCategory();
            String category = Category.getCategory(num);
            if(checkCategoryCount(categories, category)) {
                continue;
            }
            categories.add(category);
        }


    }

    private int randomCategory() {
        return Randoms.pickNumberInRange(RECOMMAND_MIN_NUM,RECOMMAND_MAX_NUM);
    }

    private boolean checkCategoryCount(List<String> coachRecommendCategory, String category) {
        int count  = 0;
        for(String coachCategory : coachRecommendCategory) {
            if (coachCategory.equals(category)) {
                count++;
            }
        }
        if(count > CHECK_OVERLAP) {
            return true;
        }
        return false;
    }

}
