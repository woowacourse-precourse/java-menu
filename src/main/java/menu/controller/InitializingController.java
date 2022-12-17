package menu.controller;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.CategoryRepository;
import menu.domain.Menu;
import menu.domain.MenuRepository;

public class InitializingController implements Controllable {

    public static final List<String> CATEGORIES = List.of("일식", "한식", "중식", "아시안", "양식");
    public static final List<String> JAPANESE_MENUS = List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리",
            "하이라이스", "라멘", "오코노미야끼");
    public static final List<String> KOREAN_MENUS = List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수",
            "불고기", "떡볶이", "제육볶음");
    public static final List<String> CHINESE_MENUS = List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕",
            "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
    public static final List<String> ASIAN_MENUS = List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥",
            "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
    public static final List<String> WESTERN_MENUS = List.of("라자냐", "그라탱", "뇨끼", "끼슈", " 프렌치 토스트",
            "바게트", "스파게티", "피자", "파니니");

    @Override
    public void process() {
        initializeCategories();
        initializeMenus();
    }

    private static void initializeCategories() {
        CATEGORIES.stream().map(Category::new).forEach(CategoryRepository::add);
    }

    private static void initializeMenus() {
        List<Menu> japaneseMenus = getMenus(JAPANESE_MENUS);
        List<Menu> koreanMenus = getMenus(KOREAN_MENUS);
        List<Menu> chineseMenus = getMenus(CHINESE_MENUS);
        List<Menu> asianMenus = getMenus(ASIAN_MENUS);
        List<Menu> westernMenus = getMenus(WESTERN_MENUS);

        addMenus(japaneseMenus);
        addMenus(koreanMenus);
        addMenus(chineseMenus);
        addMenus(asianMenus);
        addMenus(westernMenus);

        CategoryRepository.findByName("일식").addMenusToCategory(japaneseMenus);
        CategoryRepository.findByName("한식").addMenusToCategory(koreanMenus);
        CategoryRepository.findByName("중식").addMenusToCategory(chineseMenus);
        CategoryRepository.findByName("아시안").addMenusToCategory(asianMenus);
        CategoryRepository.findByName("양식").addMenusToCategory(westernMenus);
    }

    private static void addMenus(List<Menu> japaneseMenus) {
        japaneseMenus.forEach(MenuRepository::add);
    }

    private static List<Menu> getMenus(List<String> japaneseMenus) {
        return japaneseMenus.stream().map(Menu::new).collect(Collectors.toList());
    }
}
