package menu.domain;

import menu.domain.generator.CategoryGenerator;

public class RecommendMaker {

    private final CategoryGenerator categoryGenerator;

    public RecommendMaker(CategoryGenerator categoryGenerator) {
        this.categoryGenerator = categoryGenerator;
    }

    public void recommend() {
        CoachRepository.getCoaches()
                .forEach(this::recommendEachCoach);
    }

    private void recommendEachCoach(Coach coach) {
        while (!isRecommendFinished(coach)) {
            recommendCategory(coach);
        }
    }

    private boolean isRecommendFinished(Coach coach) {
        return coach.isRecommendFinish();
    }

    private void recommendCategory(Coach coach) {
        Category category;
        do {
            category = categoryGenerator.generate();
        } while (!coach.checkTooManySameCategory(category));
    }
}
