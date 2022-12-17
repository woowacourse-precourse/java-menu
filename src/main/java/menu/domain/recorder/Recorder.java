package menu.domain.recorder;

import menu.domain.category.Category;
import menu.domain.history.RecommendHistory;

import java.util.List;
import java.util.Map;

public class Recorder {

    private final RecommendHistory history;

    public Recorder(RecommendHistory history) {
        this.history = history;
    }

    public void recordCategory(Category category) {
        history.recordCategory(category);
    }

    public void recordMenuByCoach(Map<String, String> menuByCoach, List<String> coachNames) {
        for (String coachName : coachNames) {
            String menu = menuByCoach.get(coachName);
            history.recordMenuByCoach(menu, coachName);
        }
    }
}
