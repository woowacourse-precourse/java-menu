package menu;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static List<List<String>> coaches = new ArrayList<List<String>>();
    public static List<String> categories = new ArrayList<>(Arrays.asList("일식","한식","중식","아시안","양식"));
    public static List<List<String>> menus = new ArrayList<>(Arrays.asList(
            Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"),
            Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),
            Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),
            Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"),
            Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")));
    public static List<String> ResultOfCategory = new ArrayList<>();
    public static List<List<String>> ResultOfMenu = new ArrayList<>();

    public static int coachNumber = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameProcess();
    }
    public static void GameProcess() {
        GetName();
        System.out.println(coaches);
        RecommendCategory();
    }

    public static void GetName(){
        List<String> coachNames = new ArrayList<>();
        String name = Console.readLine();
        String[] cNames = name.split(",");
        coachNumber = cNames.length;
        for (int i = 0; i < coachNumber; i++) {
            coachNames.add(cNames[i].trim());
        }
        System.out.println("coach name:"+coachNames);
        for (int i = 0; i < coachNumber; i++) {
            coaches.add(NoFood(coachNames.get(i)));
        }
    }

    public static List<String> NoFood(String name){
        List<String> food = new ArrayList<>();
        System.out.println(name+"이 못 먹는 음식");
        String foodName = Console.readLine();
        String[] foods = foodName.split(",");
        for (int i = 0; i < foods.length; i++) {
            food.add(foods[i].trim());
        }
        return food;
    }

    public static void RecommendCategory(){
        int[] check = {0, 0, 0, 0, 0};
        while(true) {
            if(ResultOfCategory.size()==5) break;
            String category = categories.get(Randoms.pickNumberInRange(1, 5));
            check[categories.indexOf(category)]++;//인덱스 카테고리의 값에 +1해주기
            System.out.println(Arrays.toString(check));
            if(check[categories.indexOf(category)]<=2){
                ResultOfCategory.add(category);
                System.out.println(ResultOfCategory);
            }
        }
    }

    public static String RecommendMenu(String category, int index){
        String menu = Randoms.shuffle(menus).get(categories.indexOf(category)).get(0);
        while(true){
            if(coaches.get(index).contains(menu)){
                menu = Randoms.shuffle(menus).get(categories.indexOf(category)).get(0);
            }
            if(!(coaches.get(index).contains(menu))){
                break;
            }
        }
        return menu;
    }
}
