package menu.domain;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandomFood {
    private List<String> randomCategories = new ArrayList<>();
    private List<String> categories = new ArrayList<>(Arrays.asList(" " ,"일식","한식","중식","아시안","양식"));
    private Map<String, List<String>> randomFoods = new HashMap<>();

    public String pickCategory(){
        String category = categories.get(Randoms.pickNumberInRange(1, 5));
        return category;
    }
    public List<String> allCategory() {
        String category;
        int count =0;
        while(count < 5) {
            category = pickCategory();
            if (Collections.frequency(randomCategories, category) < 2) {
                randomCategories.add(category);
                count++;
            }
        }
        return randomCategories;
    }

}
