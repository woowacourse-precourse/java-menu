package menu.domain.repository;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;

public class Repository {

    public static List<Category> categories = new ArrayList<>();

    public static List<String> weeks = List.of("월요일","화요일","수요일","목요일","금요일");

    static {
        String[] japan = {"규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"};
        categories.add(new Category("일식", List.of(japan)));
        String[] korea = {"김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"};
        categories.add(new Category("한식", List.of(korea)));
        String[] china = {"깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"};
        categories.add(new Category("중식", List.of(china)));
        String[] asia = {"팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"};
        categories.add(new Category("아시안", List.of(asia)));
        String[] western = {"라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"};
        categories.add(new Category("양식", List.of(western)));
    }

    public static Category categoryOf(int categoryNum){
        return categories.get(categoryNum-1);
    }





}
