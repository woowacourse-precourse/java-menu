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
        System.out.println("recommendResult = " + recommendResult);
        resultRepository.saveMenuResult(coach, recommendResult);
    }

    public void saveCategoryResult(DayWeek dayWeek, Category category) {
        resultRepository.saveCategoryResult(dayWeek, category);
    }
    public void getRecommendResult(List<Coach> coaches) {

    }
}
