package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CategoryRepository {

    private static List<Category> categories = new ArrayList<>();

    public static void initCategories() {
        categories.add(Category.of("일식", new ArrayList<String>(Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"))));
        categories.add(Category.of("한식", new ArrayList<String>(Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"))));
        categories.add(Category.of("중식", new ArrayList<String>(Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토", "달걀볶음", "고추잡채"))));
        categories.add(Category.of("아시안", new ArrayList<String>(Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"))));
        categories.add(Category.of("양식", new ArrayList<String>(Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"))));
    }

    public static List<Category> getCategories() {
        return categories;
    }

    public static Category pickRandomCategory() {
        int randomNumber = Randoms.pickNumberInRange(1, 5);
        Category pickedCategory = categories.get(randomNumber-1);
        return pickedCategory;
    }


    public static String pickMenu(Category selectedCategory) {
        List<String> copiedMenuList = List.copyOf(selectedCategory.getMenus());
        String menu = Randoms.shuffle(copiedMenuList).get(0);
        return menu;
    }
}
