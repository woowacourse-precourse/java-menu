package menu.domain;


import java.util.Arrays;
import java.util.List;

public enum Category {

    JAPAN("일식",1, Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREA("한식",2, Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE("중식", 3, Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN("아시안", 4, Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN("양식", 5, Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    private String category;
    private int number;
    private List<String> menus;

    Category(String category, int number,  List<String> menus) {
        this.category = category;
        this.number = number;
        this.menus = menus;
    }

    // 숫자에 따를 카테고리르 제공하는 기능
    public static String getCategory (int num) {
        String category = "";
        if(num == JAPAN.number) {
            category = JAPAN.category;
        } else if(num == KOREA.number) {
            category = KOREA.category;
        } else if(num == CHINESE.number) {
            category = CHINESE.category;
        } else if(num == ASIAN.number) {
            category = ASIAN.category;
        } else if (num == WESTERN.number) {
            category = WESTERN.category;
        }
        return category;
    }

    // 카테고리에 따른 메뉴를 제공하는 기능
    public static List<String> getmenu (String category) {
        List<String> menu = null;
        if(category == JAPAN.category) {
            menu = JAPAN.menus;
        } else if(category == KOREA.category) {
            menu = KOREA.menus;
        } else if(category == CHINESE.category) {
            menu = CHINESE.menus;
        } else if(category == ASIAN.category) {
            menu = ASIAN.menus;
        } else if (category == WESTERN.category) {
            menu = WESTERN.menus;
        }
        return menu;
    }
}
