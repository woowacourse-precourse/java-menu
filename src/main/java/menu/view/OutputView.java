package menu.view;

public class OutputView {

    private static final String INIT_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    public void printInit(){
        System.out.println(INIT_MESSAGE);
    }

    public void printErrorMessage(Exception e){
        System.out.println(e.getMessage());
    }
}
