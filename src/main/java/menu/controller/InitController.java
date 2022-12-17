package menu.controller;

import menu.domain.category.Category;
import menu.domain.category.CategoryRepository;
import menu.domain.category.CategoryType;
import menu.domain.menu.MenuRepository;

import java.util.List;
import java.util.Map;

public class InitController {
    // 저장순서가 유지된다.
    private final static Map<String, List<String>> map = Map.of(
            "일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"),
            "한식", List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼구수", "불고기", "떡볶이", "제육볶음"),
            "중식", List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),
            "아시안", List.of("팟타이", "카오 팟", "나시고랭", "파인애플 볶음밥", "쌀국수", "똠양꿍", "반미", "월남쌈", "분짜"),
            "양식", List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")
    );
    MenuRepository menuRepository;
    CategoryRepository categoryRepository;

    public InitController() {
        this.menuRepository = MenuRepository.getInstance();
        this.categoryRepository = CategoryRepository.getInstance();
    }

    // 간략화 할 수 있는 방법 찾아보기
    public void run() {
        initCategoryAndMenuRepository();
    }

    private void initCategoryAndMenuRepository() {
        for (String categoryName : map.keySet()) {
            Category category = new Category(categoryName);
            int categoryId = CategoryType.getIndexByKorean(categoryName);
            categoryRepository.save(categoryId, category);
            initMenuRepository(category);
        }
    }


    private void initMenuRepository(Category category) {
        for (String menuNames : map.get(category.getName())) {
            menuRepository.save(category, menuNames);
        }
    }
}
