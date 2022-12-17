package menu.domain;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public enum Category {
    JAPAN(1, "일식",Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREA(2, "한식",Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINA(3, "중식",Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN(4, "아시안",Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN(5, "일식",Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final int key;
    private final String name;
    private final List<String> menus ;

    Category(int key, String name, List<String> menus) {
        this.key = key;
        this.name = name;
        this.menus = menus;
    }

    public static String validateAndGetMenuName(String userInput) {
        for (Category category : Category.values()){
            for(String menu :category.menus){
                if(menu.equals(userInput)) return menu;
            }
        }
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴를 입력하셨습니다.");
    }

    public static Category getRandomCategory() {
        int randomNumber = Randoms.pickNumberInRange(1, 5);
        for (Category category : Category.values()){
            if(category.key == randomNumber) return category;
        }
        return getRandomCategory();
    }

    public String getRandomMenu() {
        return Randoms.shuffle(menus).get(0);
    }
}
