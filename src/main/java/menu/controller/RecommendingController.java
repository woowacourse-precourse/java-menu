package menu.controller;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.outputview.RecommendingOutputView;
import menu.service.RecommendingService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecommendingController extends AbstractController {
    @Override
    public void doProcess() {
        RecommendingService.doRecommending();
        List<String> categoryNames = getRecommendedCategoryNames();
        Map<Coach, List<Menu>> recommendedMenus = RecommendingService.getMenusArraysPerCoach();
        RecommendingOutputView.printRecommendingResult(categoryNames, recommendedMenus);
    }

    private static List<String> getRecommendedCategoryNames() {
        List<Category> categories = RecommendingService.getRecommendedCategories();
        return categories.stream().map(Category::getName).collect(Collectors.toList());
    }
}
