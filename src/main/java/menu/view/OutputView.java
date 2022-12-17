package menu.view;

import java.util.List;

public class OutputView {

    public void initMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n"
                + "\n"
                + "코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void askCoachHate(String name) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", name);
    }

    public void printResultInit() {
        System.out.println("메뉴 추천 결과입니다.\n"
                + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    public void printCategory(List<String> categories) {
        String message = "[ 카테고리 | ";
        for (int i = 0; i < categories.size(); i++) {
            message += categories.get(i) + " | ";
        }
        System.out.println(message.substring(0, message.length() - 2) + "]");
    }

    public void printCoachMenu(String coachName, List<String> chosenMenu) {
        String message = "[ ";
        message += coachName + " | ";
        for (int i = 0; i < chosenMenu.size(); i++) {
            message += chosenMenu.get(i) + " | ";
        }
        System.out.println(message.substring(0, message.length() - 2) + "]");
    }

    public void printEnd(){
        System.out.println("추천을 완료했습니다. ");
    }
}
