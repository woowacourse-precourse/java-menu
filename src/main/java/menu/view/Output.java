package menu.view;

import menu.Coach;

import java.util.List;

public class Output {
    public static void printResult(List<Coach> coachList){
        System.out.println("메뉴 추천 결과입니다.\n" +
                "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n" +
                "[ 카테고리 | 한식 | 양식 | 일식 | 중식 | 아시안 ]");
        coachList.forEach(coach -> System.out.println(coach.getPrintForm()));
        System.out.println("추천을 완료했습니다.");
    }
}
