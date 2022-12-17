package menu.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Category {
    public Category(){};

    public static List<Integer> recommandCategory() {
        List<Integer> category = new ArrayList<>();
        while (category.size() < 5 ) {
            Integer value = Randoms.pickNumberInRange(1,5);
            if (getCategoryFrequency(category,value) >= 2)
                continue;
            category.add(value);
        }
        return category;
    }

    public static Integer getCategoryFrequency(List<Integer> category, Integer value) {
        int count = 0;
        for (int i = 0; i < category.size(); i++) {
            if (category.get(i) == value)
                count += 1;
        }
        return count;
    }
}
