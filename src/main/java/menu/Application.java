package menu;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import javax.xml.transform.Result;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {

    public static List<String> coachNames = new ArrayList<>();
    public static List<List<String>> coaches = new ArrayList<>();
    public static List<String> categories = new ArrayList<>(Arrays.asList("일식","한식","중식","아시안","양식"));
    public static List<List<String>> menus = new ArrayList<>(Arrays.asList(
            Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"),
            Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),
            Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),
            Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"),
            Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")));
    public static List<String> ResultOfCategory = new ArrayList<>();
    public static List<String> ResultOfMenu = new ArrayList<>();

    public static List<List<String>> ResultPrinting = new ArrayList<>();

    public static int coachNumber = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameProcess();
    }
    public static void GameProcess() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
        GetName();
        System.out.println(coaches);
        RecommendCategory();
        GetResult();
        PrintResult();
    }

    public static void GetName(){
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String name = Console.readLine();
        String[] cNames = name.split(",");
        coachNumber = cNames.length;
        for (int i = 0; i < coachNumber; i++) {
            coachNames.add(cNames[i].trim());
        }
        for (int i = 0; i < coachNumber; i++) {
            coaches.add(NoFood(coachNames.get(i)));
        }
    }

    public static List<String> NoFood(String name){
        List<String> food = new ArrayList<>();
        System.out.println("\n"+name+"(이)가 못 먹는 메뉴를 입력해 주세요.");
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
            String category = categories.get(Randoms.pickNumberInRange(1, 5)-1);
            check[categories.indexOf(category)]++;//인덱스 카테고리의 값에 +1해주기
            if(check[categories.indexOf(category)]<=2){
                ResultOfCategory.add(category);
                GetRecommendMenu(category);
            }
        }
    }
    public static void GetRecommendMenu(String category){
        for (int i = 0; i < coachNumber; i++) {
            RecommendMenu(category,i);
        }
    }

    public static void RecommendMenu(String category, int index){
        String menu = Randoms.shuffle(menus.get(categories.indexOf(category))).get(0);
        while(true){
            if(coaches.get(index).contains(menu)){
                menu = Randoms.shuffle(menus).get(categories.indexOf(category)).get(0);
            }
            if(!(coaches.get(index).contains(menu))){
                break;
            }
        }
        ResultOfMenu.add(menu);
    }


    public static void GetResult(){
        for (int i = 0; i < coachNumber; i++) {
            GetMenu(i);
        }
    }

    public static void GetMenu(int index){
        List<String> result = new ArrayList<>();
        result.add(coachNames.get(index));
        for (int i = index; i < ResultOfMenu.size(); i+=coachNumber) {
            result.add(ResultOfMenu.get(i));
        }
        ResultPrinting.add(result);
    }


    public static void PrintResult(){
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        PrintCategory();
        PrintCoaches();
        System.out.println("\n추천을 완료했습니다.");
    }

    public static void PrintCategory(){
        System.out.print("[ 카테고리 ");
        for (int i = 0; i < 5; i++) {
            System.out.print("| "+ResultOfCategory.get(i)+" ");
        }
        System.out.println("]");
    }
    public static void PrintCoaches(){
        for (int i = 0; i < coachNumber; i++) {
            PrintCoach(i);
        }
    }
    public static void PrintCoach(int index){
        for (int i = 0; i < ResultPrinting.get(index).size(); i++) {
            System.out.print("| "+ResultPrinting.get(index).get(i)+" ");
        }
        System.out.println("]");
    }
}
