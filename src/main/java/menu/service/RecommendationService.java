package menu.service;

public class RecommendationService {
    private static class InstanceHolder {
        private static final RecommendationService INSTANCE = new RecommendationService();
    }

    private RecommendationService(){}

    public static RecommendationService getInstance() {
        return RecommendationService.InstanceHolder.INSTANCE;
    }
}
