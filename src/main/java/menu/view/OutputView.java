package menu.view;

import menu.resource.Category;
import menu.resource.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static String START_RECOMMEND = "점심 메뉴 추천을 시작합니다.";
    private static String MENU_RESULT = "메뉴 추천 결과입니다.";
    private static String OPEN = "[ ";
    private static String TYPE ="구분";
    private static String CATEGORY = "카테고리";
    private static String MID = " | ";
    private static String END = " ]";
    private static String GAME_END = "\n추천을 완료했습니다.";

    public void printStart(){
        System.out.println(START_RECOMMEND);
    }
    public void printMenuResult(List<List<String>> coachMenu, Map<Day, Category> categoryInOrder){
        List<String> days = new ArrayList<>();
        List<String> categorys = new ArrayList<>();
        changeMapToStringList(categoryInOrder, days, categorys);
        System.out.println(MENU_RESULT);
        printDay(days);
        printCategory(categorys);
        printEachCoach(coachMenu);
        System.out.println(GAME_END);
    }

    private void changeMapToStringList(Map<Day, Category> categoryInOrder, List<String> days, List<String> categorys) {
        for(Day day: categoryInOrder.keySet()){
            days.add(day.getName());
            categorys.add(categoryInOrder.get(day).getName());
        }
    }

    private void printDay(List<String> days) {
        System.out.print(OPEN+TYPE+MID);
        printEachList(days);
        System.out.println(END);
    }

    private void printCategory(List<String> categorys) {
        System.out.print(OPEN+CATEGORY+MID);
        printEachList(categorys);
        System.out.println(END);
    }

    private void printEachCoach(List<List<String>> coachMenu) {
        for(int i = 0; i< coachMenu.size(); i++){
            System.out.print(OPEN);
            printEachList(coachMenu.get(i));
            System.out.println(END);
        }
    }

    public void printEachList(List<String> information){
        for(int i=0;i<information.size();i++){
            System.out.print(information.get(i));
            if(i != information.size()-1){
                System.out.print(MID);
            }
        }
    }
}
