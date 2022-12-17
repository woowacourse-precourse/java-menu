package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Category {
    final static List<String> categories = Arrays.asList("한식", "일식", "중식", "아시안", "양식");

    public List<String> Choose() {
        List<String> result = new ArrayList<>();
        while (result.size() < 5) {
            String category = categories.get(Randoms.pickNumberInRange(0, 4));
            if (ContainCount(result, category) < 2) {
                result.add(category);
            }
        }
        return result;
    }

    private int ContainCount(List<String> list, String category) {
        int count = 0;
        for (String item : list) {
            if (item.equals(category)) {
                count++;
            }
        }
        return count;
    }
}
