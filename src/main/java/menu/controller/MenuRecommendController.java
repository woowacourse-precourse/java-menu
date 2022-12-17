package menu.controller;

import menu.model.*;
import menu.service.CoachService;
import menu.service.MenuCategoryService;
import menu.service.MenuService;
import menu.service.RecommendResultService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class MenuRecommendController {
    private final CoachService coachService;
    private final MenuService menuService;
    private final MenuCategoryService menuCategoryService;
    private final RecommendResultService recommendResultService;
    public MenuRecommendController() {
        this.coachService = new CoachService();
        this.menuService = new MenuService();
        this.menuCategoryService = new MenuCategoryService();
        this.recommendResultService = new RecommendResultService();
    }

    public void startRecommend() {
        OutputView.printStartMessage();
        saveCoaches();
        OutputView.printResultMessage();
        calcRecommendResults();
        List<RecommendResult> recommendResults = recommendResultService.findAll();
        List<Coach> coaches = coachService.findAll();
        OutputView.printResult(recommendResults, coaches);
        OutputView.printFinishMessage();
    }

    private void calcRecommendResults() {
        calcRecommendResultsHaveMenuCategory();
        calcRecommendResultHaveCoachAndMenu();
    }

    public void calcRecommendResultHaveCoachAndMenu() {
        List<RecommendResult> recommendResults = recommendResultService.findAll();
        List<MenuCategory> menuCategories = recommendResults.stream().map(RecommendResult::getMenuCategory).collect(Collectors.toList());
        List<Coach> coaches = coachService.findAll();
        for (int i = 0; i < menuCategories.size(); i++) {
            for (Coach coach : coaches) {
                Menu menu = getMenuByCoach(menuCategories.get(i), coach);
                recommendResultService.update(coach, menu, i);
            }
        }
    }

    private Menu getMenuByCoach(MenuCategory menuCategory, Coach coach) {
        List<RecommendResult> recommendResults = recommendResultService.findAll();
        Menu randomMenu = menuService.getRandomMenuByMenuCategory(menuCategory);
        List<Menu> menus = recommendResults.stream().map(recommendResult
                -> recommendResult.getCoachAndMenu().get(coach)).collect(Collectors.toList());
//        if(menus.size() != 0 && menus.stream().anyMatch(menu -> menu.equals(randomMenu))) {
//            return getMenuByCoach(menuCategory, coach);
//        }
        return randomMenu;
    }

    private void calcRecommendResultsHaveMenuCategory() {
        List<DayOfTheWeek> dayOfTheWeeks = Arrays.stream(DayOfTheWeek.values()).collect(Collectors.toList());
        for (DayOfTheWeek day : dayOfTheWeeks) {
            MenuCategory menuCategory = getRandomMenuCategory();
            recommendResultService.save(new RecommendResult(day, menuCategory));
        }
    }

    private MenuCategory getRandomMenuCategory() {
        List<RecommendResult> recommendResults = recommendResultService.findAll();
        MenuCategory menuCategory = menuCategoryService.getRandomMenuCategory();
        MenuCategory finalMenuCategory = menuCategory;
        if(recommendResults.stream().filter(recommendResult
                -> recommendResult.getMenuCategory().equals(finalMenuCategory)).count() >= 2) {
            menuCategory = getRandomMenuCategory(); // 카테고리가 2회 이상 겹치는 경우 다시 뽑는다.
        }
        return menuCategory;
    }

    public void saveCoaches() {
        List<String> coachNames = this.readCoaches();
        for (String coachName : coachNames) {
            OutputView.printInputHateMenuMessage(coachName);
            saveHateMenus(coachName);
        }
    }

    private void saveHateMenus(String coachName) {
        List<String> hateMenus = InputView.readHateMenus();
        if(hateMenus.get(0).isBlank()){
            coachService.addCoach(coachName, new ArrayList<>());
            return;
        }
        coachService.addCoach(coachName, hateMenus.stream().map(menuService::findByName).collect(Collectors.toList()));
    }

    public List<String> readCoaches() {
        OutputView.printCoachNameMessage();
        List<String> coachNames = new ArrayList<>();
        try {
            coachNames = InputView.readCoachNames();
        } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        coachNames = readCoaches();
        }
        return coachNames;
    }
}
