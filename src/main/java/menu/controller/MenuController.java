package menu.controller;

import static menu.constant.CategoryConstants.*;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Categories;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.util.StringParser;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    Categories categories;
    Coaches coaches;

    public MenuController() {
        categories = new Categories(categoriesInit());
        coaches = new Coaches();
    }

    private List<Category> categoriesInit() {
        List<String> japanese = StringParser.getSplitList(JAPANESE_MENU);
        List<String> korean = StringParser.getSplitList(KOREAN_MENU);
        List<String> chinese = StringParser.getSplitList(CHINESE_MENU);
        List<String> asian = StringParser.getSplitList(ASIAN_MENU);
        List<String> western = StringParser.getSplitList(WESTERN_MENU);
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(JAPANESE, japanese));
        categories.add(new Category(KOREAN, korean));
        categories.add(new Category(CHINESE, chinese));
        categories.add(new Category(ASIAN, asian));
        categories.add(new Category(WESTERN, western));
        return categories;
    }

    public void run() {
        OutputView.printStartMessage();
        coachesInit();
        recommendMenuToCoaches();
        OutputView.printEndMessage();
    }

    private void coachesInit() {
        List<String> coachNames = StringParser.getSplitList(InputView.getCoachNames());
        coachNames.stream().forEach(name -> coaches.add(new Coach(name)));
        coaches.getCoaches().stream().forEach(coach -> {
            List<String> cantEatMenu = StringParser.getSplitList(InputView.getCantEatMenu(categories, coach.getName()));
            coach.setCantEatMenu(cantEatMenu);
        });
    }

    private void recommendMenuToCoaches() {
        List<Category> recommendedCategories = categories.getRecommendedCategories();
        recommendedCategories.stream().forEach(category -> {
            coaches.getCoaches().stream().forEach(coach -> coach.addEatMenu(category));
        });
        OutputView.printRecommendedResult(recommendedCategories, coaches);
    }
}
