package menu.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommendationResult {
    private Map<Day, Map<String, String>> recommendationResult = new HashMap();

    public void menuRecommend(Day day, String coachName) {
        numberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int index = randomNumberGenerator.generate();
        Categories category = Categories.getCategoryBYIndex(index);
        String shuffledMenu = Categories.getShuffledMenu(index);

        HashMap<String, String> result = new HashMap<>();
        result.put(coachName, shuffledMenu);

        recommendationResult.put(day, result);
    }
}
