package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.CategoryRepository;

import java.util.List;

public class CategoryService {
    private static final List<String> categoryNames = List.of("일식", "한식", "중식", "아시안", "양식");
    private static final List<List<String>> foodNames = List.of(
            List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"),
            List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),
            List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),
            List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"),
            List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")
    );

    public void initialize() {
        CategoryRepository.deleteAll();
        while (CategoryRepository.categories().size() < 5) {
            int categoryIndex = Randoms.pickNumberInRange(1, 5) - 1;
            String categoryName = categoryNames.get(categoryIndex);
            List<String> categoryFoods = foodNames.get(categoryIndex);
            if (CategoryRepository.getCountByName(categoryName) < 2) {
                CategoryRepository.addCategory(new Category(categoryName));
                CategoryRepository.getCategoryByName(categoryName).addCategoryFood(categoryFoods);
            }
        }
    }
}
