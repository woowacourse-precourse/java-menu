package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public enum Categories {
    JAPAN(1, "일식", Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREA(2, "한식", Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINA(3, "중식", Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIA(4, "아시안", Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    AMERICA(5, "양식", Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final int index;
    private final String name;
    private final List<String> menuNames;

    Categories(int index, String name, List<String> menuNames) {
        this.index = index;
        this.name = name;
        this.menuNames = menuNames;
    }

    public static Categories getCategoryBYIndex(int index) {
        Categories type = null;
        for (Categories category : Categories.values()) {
            if (category.getIndex() == index) type = category;
        }
        return type;
    }

//    public static String getShuffledMenu(Categories categories) {
////        System.out.println(categories);
//        List<String> menus = categories.getMenuNames();
////        System.out.println(menus.toString());
//        String menu = Randoms.shuffle(menus).get(0);
////        System.out.println(menu);
//        return menu;
//    }

    public static String getShuffledMenu(Categories categories) {
        ShuffleGeneratorImpl shuffleGenerator = new ShuffleGeneratorImpl();
        List<String> menus = categories.getMenuNames();
        String menu = shuffleGenerator.generate(menus).get(0);
//        System.out.println(menu);
        return menu;
    }

    public int getIndex() {
        return index;
    }

    public List<String> getMenuNames() {
        return menuNames;
    }

    public String getName() {
        return name;
    }
}
