package menu.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.Util.CategoryAndFood;

import java.util.ArrayList;
import java.util.List;

public class CategoryGenerator {
    private List<String> recommandList;
    private CategoryAndFood categoryAndFood;
    private int[] categoryCount;

    public CategoryGenerator() {
        this.recommandList = new ArrayList<>();
        this.categoryAndFood = new CategoryAndFood();
        this.categoryCount = new int[6];
    }

//    public List<String> generate() {
//        List<String> categoryList = categoryAndFood.getCategoryList();
//        while (recommandList.size() < 5) {
//            int number = Randoms.pickNumberInRange(1, 5);
//            if (validateNumber(number)) {
//                recommandList.add(categoryList.get(number - 1));
//                this.categoryCount[number]++;
//            }
//        }
//        return recommandList;
//    }

    public String generateCategory() {
        List<String> categoryList = categoryAndFood.getCategoryList();
        int number = Randoms.pickNumberInRange(1, 5);
        if (validateNumber(number)) {
            this.categoryCount[number]++;
        }
        return categoryList.get(number - 1);
    }

    private boolean validateNumber(int num) {
        if (this.categoryCount[num] >= 2) {
            return false;
        }
        return true;
    }

}
