package menu;

import java.util.List;

public class OutputView {
    private final String ERROR = "[ERROR] ";

    public void printErrorMessage(String e){
        System.out.println(ERROR + e);
    }

    public void printResultTitle(){
        System.out.println("메뉴 추천 결과입니다.\n" + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    public void printStart(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public void printEnd(){
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

    public void printCategory(Category[] categories, List<Integer> dailyCategory){
        System.out.print("[ 카테고리 ");
        for (int num : dailyCategory){
            System.out.print("| " + categories[num - 1].getCategoryName());
        }
        System.out.print(" ]");
        System.out.println();
    }

    public void printRecommendedFood(Coach coach){
        String str = String.join(" | ", coach.getRecommendedFood());
        System.out.println("[ " + coach.getName() + " | " + str + " ]");
    }
}
