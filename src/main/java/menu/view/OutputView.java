package menu.view;

public class OutputView {
    public static void startRecommendView(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }
    public static void resultView(){
        System.out.println("메뉴 추천 결과입니다.");
    }
    public static void weekView(){
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }
    public static void categoryView(){
        System.out.println("[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]");
    }
    public static void coachMenuView(String name, String[] foods){
        System.out.print("[ " + name);
        for(String food:foods){
            System.out.print(" | " + food);
        }
        System.out.println();
    }
    public static void endRecommendView(){
        System.out.print("추천을 완료했습니다.");
    }
}
