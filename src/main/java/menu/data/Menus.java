package menu.data;

import menu.model.Category;

import java.util.*;

public class Menus {
    private Map<Integer, List<String>> menus;

    private List<String> japanMenus = new ArrayList<>(Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
    private List<String> koreaMenus = new ArrayList<>(Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
    private List<String> chinaMenus = new ArrayList<>(Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
    private List<String> asiaMenus = new ArrayList<>(Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
    private List<String> westMenus = new ArrayList<>(Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    public Menus() {
        this.menus = new HashMap<>();
        menus.put(Category.JAPAN.getCountry(), japanMenus);
        menus.put(Category.KOREA.getCountry(), koreaMenus);
        menus.put(Category.CHINA.getCountry(), chinaMenus);
        menus.put(Category.ASIA.getCountry(), asiaMenus);
        menus.put(Category.WEST.getCountry(), westMenus);
    }

    public List<String> giveCountryMenus(int country) {
        return menus.get(country);
    }

}
