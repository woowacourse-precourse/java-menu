package menu.constants;

import java.util.ArrayList;
import java.util.List;

public class CategoryAndMenuDefinition {

    public static List<String> japaneseFood;
    public static List<String> koreanFood;
    public static List<String> chineseFood;
    public static List<String> asian;
    public static List<String> westernCuisine;

    public void Category() {
        japaneseFoodMenu();
        koreanFoodMenu();
        chineseFoodMenu();
        asianMenu();
        westernCuisineMenu();
    }

    public void japaneseFoodMenu() {
        japaneseFood = new ArrayList<>();
        String foods = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼";

        for (String food : foods.split(",")) {
            japaneseFood.add(food);
        }
    }

    public void koreanFoodMenu() {
        koreanFood = new ArrayList<>();
        String foods = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음";

        for (String food : foods.split(",")) {
            koreanFood.add(food);
        }
    }

    public void chineseFoodMenu() {
        chineseFood = new ArrayList<>();
        String foods = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";

        for (String food : foods.split(",")) {
            chineseFood.add(food);
        }
    }

    public void asianMenu() {
        asian = new ArrayList<>();
        String foods = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";

        for (String food : foods.split(",")) {
            asian.add(food);
        }
    }

    public void westernCuisineMenu() {
        westernCuisine = new ArrayList<>();
        String foods = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니";

        for (String food : foods.split(",")) {
            westernCuisine.add(food);
        }
    }
}

