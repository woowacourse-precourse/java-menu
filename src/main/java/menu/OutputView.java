package menu;

public class OutputView {
    private final String ERROR = "[ERROR] ";

    public void printErrorMessage(String e){
        System.out.println(ERROR + e);
    }

    public void printResultTitle(){
        System.out.println("메뉴 추천 결과입니다.\n" + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    public void printRecommendedFood(Coach coach){
        System.out.println(coach);
    }
}
