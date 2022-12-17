package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Category {
    JAPAN(1,"규동,우동,미소시루,스시,가츠동,오니기리,하이라이스,라멘,오코노미야끼","일식"),
    KOREA(2,"김밥,김치찌개,쌈밥,된장찌개,비빔밥,칼국수,불고기,떡볶이,제육볶음","한식"),
    CHINA(3,"깐풍기,볶음면,동파육,짜장면,짬뽕,마파두부,탕수육,토마토 달걀볶음,고추잡채","중식"),
    ASIA(4,"팟타이,카오 팟,나시고렝,파인애플 볶음밥,쌀국수,똠얌꿍,반미,월남쌈,분짜","아시안"),
    WEST(5,"라자냐,그라탱,뇨끼,끼슈,프렌치 토스트,바게트,스파게티,피자,파니니","양식");

    private final int number;
    private final String name;
    private final List<String> menus = new ArrayList<>();

    Category(int number,String csvMenus,String name) {
        this.number = number;
        this.name = name;
        set(csvMenus);
    }

    private void set(String csvMenus){
        for(String menu :csvMenus.split(",")){
            menus.add(menu);
        }
    }
    public List<String> getMenus(){
        return Collections.unmodifiableList(menus);
    }



    public static Category of(int number) {
        for (Category category : Category.values()) {
            if (category.number == number) {
                return category;
            }
        }
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 카테고리입니다.");
    }

    public static Category of(String menu) {
        for (Category category : Category.values()) {
            if (category.menus.contains(menu)) {
                return category;
            }
        }
        throw new IllegalArgumentException("[ERROR] 해당카테고리에 음식이 존재하지 않습니다.");
    }

    public String getName(){
        return name;
    }
}
