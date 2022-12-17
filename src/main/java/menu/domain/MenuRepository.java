package menu.domain;

import menu.utills.constants.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRepository {
    private final static List<Menu> menus = new ArrayList<>();

    public static void initialize() {
        generateJapan();
        generateKorea();
        generateChina();
        generateAsia();
        generateWestern();
    }

    private static void generateJapan() {
        menus.add(new Menu(Category.JAPAN, "규동"));
        menus.add(new Menu(Category.JAPAN, "미소시루"));
        menus.add(new Menu(Category.JAPAN, "스시"));
        menus.add(new Menu(Category.JAPAN, "가츠동"));
        menus.add(new Menu(Category.JAPAN, "오니기리"));
        menus.add(new Menu(Category.JAPAN, "하이라이스"));
        menus.add(new Menu(Category.JAPAN, "라멘"));
        menus.add(new Menu(Category.JAPAN, "오코노미야끼"));
    }

    private static void generateKorea() {
        menus.add(new Menu(Category.KOREA, "김밥"));
        menus.add(new Menu(Category.KOREA, "쌈밥"));
        menus.add(new Menu(Category.KOREA, "된장찌개"));
        menus.add(new Menu(Category.KOREA, "비빔밥"));
        menus.add(new Menu(Category.KOREA, "칼국수"));
        menus.add(new Menu(Category.KOREA, "불고기"));
        menus.add(new Menu(Category.KOREA, "떡볶이"));
        menus.add(new Menu(Category.KOREA, "제육볶음"));
    }

    private static void generateChina() {
        menus.add(new Menu(Category.CHINA, "깐풍기"));
        menus.add(new Menu(Category.CHINA, "볶음면"));
        menus.add(new Menu(Category.CHINA, "동파육"));
        menus.add(new Menu(Category.CHINA, "짜장면"));
        menus.add(new Menu(Category.CHINA, "짬뽕"));
        menus.add(new Menu(Category.CHINA, "마파투부"));
        menus.add(new Menu(Category.CHINA, "탕수육"));
        menus.add(new Menu(Category.CHINA, "토마토달걀볶음"));
        menus.add(new Menu(Category.CHINA, "고추잡채"));
    }

    private static void generateAsia() {
        menus.add(new Menu(Category.ASIA, "팟타이"));
        menus.add(new Menu(Category.ASIA, "카오 팟"));
        menus.add(new Menu(Category.ASIA, "나시고렝"));
        menus.add(new Menu(Category.ASIA, "파인애플 볶음밥"));
        menus.add(new Menu(Category.ASIA, "쌀국수"));
        menus.add(new Menu(Category.ASIA, "똠양꿍"));
        menus.add(new Menu(Category.ASIA, "반미"));
        menus.add(new Menu(Category.ASIA, "월남쌈"));
        menus.add(new Menu(Category.ASIA, "분짜"));
    }

    private static void generateWestern() {
        menus.add(new Menu(Category.WESTERN, "라자냐"));
        menus.add(new Menu(Category.WESTERN, "그라탱"));
        menus.add(new Menu(Category.WESTERN, "뇨끼"));
        menus.add(new Menu(Category.WESTERN, "끼슈"));
        menus.add(new Menu(Category.WESTERN, "프렌치 토스트"));
        menus.add(new Menu(Category.WESTERN, "바게트"));
        menus.add(new Menu(Category.WESTERN, "스파게티"));
        menus.add(new Menu(Category.WESTERN, "피자"));
        menus.add(new Menu(Category.WESTERN, "파니니"));
    }

    public static Menu getMenuByName(String name) {
        return menus.stream()
                .filter(menu -> menu.isEqualName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
    }

    public static List<String> getMenuNamesByCategory(Category category) {
        return menus.stream()
                .filter(menu -> menu.isEqualCategory(category))
                .map(Menu::getName)
                .collect(Collectors.toList());
    }
}
