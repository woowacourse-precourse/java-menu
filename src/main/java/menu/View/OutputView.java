package menu.View;

import menu.Coach;
import menu.Constant.Menu;

import java.util.List;

import static menu.Constant.Message.*;

public class OutputView {

    public void printRecommendResult(List<Menu> categories, List<Coach> coaches){
        System.out.println(MSG_PRINT_RESULT);
        System.out.println(MSG_RESULT_DAYS);
        printCategory(categories);
        printCoachesResult(coaches);
        System.out.println(MSG_END);
    }

    public void printCategory(List<Menu> categories){
        String text = "[ 카테고리";
        for(Menu category: categories){
            text += " | " + category.getCategory();
        }
        text += " ]";
        System.out.println(text);
    }

    public void printCoachesResult(List<Coach> coaches){
        for(Coach coach: coaches){
            String text = "[ " + coach.getName();
            for(String curMenu: coach.getRecommended()){
                text += " | " + curMenu;
            }
            text += " ]";
            System.out.println(text);
        }
    }

}
