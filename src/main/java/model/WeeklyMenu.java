package model;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeeklyMenu {
    
    private final Map<Coach, Menus> menusOfCoach;
    
    private final Map<DayOfTheWeek, Menus> weeklyMenu;
    
    public WeeklyMenu() {
        this.menusOfCoach = new HashMap<>();
        this.weeklyMenu = new EnumMap<>(DayOfTheWeek.class);
    }
    
    public List<String> findMenusByCoach(DayOfTheWeek dayOfTheWeek) {
        return weeklyMenu.get(dayOfTheWeek).getMenus();
    }
    
    public boolean putMenu(DayOfTheWeek dayOfTheWeek, Coach coach, String menu) {
        if (canPut(coach, menu)) {
            putMenus(dayOfTheWeek, coach, menu);
            return true;
        }
        
        return false;
    }
    
    private boolean canPut(Coach coach, String menu) {
        if (isInedibleMenu(coach, menu)) {
            return false;
        }
        
        return !isMenuReduplication(coach, menu);
    }
    
    private void putMenus(DayOfTheWeek dayOfTheWeek, Coach coach, String menu) {
        Menus menus = findMenusByCoach(menu, coach);
        this.weeklyMenu.put(dayOfTheWeek, findMenusByDayOfTheWeek(dayOfTheWeek, menus));
    }
    
    private Menus findMenusByCoach(String menu, Coach coach) {
        Menus menus = menusOfCoach.getOrDefault(coach, new Menus());
        menus.addMenu(menu);
        return menus;
    }
    
    private Menus findMenusByDayOfTheWeek(DayOfTheWeek dayOfTheWeek, Menus menus) {
        return this.weeklyMenu.getOrDefault(dayOfTheWeek, menus);
    }
    
    private boolean isInedibleMenu(Coach coach, String menu) {
        return coach.isContains(menu);
    }
    
    private boolean isMenuReduplication(Coach coach, String menu) {
        Menus menus = menusOfCoach.getOrDefault(coach, new Menus());
        return menus.isMenuReduplication(menu);
    }
}
