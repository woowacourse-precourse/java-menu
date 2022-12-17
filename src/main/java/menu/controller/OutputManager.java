package menu.controller;

import menu.model.coach.Coach;
import menu.model.menu.Category;
import menu.model.menutable.WeeklyMenuTable;
import menu.view.ConsoleOutputView;

import java.util.List;

public class OutputManager {
    ConsoleOutputView outputView;

    public OutputManager() {
        outputView = new ConsoleOutputView();
    }

    public void printStart() {
        outputView.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printEnd() {
        outputView.println("추천을 완료했습니다.");
    }

    public void printWeeklyMenuTable(List<Category> categoryList, List<Coach> coachList, WeeklyMenuTable menuTable) {
        outputView.println("메뉴 추천 결과입니다.");
        outputView.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        outputView.print("[ 카테고리 |");
        for(int i = 0; i < 5; i++) {
            Category category = categoryList.get(i);
            outputView.print(" " + category.name() + " ");
            if(i != 5) {
                outputView.print("|");
            }
        }
        outputView.println("]");

        for(Coach coach : coachList) {
            outputView.print("[ " + coach.getName() + " |");
            for(int i = 0; i < 5; i++) {
                outputView.print(menuTable.getMenu(i, " " + coach.getName() + " "));
                if(i != 5) {
                    outputView.print("|");
                }
            }
            outputView.println("]");
        }
    }

    public void printError(String errorText) {
        System.out.println("[ERROR] " + errorText);
    }
}
