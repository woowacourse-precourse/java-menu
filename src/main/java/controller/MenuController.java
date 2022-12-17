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
    
    private final InputView inputView;
    private final OutputView outputView;
    private final WeeklyMenuMaker weeklyMenuMaker;
    
    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.weeklyMenuMaker = new WeeklyMenuMaker(new WeeklyRandomMenuMakerGenerator());
    }
    
    public void run() {
        outputView.printStartService();
        Coaches coaches = getCoaches();
        addInedibleMenus(coaches);
        WeeklyMenus weeklyMenus = makeMenuRecommendation(coaches);
        outputView.printMenuRecommendation(coaches, weeklyMenus);
        outputView.printEndOfService();
    }
    
    private WeeklyMenus makeMenuRecommendation(Coaches coaches) {
        Map<Category, Integer> categoryCount = new EnumMap<>(Category.class);
        WeeklyMenus weeklyMenus = new WeeklyMenus();
        
        for (DayOfTheWeek dayOfTheWeek : DayOfTheWeek.values()) {
            Category category = getCategory(categoryCount);
            
            for (Coach coach : coaches.getCoaches()) {
                putWeeklyMenus(weeklyMenus, dayOfTheWeek, category, coach);
            }
            weeklyMenus.addCategory(category);
        }
        return weeklyMenus;
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
    
    private boolean putMenu(DayOfTheWeek dayOfTheWeek, Category category, Coach coach, WeeklyMenu weeklyMenu) {
        String menuRecommendation = weeklyMenuMaker.makeMenuRecommendation(category.getMenus());
        return weeklyMenu.putMenu(dayOfTheWeek, coach, menuRecommendation);
    }
    
    private Category getCategory(Map<Category, Integer> categoryCount) {
        Category category = weeklyMenuMaker.makeCategory();
        int count = categoryCount.getOrDefault(category, 0);
        if (count == 2) {
            return getCategory(categoryCount);
        }
        
        return category;
    }
    
    private void addInedibleMenus(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            List<String> inedibleMenus = inputView.readInedibleMenus(coach.getName());
            coach.addInedibleMenus(inedibleMenus);
        }
    }
    
    private Coaches getCoaches() {
        List<String> coachNames = inputView.readCoachNames();
        
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            coaches.add(new Coach(coachName));
        }
        return new Coaches(coaches);
    }
}
