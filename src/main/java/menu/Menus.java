package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menus {

    private List<String> japaneseMenus;
    private List<String> koreanMenus;
    private List<String> chineseMenus;
    private List<String> asianMenus;
    private List<String> westernMenus;

    public Menus() {
        this.japaneseMenus = createJapaneseMenus();
        this.koreanMenus = createKoreanMenus();
        this.chineseMenus = createChineseMenus();
        this.asianMenus = createAsianMenus();
        this.westernMenus = createWesternMenus();
    }

    private List<String> createWesternMenus() {
        return new ArrayList<>(Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    }

    private List<String> createAsianMenus() {
        return new ArrayList<>(Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
    }

    private List<String> createChineseMenus() {
        return new ArrayList<>(Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
    }

    private List<String> createKoreanMenus() {
        return new ArrayList<>(Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
    }

    private List<String> createJapaneseMenus() {
        return new ArrayList<>(Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
    }

    public List<String> getCategoryMenus(String categoryName){
        if(categoryName.equals("일식"))
            return japaneseMenus;
        if(categoryName.equals("한식"))
            return koreanMenus;
        if(categoryName.equals("중식"))
            return chineseMenus;
        if(categoryName.equals("아시안"))
            return asianMenus;
        if(categoryName.equals("양식"))
            return westernMenus;
        throw new IllegalArgumentException("[ERROR] 카테고리 이름이 잘못되었습니다.");
    }
}
