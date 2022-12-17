package menu.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";
    public static final String END_MESSAGE = "메뉴 추천 결과입니다.\n";
    private static final String START_LINE = "[ %s ";
    private static final String MIDDLE_LINE  = "| %s ";
    private static final String END_LINE = "| %s ]";
    private static final List<String> DAYS = new ArrayList<>(Arrays.asList("구분", "월요일", "화요일" ,"수요일" ,"목요일","금요일"));

    public void printStart(){
        System.out.println(START_MESSAGE);
    }

    public void printEnd(){
        System.out.println(END_MESSAGE);
    }
    public void printDays(){
        System.out.printf(START_LINE,DAYS.get(0));
        for(int i=1;i<DAYS.size()-1;i++){
            System.out.printf(MIDDLE_LINE,DAYS.get(i));
        }
        System.out.printf(END_LINE,DAYS.get(DAYS.size()-1));
        System.out.println();
    }

    public void printCategory(List<String> allCategory){
        System.out.printf(START_LINE,"카테고리");
        for(int i=0;i<DAYS.size()-1;i++){
            System.out.printf(MIDDLE_LINE,allCategory.get(i));
        }
        System.out.printf(END_LINE,allCategory.get(4));
        System.out.println();

    }
    public void printRecommendFoods(Map<String, List<String>> recommendFoods) {
        for (String coach : recommendFoods.keySet()) {
            System.out.printf(START_LINE, coach);
            for (int i = 0; i < recommendFoods.get(coach).size() - 1; i++) {
                System.out.printf(MIDDLE_LINE, recommendFoods.get(coach).get(i));
            }
            System.out.printf(END_LINE, recommendFoods.get(coach).get(4));

        }
    }

}
