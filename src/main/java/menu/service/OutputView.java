package menu.service;

import menu.domain.Coach;
import menu.domain.ConstantMessage;
import menu.domain.DayOfTheWeek;

import static menu.domain.ConstantMessage.*;
import static menu.domain.DayOfTheWeek.*;

import java.util.*;
public class OutputView {

    public void printMenuRecommendStartMessage(){
        System.out.println(MENU_RECOMMEND_START_MESSAGE);
    }

    public void printRequestCoachNameMessage(){
        System.out.println(REQUEST_INPUT_COACH_NAME_MESSAGE);
    }

    public void printRequestCoachCanNotEatMenuMessage(String coachName){System.out.println(coachName + REQUEST_INPUT_COACH_NOT_EAT_MENU_MESSAGE);}

    public void printMenuRecommendResultMessage(){
        System.out.println(MENU_RECOMMEND_RESULT_MESSAGE);
    }

    public void printDayOfTheWeekMessage(){
        System.out.println(DAY_OF_THE_WEEK_MESSAGE);
    }

    public void printMenuRecommendFinishMessage(){
        System.out.println(RECOMMEND_FINISH_MESSAGE);
    }

    public void printCategoryByDayOfTheWeek(List<String> categoryDayOfTheWeek){
        System.out.println("[ 카테고리 | "
                + categoryDayOfTheWeek.get(월요일.getNum())
                + " | " + categoryDayOfTheWeek.get(화요일.getNum())
                + " | " + categoryDayOfTheWeek.get(수요일.getNum())
                + " | " + categoryDayOfTheWeek.get(목요일.getNum())
                + " | "+ categoryDayOfTheWeek.get(금요일.getNum())+" ]" );
    }

    public void printRecommendedMenuByCoach(List<Coach> coaches){
        for (Coach coach : coaches) {
            System.out.println("[ "+ coach.name +" | "
                    + coach.menuRecommendResult.get(월요일.getNum())
                    + " | " + coach.menuRecommendResult.get(화요일.getNum())
                    + " | " + coach.menuRecommendResult.get(수요일.getNum())
                    + " | " +  coach.menuRecommendResult.get(목요일.getNum())
                    + " | " +  coach.menuRecommendResult.get(금요일.getNum()) + " ]");
        }
    }

    public void printInValidCoachNameLengthErrorMessage(){System.out.println(INVALID_COACH_NAME_LENGTH_ERROR_MESSAGE);}

    public void printInValidCoachCountErrorMessage(){
        System.out.println(INVALID_COACH_COUNT_ERROR_MESSAGE);
    }

    public void printInValidCoachCanNotEatMenuCountErrorMessage(){System.out.println(INVALID_COACH_CAN_NOT_EAT_MENU_COUNT_ERROR_MESSAGE);}

}
