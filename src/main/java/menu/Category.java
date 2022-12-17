package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Category {
    private final static int SIZE = 5;
    private final static int DUP_COUNT = 2;
    final static List<String> categories = Arrays.asList("일식", "한식", "중식", "아시안", "양식");

    public List<String> choose() {
        List<String> result = new ArrayList<>();
        while (result.size() < SIZE) {
            int num = Randoms.pickNumberInRange(1, SIZE) - 1;
            String category = categories.get(num);
            if (containCount(result, category) < DUP_COUNT) {
                result.add(category);
            }
        }
        return result;
    }

    private int containCount(List<String> list, String category) {
        int count = 0;
        for (String item : list) {
            if (item.equals(category)) {
                count++;
            }
        }
        return count;
    }
}
