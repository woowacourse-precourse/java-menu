package menu.view;


import java.util.List;

public class OutputView {

    public static void printStart(){
        System.out.println("점심 메뉴 추천을 시작합니다.\n\n코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public static void printUnableMenu(String coach){
        System.out.println(coach + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public static void printCategory(List<String> categoryNames){
        System.out.println("[ 카테고리 | "+String.join(" | ",categoryNames) + " ]");
    }

    public static void printResult(){
        System.out.println("메뉴 추천 결과입니다.\n" +
                "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

}
