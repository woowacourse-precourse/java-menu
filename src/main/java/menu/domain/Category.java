package menu.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Category {
    private static List<Integer> categoryCnt;
    public Category(){
        this.categoryCnt = new ArrayList<>();
    };

    public static Integer recommandDayCategory() {
        while (true) {
            Integer value = Randoms.pickNumberInRange(1, 5);
            if (frequencyCnt(value))
                continue;
            categoryCnt.add(value);
            return value;
        }
    }

    public static boolean frequencyCnt(Integer value) {
        int tmp = 0;
        for (int i = 0; i  < categoryCnt.size(); i++) {
            if (categoryCnt.get(i) == value)
                tmp++;
        }
        if (tmp >= 2)
            return true;
        return false;
    }

    public static List<Integer> getCategory() {
        return categoryCnt;
    }
}
