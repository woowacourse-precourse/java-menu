package menu.view;

import menu.constant.Category;
import menu.constant.Message;
import menu.model.Coach;
import menu.model.Menu;

import java.util.List;

public class OutputView {

    public static void printServiceStartMessage(){
        System.out.println(Message.SERVICE_START_MESSAGE);
    }

    public static void printServiceFinishMessage(){
        System.out.println();
        System.out.println(Message.SERVICE_FINISH_MESSAGE);
    }

    public static void printGetCoachNamesMessage(){
        System.out.println();
        System.out.println(Message.GET_COACH_NAMES_MESSAGE);
    }

    public static void printGetBanFoodsMessage(String coachName){
        System.out.println();
        String output = coachName + Message.GET_BAN_FOODS_MESSAGE;
        System.out.println(output);
    }

    public static void printRecommendationResultMessage(){
        System.out.println();
        System.out.println(Message.RECOMMENDATION_RESULT_MESSAGE);
    }

    public static void printDays(){
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    public static void printCategories(List<Category> categories){
        String output = "[ 카테고리";
        for(Category category : categories){
            output += " | ";
            output += category.getName();
        }
        output += " ]";
        System.out.println(output);
    }

    public static void printRecommendedMenus(Coach coach){
        String output = "[ " + coach.getName();
        List<Menu> menus = coach.getMenusOfWeek();
        for(Menu menu : menus){
            output += " | ";
            output += menu.getMenuName();
        }
        output += " ]";
        System.out.println(output);
    }

    public static void printErrorMessage(String error){
        System.out.println();
        System.out.println(error);
    }



}
