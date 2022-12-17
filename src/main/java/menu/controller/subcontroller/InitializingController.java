package menu.controller.subcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.repository.CategoryRepository;
import menu.domain.repository.MenuRepository;
import menu.domain.status.ApplicationStatus;
import menu.view.InputView;
import menu.view.OutputView;

public class InitializingController implements Controllable {
    public static final List<String> CATEGORIES = List.of("일식", "한식", "중식", "아시안", "양식");
    public static Map<String, List<String>> ALL_MENUS_IN_CATEGORIES = new HashMap<>();
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

    static {
        ALL_MENUS_IN_CATEGORIES.put("일식", JAPANESE_MENUS);
        ALL_MENUS_IN_CATEGORIES.put("한식", KOREAN_MENUS);
        ALL_MENUS_IN_CATEGORIES.put("중식", CHINESE_MENUS);
        ALL_MENUS_IN_CATEGORIES.put("아시안", ASIAN_MENUS);
        ALL_MENUS_IN_CATEGORIES.put("양식", WESTERN_MENUS);
    }


    private final InputView inputView;
    private final OutputView outputView;

    public InitializingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public ApplicationStatus process() {
        initializeCategories();
        initializeMenus();
        return ApplicationStatus.RECEIVE_COACH_DATA;
    }

    private static void initializeMenus() {
        for (Map.Entry<String, List<String>> element : ALL_MENUS_IN_CATEGORIES.entrySet()) {
            CategoryRepository.add(new Category(element.getKey()));
            List<Menu> menusInCategory = getMenus(element.getValue());
            addMenus(menusInCategory);
            CategoryRepository.findByName(element.getKey()).addMenusToCategory(menusInCategory);
        }
    }

    private static void initializeCategories() {
        CATEGORIES.stream().map(Category::new).forEach(CategoryRepository::add);
    }

    private static void addMenus(List<Menu> menus) {
        menus.forEach(MenuRepository::add);
    }

    private static List<Menu> getMenus(List<String> menus) {
        return menus.stream().map(Menu::new).collect(Collectors.toList());
    }
}
