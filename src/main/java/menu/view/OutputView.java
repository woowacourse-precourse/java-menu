package menu.view;

import java.util.List;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public static void startMessage(){
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public static void resultMessage(){
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    public static void categoryMessage(List<String> categorys){
        System.out.println(String.format("[ 카테고리 | %s ]", insertLine(categorys)));
    }

    public static String insertLine(List<String> categorys){
        return String.join(" | ", categorys);
    }

    public static void endMessage(){
        System.out.println("추천을 완료했습니다.");
    }
}
