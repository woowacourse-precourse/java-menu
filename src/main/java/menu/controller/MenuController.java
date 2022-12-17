package menu.controller;

import menu.domain.category.Category;
import menu.domain.coach.Coach;
import menu.domain.draw.CategoryDraw;
import menu.domain.draw.MenuDraw;
import menu.domain.factory.CoachCreator;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuRepository;
import menu.domain.week.Week;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    
    public MenuController() {
        inputView = new InputView();
        this.outputView = new OutputView();
    }
    
    public void run() {
        outputView.printApplicationStartGuide();
        List<Coach> coaches = inputView.repeatInput(() -> CoachCreator.from(inputView.inputCoachNames(outputView)), outputView);
    
        coachesAddUneatableMenus(coaches);
    
        addMenu(coaches);
    
        outputView.printRecommendResult(coaches);
    }
    
    private void coachesAddUneatableMenus(List<Coach> coaches) {
        for (Coach coach : coaches) {
            List<Menu> uneatableMenus = inputView.repeatInput(() -> addUneatableMenus(coach), outputView);
            coach.addUneatableMenu(uneatableMenus);
        }
    }
    
    private void addMenu(List<Coach> coaches) {
        List<Week> weeks = Arrays.stream(Week.values())
                .collect(Collectors.toUnmodifiableList());
        
        for (Week week : weeks) {
            addMenuToOneWeek(coaches, week);
        }
    }
    
    private void addMenuToOneWeek(List<Coach> coaches, Week week) {
        Category category = CategoryDraw.categoryDraw();
        
        for (Coach coach : coaches) {
            addOneCoachMenu(week, category, coach);
        }
    }
    
    private void addOneCoachMenu(Week week, Category category, Coach coach) {
        Menu menu = MenuDraw.menuDraw(category);
        if (isUnavailableMenu(coach, menu)) {
            addOneCoachMenu(week, CategoryDraw.categoryDraw(), coach);
        }
        
        coach.addMenu(week, menu);
    }
    
    private boolean isUnavailableMenu(Coach coach, Menu menu) {
        return coach.isExistSameMenu(menu) || coach.isExistSameCategoryOverTwo(menu) || coach.isUneatableMenu(menu);
    }
    
    private List<Menu> addUneatableMenus(Coach coach) {
        String menusString = inputView.inputUneatableMenu(outputView, coach.name());
        if (menusString.isEmpty()) {
            return new ArrayList<>();
        }
    
        List<String> menuNames = parseMenuNames(menusString);
        return parseUneatableMenus(menuNames);
    }
    
    private static List<Menu> parseUneatableMenus(List<String> menuNames) {
        List<Menu> uneatableMenus = new ArrayList<>();
        for (String menuName : menuNames) {
            Menu menu = MenuRepository.findByMenuName(menuName);
            uneatableMenus.add(menu);
        }
        return uneatableMenus;
    }
    
    private static List<String> parseMenuNames(String menusString) {
        return Arrays.stream(menusString.split(","))
                .collect(Collectors.toUnmodifiableList());
    }
}
