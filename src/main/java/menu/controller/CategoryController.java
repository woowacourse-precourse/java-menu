package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Category;

public class CategoryController {
    private List<Category> categorys;
    private List<List<String>> menus;

    public CategoryController() {
        this.categorys = new ArrayList<>();
        this.menus = new ArrayList<>();
        init();
        initMenus();
    }

    private void init() {
        List<String> categoryMenu = List.of("일식", "한식", "중식", "아시안", "양식");
        for (String menu : categoryMenu) {
            categorys.add(new Category(menu));
        }

    }

    private void initMenus() {
        List<String> menu1 = List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
        List<String> menu2 = List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
        List<String> menu3 = List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
        List<String> menu4 = List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
        List<String> menu5 = List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니");
        this.menus = List.of(menu1, menu2, menu3, menu4, menu5);
        for (int i = 0; i < categorys.size(); i++) {
            categorys.get(i).addMenu(menus.get(i));
        }
    }

    public List<String> selectWeekMenuCategory() {
        List<String> weekCategory = new ArrayList<>();

        do {

            String categoryName = categorys.get(getRandomNumber()).getName();
            weekCategory.add(categoryName);
            if (Collections.frequency(weekCategory, categoryName) > 2) {
                weekCategory.remove(weekCategory.size() - 1);
            }

        } while (weekCategory.size() != 5);

        return weekCategory;
    }

    public int getRandomNumber() {
        int i = -1;
        while (true) {
            try {
                i = Randoms.pickNumberInRange(0, 4);
                if (i > 4) {
                    throw new IllegalArgumentException("[ERROR] 랜덤에러");
                }
                break;
            } catch (IllegalArgumentException e) {

            }

        }

        return i;

    }

    public List<Category> weekCategory() {
        List<Category> result = new ArrayList<>();
        List<String> strings = selectWeekMenuCategory();
        for (String string : strings) {
            for (Category category : categorys) {
                if (category.getName().equals(string)) {
                    result.add(category);
                }
            }
        }

        return result;
    }


    public List<Category> getCategorys() {
        return categorys;
    }

    public List<List<String>> getMenus() {
        return menus;
    }
}
