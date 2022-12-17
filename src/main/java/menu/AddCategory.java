package menu;

import java.util.ArrayList;
import java.util.List;

public class AddCategory {
    public List<Menu> add(List<Menu> menu){
        menu.add(addJapan(menu));
        menu.add(addKorean(menu));
        menu.add(addChinese(menu));
        menu.add(addAsian(menu));
        menu.add(addAmerican(menu));
        return menu;
    }

    private Menu addAmerican(List<Menu> menu) {
        String foodname = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니";
        return addMenu(foodname,"양식",menu);
    }

    private Menu addAsian(List<Menu> menu) {
        String foodname = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜";
        return addMenu(foodname,"아시안",menu);
    }

    private Menu addChinese(List<Menu> menu) {
        String foodname = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";
        return addMenu(foodname,"중식",menu);
    }

    private Menu addKorean(List<Menu> menu) {
        String foodname = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음";
        return addMenu(foodname,"한식",menu);
    }

    private Menu addJapan(List<Menu> menu) {
        String foodname = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼";
        return addMenu(foodname,"일식",menu);
    }
    private Menu addMenu(String foodName,String category,List<Menu> menu){
        List<String> countryFood = new ArrayList<>();
        String[] food = foodName.split(",");
        for(int i=0; i<food.length; i++)
            countryFood.add(food[i]);
        return (new Menu(category,countryFood));
    }

}
