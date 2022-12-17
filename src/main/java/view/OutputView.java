package view;

import model.Coach;
import model.Coaches;
import model.DayOfTheWeek;
import model.WeeklyMenu;
import model.WeeklyMenus;

public class OutputView {
    
    private static final String DELIMITER = " | ";
    
    public void printStartService() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }
    
    public void printMenuRecommendation(Coaches coaches, WeeklyMenus weeklyMenus) {
        System.out.println("메뉴 추천 결과입니다.");
        printColumnName(weeklyMenus);
        
        for (Coach coach : coaches.getCoaches()) {
            String menuNamesOfCoach = getMenuNamesOfCoach(weeklyMenus, coach);
            System.out.printf("[ %s | %s ]%n", coach.getName(), menuNamesOfCoach);
        }
    }
    
    private String getMenuNamesOfCoach(WeeklyMenus weeklyMenus, Coach coach) {
        StringBuilder stringBuilder = new StringBuilder();
        for (DayOfTheWeek dayOfTheWeek : DayOfTheWeek.values()) {
            stringBuilder.append(getMenus(weeklyMenus.getWeeklyMenu(coach), dayOfTheWeek)).append(DELIMITER);
        }
        
        stringBuilder.setLength(stringBuilder.length() - DELIMITER.length());
        return stringBuilder.toString();
    }
    
    private void printColumnName(WeeklyMenus weeklyMenus) {
        System.out.printf("[ 구분 | %s ]%n", String.join(DELIMITER, DayOfTheWeek.getNames()));
        System.out.printf("[ 카테고리 | %s ]%n", String.join(DELIMITER, weeklyMenus.getCategories()));
    }
    
    private String getMenus(WeeklyMenu weeklyMenu, DayOfTheWeek dayOfTheWeek) {
        return weeklyMenu.findMenusByCoach(dayOfTheWeek).toString()
                .replace("[", "")
                .replace("]", "");
    }
    
    public void printEndOfService() {
        System.out.println("추천을 완료했습니다.");
    }
}
