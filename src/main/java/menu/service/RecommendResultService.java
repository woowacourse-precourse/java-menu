package menu.service;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.DayWeek;
import menu.domain.RecommendResult;
import menu.repository.RecommendResultRepository;

import java.util.List;

public class RecommendResultService {
    private final RecommendResultRepository resultRepository = new RecommendResultRepository();

    public void createAndSaveResult(Coach coach, DayWeek dayWeek, String menuName) {
        RecommendResult recommendResult = new RecommendResult(dayWeek, menuName);
        resultRepository.saveMenuResult(coach, recommendResult);
    }

    public void saveCategoryResult(DayWeek dayWeek, Category category) {
        resultRepository.saveCategoryResult(dayWeek, category);
    }

    public String getRecommendResult(List<Coach> coaches) {
        StringBuilder recommendResult = new StringBuilder("");
        for (Coach coach : coaches) {
            List<RecommendResult> results = resultRepository.findRecommendResultByCoach(coach);
            recommendResult.append("[ ").append(coach).append(" | ")
                    .append(RecommendResult.getRecommendMenuNames(results)).append(" ]\n");
        }
        return recommendResult.toString();
    }

    public String getRecommendCategory() {
        List<Category> categories = resultRepository.findCategoryByDayWeek();
        return Category.getCategoryNames(categories);
    }
}
