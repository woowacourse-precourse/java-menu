package menu.controller;

import menu.model.menutable.WeeklyMenuTable;
import menu.view.ConsoleOutputView;

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

    public void printWeeklyMenuTable(WeeklyMenuTable menuTable) {
        // TODO 구현 필요
    }

    public void printError(String errorText) {
        System.out.println("[ERROR] " + errorText);
    }
}
