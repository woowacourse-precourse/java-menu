package controller;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import model.Category;
import model.Coach;
import model.Coaches;
import model.DayOfTheWeek;
import model.WeeklyMenu;
import model.WeeklyMenuMaker;
import model.WeeklyMenus;
import model.WeeklyRandomMenuMakerGenerator;
import view.InputView;
import view.OutputView;

public class MenuController {
    
    private static final int MAX_CATEGORY_REDUPLICATION_COUNT = 2;
    private final InputView inputView;
    private final OutputView outputView;
    private final WeeklyMenuMaker weeklyMenuMaker;
    
    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        weeklyMenuMaker = new WeeklyMenuMaker(new WeeklyRandomMenuMakerGenerator());
    }
    
    public void run() {
        outputView.printStartService();
        Coaches coaches = getCoaches();
        addInedibleMenus(coaches);
        WeeklyMenus weeklyMenus = makeMenuRecommendation(coaches);
        outputView.printMenuRecommendation(coaches, weeklyMenus);
        outputView.printEndOfService();
    }
    
    private Coaches getCoaches() {
        try {
            List<String> coachNames = inputView.readCoachNames();
            
            List<Coach> coaches = getCoaches(coachNames);
            return new Coaches(coaches);
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return getCoaches();
        }
    }
    
    private List<Coach> getCoaches(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            coaches.add(new Coach(coachName));
        }
        return coaches;
    }
    
    private WeeklyMenus makeMenuRecommendation(Coaches coaches) {
        Map<Category, Integer> categoryCount = new EnumMap<>(Category.class);
        return getWeeklyMenus(coaches, categoryCount);
    }
    
    private WeeklyMenus getWeeklyMenus(Coaches coaches, Map<Category, Integer> categoryCount) {
        WeeklyMenus weeklyMenus = new WeeklyMenus();
        
        for (DayOfTheWeek dayOfTheWeek : DayOfTheWeek.values()) {
            Category category = getCategory(categoryCount);
            
            putWeeklyMenus(coaches, weeklyMenus, dayOfTheWeek, category);
            weeklyMenus.addCategory(category);
        }
        return weeklyMenus;
    }
    
    private void putWeeklyMenus(Coaches coaches, WeeklyMenus weeklyMenus, DayOfTheWeek dayOfTheWeek,
            Category category) {
        for (Coach coach : coaches.getCoaches()) {
            putWeeklyMenus(weeklyMenus, dayOfTheWeek, category, coach);
        }
    }
    
    private void putWeeklyMenus(WeeklyMenus weeklyMenus, DayOfTheWeek dayOfTheWeek, Category category, Coach coach) {
        WeeklyMenu weeklyMenu = weeklyMenus.getWeeklyMenu(coach);
        
        while (true) {
            if (putMenu(dayOfTheWeek, category, coach, weeklyMenu)) {
                break;
            }
        }
        
        weeklyMenus.putWeeklyMenu(coach, weeklyMenu);
    }
    
    private boolean putMenu(
            DayOfTheWeek dayOfTheWeek, Category category, Coach coach, WeeklyMenu weeklyMenu) {
        String menuRecommendation = weeklyMenuMaker.makeMenuRecommendation(category.getMenus());
        return weeklyMenu.putMenu(dayOfTheWeek, coach, menuRecommendation);
    }
    
    private Category getCategory(Map<Category, Integer> categoryCount) {
        Category category = weeklyMenuMaker.makeCategory();
        int count = categoryCount.getOrDefault(category, 0);
        if (count == MAX_CATEGORY_REDUPLICATION_COUNT) {
            return getCategory(categoryCount);
        }
        
        return category;
    }
    
    private void addInedibleMenus(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            getInedibleMenus(coach);
        }
    }
    
    private void getInedibleMenus(Coach coach) {
        List<String> inedibleMenus = inputView.readInedibleMenus(coach.getName());
        try {
            coach.addInedibleMenus(inedibleMenus);
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            getInedibleMenus(coach);
        }
    }
}
