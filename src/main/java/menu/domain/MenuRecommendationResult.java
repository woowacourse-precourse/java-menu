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

        String shuffledMenu;
        while (true) {
            shuffledMenu = Categories.getShuffledMenu(index);
            if (validateHateMenu(coachName, shuffledMenu)) break;
        }

        HashMap<String, String> result = new HashMap<>();
        result.put(coachName, shuffledMenu);

        recommendationResult.put(day, result);
    }

    private boolean validateHateMenu(String coachName, String shuffledMenu) {
        Map<String, List<String>> coachHateMenu = CoachRepository.getCoachHateMenu();
        if (coachHateMenu.get(coachName).contains(shuffledMenu)) {
            return false;
        }
        return true;
    }

    public Map<Day, Map<String, String>> getRecommendationResult() {
        return recommendationResult;
    }
}
