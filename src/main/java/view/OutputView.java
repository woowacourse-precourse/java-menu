package view;

import model.Coach;
import model.Coaches;
import model.DayOfTheWeek;
import model.WeeklyMenu;
import model.WeeklyMenus;

public class OutputView {
    
    private static final String START_SERVICE_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String MENU_RECOMMENDATION_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String DELIMITER = " | ";
    private static final String MENU_NAMES_OF_COACH_MESSAGE = "[ %s | %s ]%n";
    private static final String DIVISION_MESSAGE = "[ 구분 | %s ]%n";
    private static final String CATEGORY_MESSAGE = "[ 카테고리 | %s ]%n";
    private static final String END_OF_SERVICE_MESSAGE = "추천을 완료했습니다.";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    
    public void printStartService() {
        System.out.println(START_SERVICE_MESSAGE);
    }
    
    public void printMenuRecommendation(Coaches coaches, WeeklyMenus weeklyMenus) {
        System.out.println(MENU_RECOMMENDATION_MESSAGE);
        printColumnName(weeklyMenus);
        
        for (Coach coach : coaches.getCoaches()) {
            String menuNamesOfCoach = getMenuNamesOfCoach(weeklyMenus, coach);
            System.out.printf(OutputView.MENU_NAMES_OF_COACH_MESSAGE, coach.getName(), menuNamesOfCoach);
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
        System.out.printf(DIVISION_MESSAGE, String.join(DELIMITER, DayOfTheWeek.getNames()));
        System.out.printf(CATEGORY_MESSAGE, String.join(DELIMITER, weeklyMenus.getCategories()));
    }
    
    private String getMenus(WeeklyMenu weeklyMenu, DayOfTheWeek dayOfTheWeek) {
        return weeklyMenu.findMenusByCoach(dayOfTheWeek).toString()
                .replace("[", "")
                .replace("]", "");
    }
    
    public void printEndOfService() {
        System.out.println(END_OF_SERVICE_MESSAGE);
    }
    
    public void printError(IllegalArgumentException e) {
        System.out.println(ERROR_MESSAGE + e.getMessage());
    }
}
