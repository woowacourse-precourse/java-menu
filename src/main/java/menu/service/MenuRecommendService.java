package menu.service;

import menu.domain.Category;
import menu.domain.Coach;

public interface MenuRecommendService {
    void recommend(Coach coach, Category category);
}
