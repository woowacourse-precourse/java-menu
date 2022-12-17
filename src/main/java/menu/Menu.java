package menu;

import java.util.Arrays;
import java.util.List;

public class Menu {

    public Menu() {
    }

    public List<String> getMenu(String category) {
        String categoryMenu = categoryToMenu(category);
        List<String> menuAll = Arrays.asList(categoryMenu.split(","));
        return menuAll;
    }

    public String categoryToMenu(String category) {
        if (category == CategoryMenu.JAPAN.getCategory()) {
            return CategoryMenu.JAPAN.getMenu();
        }
        if (category == CategoryMenu.KOREA.getCategory()) {
            return CategoryMenu.KOREA.getMenu();
        }
        if (category == CategoryMenu.CHINA.getCategory()) {
            return CategoryMenu.CHINA.getMenu();
        }
        if (category == CategoryMenu.ASIAN.getCategory()) {
            return CategoryMenu.ASIAN.getMenu();
        }
        return CategoryMenu.WESTERN.getMenu();
    }

}

enum CategoryMenu {

    JAPAN("일식", "규동,우동,미소시루,스시,가츠동,오니기리,하이라이스,라멘,오코노미야끼"),
    KOREA("한식", "김밥,김치찌개,쌈밥,된장찌개,비빔밥,칼국수,불고기,떡볶이,제육볶음"),
    CHINA("중식", "깐풍기,볶음면,동파육,짜장면,짬뽕,마파두부,탕수육,토마토 달걀볶음,고추잡채"),
    ASIAN("아시안", "팟타이,카오 팟,나시고렝,파인애플 볶음밥,쌀국수,똠얌꿍,반미,월남쌈,분짜"),
    WESTERN("양식", "라자냐,그라탱,뇨끼,끼슈,프렌치 토스트,바게트,스파게티,피자,파니니");

    private final String category;
    private final String menu;

    CategoryMenu(String category, String menu) {
        this.category = category;
        this.menu = menu;
    }

    public String getCategory() {
        return this.category;
    }

    public String getMenu() {
        return this.menu;
    }
}